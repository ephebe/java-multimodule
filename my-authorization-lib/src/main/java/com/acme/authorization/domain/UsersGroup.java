package com.acme.authorization.domain;

import com.acme.authorization.domain.entities.UsersGroupEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroup {
    @Getter
    private final UsersGroupEntity srcEntity;
    private final UsersGroups usersGroups;
    private final UsersGroupUsers users;
    private final UsersGroupHierarchies hierarchies;
    private final UsersGroupPermissions permissions;

    public UUID getId() {
        return srcEntity.getId();
    }

    public void switchParent(UsersGroup parent) {
        parent.hierarchies.removeDescendant(this.srcEntity.getId());
        srcEntity.setParentId(parent.srcEntity.getId());
        usersGroups.save(this);
    }

    public UsersGroup addChild(String usersGroupName) {
        UsersGroup child = this.usersGroups.findUsersGroupByName(usersGroupName);
        if(child == null) {
            child = this.usersGroups.add(usersGroupName);
        }

        child.switchParent(this);

        if(!this.hierarchies.exists(this.getId(),child.getId()))
            this.hierarchies.addHierarchy(this.getId(),child.getId());

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


    public interface UsersGroupUsers {
        List<UsersGroupUser> findByUsersGroupId(UUID usersGroupId);
        void removeAll();
        void add(UsersGroup usersGroup,User user);
    }

    public interface UsersGroupHierarchies {
        Boolean exists(UUID ancestorId,UUID descendorId);
        List<UsersGroupsHierarchy> findDescendants(UUID ancestorId);
        void addHierarchy(UUID ancestorId,UUID usersGroupId);
        void removeDescendant(UUID usersGroupId);

        List<UsersGroupsHierarchy> findAncestors(UUID descendorId);
        void removeAncestor(UUID usersGroupId);
    }

    public interface UsersGroupPermissions {
        void deleteAll();
    }
}
