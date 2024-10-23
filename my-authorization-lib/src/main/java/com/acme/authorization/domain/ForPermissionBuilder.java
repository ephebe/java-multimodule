package com.acme.authorization.domain;

public interface ForPermissionBuilder {
    OnPermissionBuilder For(User user);

    OnPermissionBuilder For(UsersGroup group);

    OnPermissionBuilder For(String usersGroupName);
}
