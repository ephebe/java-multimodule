package com.acme.authorization.infrastructure.repository;

import com.acme.authorization.domain.entities.UsersGroupUserEntity;
import com.acme.authorization.domain.entities.UsersGroupUserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UsersGroupUserRepository extends JpaRepository<UsersGroupUserEntity, UsersGroupUserId> {
    List<UsersGroupUserEntity> findByUsersGroupId(UUID usersGroupId);
}
