package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.Permission;
import com.acme.authorization.domain.Permissions;
import com.acme.authorization.domain.users.User;
import com.acme.authorization.domain.users_groups.UsersGroup;

import java.util.List;

public class PermissionsImpl implements Permissions {
    @Override
    public List<Permission> findByUserOpersionName(User user, String operation) {
        return null;
    }

    @Override
    public List<Permission> findByUsersGroupOperationName(UsersGroup userGroup, String operation) {
        return null;
    }

    @Override
    public List<Permission> findAll() {
        return null;
    }

    @Override
    public List<Permission> findPermissionsFor(User user) {
        return null;
    }

    @Override
    public <TEntity> List<Permission> GetPermissionsFor(User user, TEntity tEntity) {
        return null;
    }

    @Override
    public List<Permission> findGlobalPermissionsFor(User user, String operationName) {
        return null;
    }

    @Override
    public List<Permission> findPermissionsFor(String operationName) {
        return null;
    }

    @Override
    public <TEntity> List<Permission> findPermissionsFor(User user, TEntity tEntity, String operationName) {
        return null;
    }

    @Override
    public <TEntity> List<Permission> findPermissionsFor(TEntity tEntity) {
        return null;
    }

    @Override
    public void remove(Permission permission) {

    }
}
