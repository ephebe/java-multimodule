package com.acme.authorization.domain;

import com.acme.authorization.domain.entities.UsersGroupEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroup {
    private final UsersGroupEntity srcEntity;
    private final UsersGroupParent parent;
    private final UsersGroupUsers users;
    private final UsersGroupChilds childs;
    private final UsersGroupHierarchies hierarchies;
    private final UsersGroupPermissions permissions;

    public void switchParent(UsersGroup parent) {
        parent.hierarchies.removeDescendant(this.srcEntity.getId());
        srcEntity.setParentId(parent.srcEntity.getId());
    }

    public UsersGroup addChild(String usersGroupName) {
        UsersGroup child = this.childs.findByName(usersGroupName);
        if(child == null) {
            child = this.childs.add(usersGroupName);
            this.hierarchies.addDescendant(child.srcEntity.getId());
        }

        return child;
    }

    public void associateUser(User user) {
        this.users.add(user);
    }

    public UsersGroup getParent() {
        return this.parent.get();
    }

    public List<UsersGroupsHierarchy> getDescendants() {
        return this.hierarchies.findDescendants();
    }

    public List<UsersGroupsHierarchy> getAncestors() {
        return this.hierarchies.findAncestors();
    }

    public List<UsersGroup> getChilds() {
        return this.childs.findAll();
    }

    public List<UsersGroupUser> getUsersGroupUsers() {
        return this.users.findAll();
    }

    public interface UsersGroupParent {
        UsersGroup get();
    }
    public interface UsersGroupUsers {
        List<UsersGroupUser> findAll();
        void removeAll();
        void add(User user);
    }
    public interface UsersGroupChilds {
        List<UsersGroup> findAll();
        UsersGroup findByName(String usersGroupName);
        UsersGroup add(String usersGroupName);
        int count();
    }

    public interface UsersGroupHierarchies {
        List<UsersGroupsHierarchy> findDescendants();
        void addDescendant(UUID usersGroupId);
        void removeDescendant(UUID usersGroupId);

        List<UsersGroupsHierarchy> findAncestors();
        void addAncestor(UUID usersGroupId);
        void removeAncestor(UUID usersGroupId);
    }

    public interface UsersGroupPermissions {
        void deleteAll();
    }
}
