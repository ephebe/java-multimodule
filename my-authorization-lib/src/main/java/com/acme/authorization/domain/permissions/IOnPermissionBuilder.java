package com.acme.authorization.domain.permissions;

import com.acme.authorization.domain.entities_groups.EntitiesGroup;
import com.acme.authorization.domain.permissions.ILevelPermissionBuilder;

public interface IOnPermissionBuilder {
    <TEntity> ILevelPermissionBuilder On(TEntity entity);

    ILevelPermissionBuilder On(EntitiesGroup entity);

    ILevelPermissionBuilder On(String entitiesGroupName);

    ILevelPermissionBuilder OnEverything();
}
