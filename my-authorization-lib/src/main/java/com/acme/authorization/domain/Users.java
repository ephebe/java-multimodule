package com.acme.authorization.domain;

public interface Users {
    User findByName(String name);

    void add(User user);
}
