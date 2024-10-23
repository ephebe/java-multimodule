package com.acme.authorization.domain.permissions;

import com.acme.authorization.domain.entities_groups.EntitiesGroup;
import com.acme.authorization.domain.users.User;
import com.acme.authorization.domain.users_groups.UsersGroup;

public class FluentPermissionBuilder implements IForPermissionBuilder,
        IOnPermissionBuilder, ILevelPermissionBuilder, IPermissionBuilder {
    @Override
    public IOnPermissionBuilder For(User user) {
        return null;
    }

    @Override
    public IOnPermissionBuilder For(UsersGroup group) {
        return null;
    }

    @Override
    public IOnPermissionBuilder For(String usersGroupName) {
        return null;
    }

    @Override
    public <TEntity> ILevelPermissionBuilder On(TEntity tEntity) {
        return null;
    }

    @Override
    public ILevelPermissionBuilder On(EntitiesGroup entity) {
        return null;
    }

    @Override
    public ILevelPermissionBuilder On(String entitiesGroupName) {
        return null;
    }

    @Override
    public ILevelPermissionBuilder OnEverything() {
        return null;
    }

    @Override
    public IPermissionBuilder Level(int level) {
        return null;
    }

    @Override
    public IPermissionBuilder DefaultLevel() {
        return null;
    }

    @Override
    public Permission Save() {
        return null;
    }

    @Override
    public Permission Build() {
        return null;
    }


}
