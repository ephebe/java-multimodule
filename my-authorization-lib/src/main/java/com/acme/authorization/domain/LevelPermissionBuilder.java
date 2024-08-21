package com.acme.authorization.domain;

public interface LevelPermissionBuilder {
    PermissionBuilder Level(int level);
    PermissionBuilder DefaultLevel();
}
