package com.acme.authorization.infrastructure.repository;

import com.acme.authorization.domain.UsersGroupsHierarchy;
import com.acme.authorization.domain.entities.UsersGroupEntity;
import com.acme.authorization.domain.entities.UsersGroupsHierarchyEntity;
import com.acme.authorization.domain.entities.UsersGroupsHierarchyId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface UsersGroupHierarchyRepository extends JpaRepository<UsersGroupsHierarchyEntity, UsersGroupsHierarchyId> {
    List<UsersGroupsHierarchyEntity> findDescendants(UUID usersGroupId);
    UsersGroupsHierarchy Build(UsersGroupsHierarchyEntity usersGroupsHierarchyEntity);

    List<UsersGroupsHierarchyEntity> findAncestors(UUID usersGroupId);
}
