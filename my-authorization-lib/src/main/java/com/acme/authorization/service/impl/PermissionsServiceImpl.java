package com.acme.authorization.service.impl;

import com.acme.authorization.domain.Permission;
import com.acme.authorization.domain.User;
import com.acme.authorization.service.PermissionsService;

import java.util.List;

public class PermissionsServiceImpl implements PermissionsService {
    @Override
    public List<Permission> GetPermissionsFor(User user) {
        return null;
    }

    @Override
    public <TEntity> List<Permission> GetPermissionsFor(User user, TEntity tEntity) {
        return null;
    }

    @Override
    public List<Permission> GetGlobalPermissionsFor(User user, String operationName) {
        return null;
    }

    @Override
    public List<Permission> GetPermissionsFor(String operationName) {
        return null;
    }

    @Override
    public <TEntity> List<Permission> GetPermissionsFor(User user, TEntity tEntity, String operationName) {
        return null;
    }

    @Override
    public <TEntity> List<Permission> GetPermissionsFor(TEntity tEntity) {
        return null;
    }
}
