package com.acme.authorization.domain;

import com.acme.authorization.domain.entities.UsersGroupsHierarchyEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UsersGroupsHierarchy {
    private final UsersGroupsHierarchyEntity srcEntity;
    private final UsersGroupsHierarchy.UsersGroupsAncestor ancestor;
    private final UsersGroupsHierarchy.UsersGroupsDescendant descendant;

    public interface UsersGroupsAncestor {
        UsersGroup get();
    }

    public interface UsersGroupsDescendant {
        UsersGroup get();
    }
}
