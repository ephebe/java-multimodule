package com.acme.authorization.domain;

import com.acme.authorization.domain.entities.UsersToUsersGroupEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroupUser {
    private final UsersToUsersGroupEntity srcEntity;
    private final Users users;
    public interface UsersGroupUserItsUser {
        User get(UUID userId);
    }

    public User getUser() {
        return users.findById(srcEntity.getUserId());
    }
}
