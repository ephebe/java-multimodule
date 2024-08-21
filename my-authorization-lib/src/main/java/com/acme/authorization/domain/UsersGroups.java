package com.acme.authorization.domain;

public interface UsersGroups {
    UsersGroup add(String usersGroupName);
    UsersGroup findUsersGroupByName(String name);

}
