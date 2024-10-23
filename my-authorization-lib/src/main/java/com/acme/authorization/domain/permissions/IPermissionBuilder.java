package com.acme.authorization.domain.permissions;

import com.acme.authorization.domain.permissions.Permission;

public interface IPermissionBuilder {
    Permission Save();

    Permission Build();
}
