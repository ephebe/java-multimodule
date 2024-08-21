package com.acme.authorization.infrastructure.repository;

import com.acme.authorization.domain.EntitiesGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntitiesGroupRepository extends JpaRepository<EntitiesGroup, UUID> {
}
