package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.UsersGroup;
import com.acme.authorization.infrastructure.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UsersGroupPermissionsImpl implements UsersGroup.UsersGroupPermissions {
    private final PermissionRepository repository;
    @Override
    public void deleteAll() {

    }
}
