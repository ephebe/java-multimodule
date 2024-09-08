package com.acme.authorization.infrastructure.repository;

import com.acme.authorization.domain.UsersGroup;
import com.acme.authorization.domain.entities.UsersGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersGroupRepository extends JpaRepository<UsersGroupEntity, UUID> {
    Optional<UsersGroupEntity> findOneByName(String name);
    List<UsersGroupEntity> findByParentId(UUID parentId);
}
