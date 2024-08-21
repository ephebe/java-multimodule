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
    @Query(nativeQuery = true,value="SELECT FROM USERSGROUPUSERS A INNER JOIN USERS B ON A.UserId = B.Id WHERE A.UserGroupId=:userGroupId")
    List<UserEntity> findUsersGroupUsers(UUID usersGroupId);

    User build(UserEntity entity);
}
