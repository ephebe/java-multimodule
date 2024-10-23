package com.acme.authorization.domain;

import com.acme.authorization.domain.users.User;
import com.acme.authorization.domain.users_groups.UsersGroup;

public interface ForPermissionBuilder {
    OnPermissionBuilder For(User user);

    OnPermissionBuilder For(UsersGroup group);

    OnPermissionBuilder For(String usersGroupName);
}
