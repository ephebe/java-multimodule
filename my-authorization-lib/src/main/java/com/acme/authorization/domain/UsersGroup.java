package com.acme.authorization.domain;

import com.acme.authorization.domain.UsersGroups.IUsersGroups;
import com.acme.authorization.domain.UsersGroups.UsersGroupsHierarchy;
import com.acme.authorization.domain.entities.UsersGroupEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroup {
    @Getter
    private final UsersGroupEntity srcEntity;
    private final UsersGroupSelf usersGroupsSelf;
    private final UsersGroupUsers users;
    private final UsersGroupHierarchies hierarchies;
    private final UsersGroupPermissions permissions;

    public UUID getId() {
        return srcEntity.getId();
    }

    public void clearParent() {
        this.srcEntity.setParent(null);
    }

    public void clearHierarchies() {
        this.hierarchies.removeAncestors(this.getId());
        this.hierarchies.removeDescendants(this.getId());
    }

    public UsersGroup addChild(String usersGroupName) {
        boolean hasChild = srcEntity.getChilds().stream().anyMatch(s -> s.getName().equals(usersGroupName));

        if(hasChild)
            throw new ChildExistWithSameNameException();

        UsersGroup child = usersGroupsSelf.findUsersGroupByName(usersGroupName);

        if(child != null) {
            child.clearParent();
            child.clearHierarchies();
        }  else {
            UsersGroupEntity childEntity = new UsersGroupEntity();
            childEntity.setName(usersGroupName);
            child =  new UsersGroup(childEntity,usersGroupsSelf, users, hierarchies, permissions );
        }


        this.srcEntity.getChilds().add(child.srcEntity);

        child.hierarchies.addAncestorsOfUsersGroup(this.getId(),child.getId());
        child.hierarchies.addHierarchy(this.getId(),child.getId());

        return child;
    }

    public void associateUser(User user) {
        this.users.add(this,user);
    }

    public List<UsersGroupsHierarchy> getDescendants() {
        return this.hierarchies.findDescendants(this.getId());
    }

    public List<UsersGroupsHierarchy> getAncestors() {
        return this.hierarchies.findAncestors(this.getId());
    }

    public List<UsersGroup> getChilds() {
        return this.usersGroups.findAllChilds(this.srcEntity.getId());
    }

    public List<UsersGroupUser> getUsersGroupUsers() {
        return this.users.findByUsersGroupId(this.getId());
    }

    public interface UsersGroupSelf {
        UsersGroup findUsersGroupByName(String usersGroupName);
        UsersGroup add(String usersGroupName);
    }

    public interface UsersGroupUsers {
        List<UsersGroupUser> findByUsersGroupId(UUID usersGroupId);
        void removeAll();
        void add(UsersGroup usersGroup,User user);
    }

    public interface UsersGroupHierarchies {
        Boolean exists(UUID ancestorId,UUID descendorId);
        List<UsersGroupsHierarchy> findDescendants(UUID ancestorId);
        void addAncestorsOfUsersGroup(UUID parentUsersGroupId,UUID usersGroupId);
        void addHierarchy(UUID ancestorId,UUID usersGroupId);
        void removeDescendants(UUID ancestorId);

        List<UsersGroupsHierarchy> findAncestors(UUID descendorId);
        void removeAncestors(UUID descendantId);
    }

    public interface UsersGroupPermissions {
        void deleteAll();
    }
}
