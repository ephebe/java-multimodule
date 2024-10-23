package com.acme.authorization.domain.permissions;

import com.acme.authorization.domain.permissions.IPermissionBuilder;

public interface ILevelPermissionBuilder {
    IPermissionBuilder Level(int level);
    IPermissionBuilder DefaultLevel();
}
