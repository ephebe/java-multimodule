package com.acme.authorization.domain;

import com.acme.authorization.domain.entities_groups.EntitiesGroup;

public interface OnPermissionBuilder {
    <TEntity> LevelPermissionBuilder On(TEntity entity);

    LevelPermissionBuilder On(EntitiesGroup entity);

    LevelPermissionBuilder On(String entitiesGroupName);

    LevelPermissionBuilder OnEverything();
}
