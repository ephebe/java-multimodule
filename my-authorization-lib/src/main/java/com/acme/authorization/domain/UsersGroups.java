package com.acme.authorization.domain;

import java.util.List;
import java.util.UUID;

public interface UsersGroups {
    UsersGroup add(String usersGroupName);
    void save(UsersGroup usersGroup);
    UsersGroup findUsersGroupByName(String name);
    UsersGroup findUsersGroupById(UUID usersGroupId);
    List<UsersGroup> findAllChilds(UUID usersGroupId);

}
