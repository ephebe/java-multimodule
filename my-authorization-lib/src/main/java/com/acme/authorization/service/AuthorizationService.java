package com.acme.authorization.service;

import com.acme.authorization.domain.Permission;
import com.acme.authorization.domain.users.User;
import com.acme.authorization.domain.users_groups.UsersGroup;

import java.util.List;

public interface AuthorizationService {
    List<Permission> GetPermissions(User user, String operation);
    List<Permission> GetPermissions(UsersGroup usersgroup, String operation);
    <TEntity> boolean IsAllowed(User user, TEntity entity, String operation);
    boolean IsAllowed(User user, String operation);
}
