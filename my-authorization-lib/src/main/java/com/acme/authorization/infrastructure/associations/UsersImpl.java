package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.User;
import com.acme.authorization.domain.Users;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsersImpl implements Users {
    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public User findById(UUID userId) {
        return null;
    }

    @Override
    public void add(User user) {

    }
}
