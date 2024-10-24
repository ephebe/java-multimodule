package com.acme.authorization.infrastructure.repository;

import com.acme.authorization.domain.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermissionRepository extends JpaRepository<PermissionEntity, UUID>  {
}
