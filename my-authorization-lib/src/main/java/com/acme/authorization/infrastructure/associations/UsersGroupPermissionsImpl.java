package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.UsersGroup;
import com.acme.authorization.infrastructure.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroupPermissionsImpl implements UsersGroup.UsersGroupPermissions {
    private final UUID usersGroupId;
    private final PermissionRepository repository;
    @Override
    public void deleteAll() {

    }
}
