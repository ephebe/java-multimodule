package com.acme.authorization.domain.permissions;

import com.acme.authorization.domain.operations.Operation;
import com.acme.authorization.domain.entities.PermissionEntity;

public class Permission {
    private PermissionEntity srcEntity;

    public static IForPermissionBuilder Allow(String operationName) {
        return new FluentPermissionBuilder();
    }

    public static IForPermissionBuilder Allow(Operation operation) {
        return new FluentPermissionBuilder();
    }

    public static IForPermissionBuilder Deny(String operationName) {
        return new FluentPermissionBuilder();
    }

    public PermissionEntity getSrcEntity() {
        return this.srcEntity;
    }
}
