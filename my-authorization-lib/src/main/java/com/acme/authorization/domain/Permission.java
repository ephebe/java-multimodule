package com.acme.authorization.domain;

import com.acme.authorization.domain.entities.PermissionEntity;

public class Permission {
    private PermissionEntity srcEntity;

    public static ForPermissionBuilder Allow(String operationName) {
        return new FluentPermissionBuilder();
    }

    public static ForPermissionBuilder Allow(Operation operation) {
        return new FluentPermissionBuilder();
    }

    public static ForPermissionBuilder Deny(String operationName) {
        return new FluentPermissionBuilder();
    }

    public PermissionEntity getSrcEntity() {
        return this.srcEntity;
    }
}
