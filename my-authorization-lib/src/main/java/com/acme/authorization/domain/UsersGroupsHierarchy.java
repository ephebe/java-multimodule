package com.acme.authorization.domain;

import com.acme.authorization.domain.entities.UsersGroupsHierarchyEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroupsHierarchy {
    private final UsersGroupsHierarchyEntity srcEntity;

    public UUID getAncestorId() {return  srcEntity.getAncestorId();}

    public UUID getDescendantId() {return  srcEntity.getDescendantId();}
}
