package com.acme.authorization.domain.users_groups;

import com.acme.authorization.domain.users.User;
import com.acme.authorization.domain.entities.UsersGroupEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroup {
    @Getter
    private final UsersGroupEntity srcEntity;
    private final IUsersGroupSelf usersGroupsSelf;
    private final IUsersGroups usersGroups;
    private final IUsersGroupUsers users;
    private final IUsersGroupHierarchies hierarchies;
    private final IUsersGroupPermissions permissions;

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

    public UsersGroup getParent() {
        return this.usersGroups.findUsersGroupById(this.srcEntity.getParentId());
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

    public interface IUsersGroupSelf {
        UsersGroup findUsersGroupByName(String usersGroupName);
        UsersGroup add(String usersGroupName);
    }
    public interface IUsersGroupUsers {
        List<UsersGroupUser> findByUsersGroupId(UUID usersGroupId);
        void removeAll();
        void add(UsersGroup usersGroup,User user);
    }

    public interface IUsersGroupHierarchies {
        Boolean exists(UUID ancestorId,UUID descendorId);
        List<UsersGroupsHierarchy> findDescendants(UUID ancestorId);
        void addHierarchy(UUID ancestorId,UUID usersGroupId);
        void removeDescendant(UUID usersGroupId);

        List<UsersGroupsHierarchy> findAncestors(UUID descendorId);
        void removeAncestor(UUID usersGroupId);
    }

    public interface IUsersGroupPermissions {
        void deleteAll();
    }
}
