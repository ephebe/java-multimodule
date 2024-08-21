package com.acme.authorization.domain;

import com.acme.authorization.domain.entities.UsersGroupUserEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroupUser {
    private final UsersGroupUserEntity srcEntity;
    private final UsersGroupUserItsUser associateUser;
    public interface UsersGroupUserItsUser {
        User get(UUID userId);
    }

    public User getUser() {
        return associateUser.get(srcEntity.getUserId());
    }
}
