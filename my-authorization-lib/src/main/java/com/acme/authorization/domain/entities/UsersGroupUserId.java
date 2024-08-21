package com.acme.authorization.domain.entities;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroupUserId implements Serializable {
    private final UUID usersGroupId;

    private final UUID userId;
}
