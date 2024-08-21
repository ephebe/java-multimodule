package com.acme.authorization.infrastructure.repository;

import com.acme.authorization.domain.UsersGroup;
import com.acme.authorization.domain.entities.UsersGroupEntity;
import com.acme.authorization.infrastructure.factory.UsersGroupAssociationsFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UsersGroupRepositoryImpl {
    private final UsersGroup.UsersGroupParent usersGroupParent;
    private final UsersGroup.UsersGroupUsers usersGroupUsers;
    private ObjectProvider<UsersGroup.UsersGroupUsers> usersGroupUsersObjectProvider;
    private ObjectProvider<UsersGroup.UsersGroupParent> usersGroupParentObjectProvider;
    private ObjectProvider<UsersGroup.UsersGroupChilds> usersGroupChildsObjectProvider;
    private ObjectProvider<UsersGroup.UsersGroupHierarchies> usersGroupHierarchiesObjectProvider;
    private ObjectProvider<UsersGroup.UsersGroupPermissions> getUsersGroupPermissions;
    public UsersGroup Build(UsersGroupEntity entity) {
        return new UsersGroup(entity
                ,usersGroupParentObjectProvider.getObject(entity.getId())
                ,usersGroupUsersObjectProvider.getObject(entity.getId())
                ,usersGroupChildsObjectProvider.getObject(entity.getId())
                ,usersGroupHierarchiesObjectProvider.getObject(entity.getId())
                ,getUsersGroupPermissions.getObject(entity.getId()));
    }
}
