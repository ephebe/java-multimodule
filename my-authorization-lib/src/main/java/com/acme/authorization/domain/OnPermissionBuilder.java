package com.acme.authorization.domain;

public interface OnPermissionBuilder {
    <TEntity> LevelPermissionBuilder On(TEntity entity);

    LevelPermissionBuilder On(EntitiesGroup entity);

    LevelPermissionBuilder On(String entitiesGroupName);

    LevelPermissionBuilder OnEverything();
}
