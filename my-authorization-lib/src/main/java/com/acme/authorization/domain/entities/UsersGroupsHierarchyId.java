package com.acme.authorization.domain.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

public class UsersGroupsHierarchyId implements Serializable {
    private  UUID ancestorId;
    private  UUID descendantId;
}
