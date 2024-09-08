package com.acme.authorization.infrastructure.repository;

import com.acme.authorization.domain.EntitiesGroup;
import com.acme.authorization.domain.User;
import com.acme.authorization.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    @Query(value="SELECT b FROM UsersGroupUserEntity a INNER JOIN UserEntity b ON a.userId = b.id WHERE a.usersGroupId=?1")
    List<UserEntity> findUsersGroupUsers(UUID usersGroupId);
}
