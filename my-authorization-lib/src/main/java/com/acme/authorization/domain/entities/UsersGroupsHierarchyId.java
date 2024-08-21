package com.acme.authorization.domain.entities;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroupsHierarchyId implements Serializable {
    private final UUID ancestorId;
    private final UUID descendantId;
}
