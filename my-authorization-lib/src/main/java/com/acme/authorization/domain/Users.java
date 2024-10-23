package com.acme.authorization.domain;

import java.util.UUID;

public interface Users {
    User findByName(String name);

    User findById(UUID userId);

    void add(User user);
}
