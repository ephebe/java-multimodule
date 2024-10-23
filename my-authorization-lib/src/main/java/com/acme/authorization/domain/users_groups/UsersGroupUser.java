package com.acme.authorization.domain.users_groups;

import com.acme.authorization.domain.users.IUsers;
import com.acme.authorization.domain.users.User;
import com.acme.authorization.domain.entities.UsersGroupUserEntity;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroupUser {
    private final UsersGroupUserEntity srcEntity;
    private final IUsers users;
    public interface UsersGroupUserItsUser {
        User get(UUID userId);
    }

    public User getUser() {
        return users.findById(srcEntity.getUserId());
    }
}
