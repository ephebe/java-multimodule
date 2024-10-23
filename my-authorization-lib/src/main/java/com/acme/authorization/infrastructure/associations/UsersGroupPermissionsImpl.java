package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.users_groups.UsersGroup;
import com.acme.authorization.infrastructure.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UsersGroupPermissionsImpl implements UsersGroup.UsersGroupPermissions {
    private final PermissionRepository repository;
    @Override
    public void deleteAll() {

    }
}
