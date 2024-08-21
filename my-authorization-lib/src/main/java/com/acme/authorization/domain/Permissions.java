package com.acme.authorization.domain;

import java.util.List;

public interface Permissions {
    List<Permission> findByUserOpersionName(User user, String operation);
    List<Permission> findByUsersGroupOperationName(UsersGroup userGroup, String operation);
    List<Permission> findAll();

    List<Permission> findPermissionsFor(User user);

    <TEntity> List<Permission> GetPermissionsFor(User user, TEntity entity);
    List<Permission> findGlobalPermissionsFor(User user, String operationName) ;
    List<Permission> findPermissionsFor(String operationName) ;
    <TEntity> List<Permission> findPermissionsFor(User user, TEntity entity, String operationName);
    <TEntity> List<Permission> findPermissionsFor(TEntity entity);

    void remove(Permission permission);
}
