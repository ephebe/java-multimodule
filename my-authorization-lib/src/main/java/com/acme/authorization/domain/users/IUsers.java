package com.acme.authorization.domain.users;

import java.util.UUID;

public interface IUsers {
    User findByName(String name);

    User findById(UUID userId);

    void add(User user);
}
