package com.acme.authorization.infrastructure.repository;

import com.acme.authorization.domain.entities.UsersGroupsHierarchyEntity;
import com.acme.authorization.domain.entities.UsersGroupsHierarchyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UsersGroupHierarchyRepository extends JpaRepository<UsersGroupsHierarchyEntity, UsersGroupsHierarchyId> {

    List<UsersGroupsHierarchyEntity> findByAncestorId(UUID usersGroupId);

    @Query("select a from UsersGroupsHierarchyEntity a where a.descendantId=?1")
    List<UsersGroupsHierarchyEntity> findByDescendantId(UUID usersGroupId);
}
