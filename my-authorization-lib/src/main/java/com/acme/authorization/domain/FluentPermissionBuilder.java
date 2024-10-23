package com.acme.authorization.domain;

public class FluentPermissionBuilder implements ForPermissionBuilder,
        OnPermissionBuilder,LevelPermissionBuilder,PermissionBuilder {
    @Override
    public OnPermissionBuilder For(User user) {
        return null;
    }

    @Override
    public OnPermissionBuilder For(UsersGroup group) {
        return null;
    }

    @Override
    public OnPermissionBuilder For(String usersGroupName) {
        return null;
    }

    @Override
    public <TEntity> LevelPermissionBuilder On(TEntity tEntity) {
        return null;
    }

    @Override
    public LevelPermissionBuilder On(EntitiesGroup entity) {
        return null;
    }

    @Override
    public LevelPermissionBuilder On(String entitiesGroupName) {
        return null;
    }

    @Override
    public LevelPermissionBuilder OnEverything() {
        return null;
    }

    @Override
    public PermissionBuilder Level(int level) {
        return null;
    }

    @Override
    public PermissionBuilder DefaultLevel() {
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
