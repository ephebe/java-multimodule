package com.acme.authorization.infrastructure.repository;

import com.acme.authorization.domain.UsersGroupUser;
import com.acme.authorization.domain.entities.UsersGroupEntity;
import com.acme.authorization.domain.entities.UsersGroupUserEntity;
import com.acme.authorization.domain.entities.UsersGroupUserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public interface UsersGroupUserRepository extends JpaRepository<UsersGroupUserEntity, UsersGroupUserId> {
    List<UsersGroupUserEntity> findByUsersGroupId(UUID usersGroupId);
    UsersGroupUser build(UsersGroupUserEntity entity);
}
