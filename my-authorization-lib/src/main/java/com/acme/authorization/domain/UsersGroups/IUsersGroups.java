package com.acme.authorization.domain.UsersGroups;

import com.acme.authorization.domain.UsersGroup;

import java.util.List;
import java.util.UUID;

public interface IUsersGroups {
    UsersGroup add(String usersGroupName);
    void save(UsersGroup usersGroup);
    UsersGroup findUsersGroupByName(String name);
    UsersGroup findUsersGroupById(UUID usersGroupId);
    List<UsersGroup> findAllChilds(UUID usersGroupId);

}
