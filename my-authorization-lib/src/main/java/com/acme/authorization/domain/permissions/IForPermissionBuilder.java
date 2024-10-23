package com.acme.authorization.domain.permissions;

import com.acme.authorization.domain.users.User;
import com.acme.authorization.domain.users_groups.UsersGroup;

public interface IForPermissionBuilder {
    IOnPermissionBuilder For(User user);

    IOnPermissionBuilder For(UsersGroup group);

    IOnPermissionBuilder For(String usersGroupName);
}
