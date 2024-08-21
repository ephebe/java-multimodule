package com.acme.authorization.infrastructure.repository;

import com.acme.authorization.domain.EntitiesGroup;
import com.acme.authorization.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermissionRepository extends JpaRepository<Permission, UUID>  {
}
