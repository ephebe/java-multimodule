package com.acme.authorization.service;

import com.acme.authorization.domain.Permission;
import com.acme.authorization.domain.users.User;

import java.util.List;

public interface PermissionsService {
    List<Permission> GetPermissionsFor(User user);
    <TEntity> List<Permission> GetPermissionsFor(User user, TEntity entity);
    List<Permission> GetGlobalPermissionsFor(User user, String operationName);
    List<Permission> GetPermissionsFor(String operationName) ;
    <TEntity> List<Permission> GetPermissionsFor(User user, TEntity entity, String operationName);
    <TEntity> List<Permission> GetPermissionsFor(TEntity entity);
}
