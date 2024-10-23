//package com.acme.authorization.infrastructure.associations;
//
//import com.acme.authorization.domain.UsersGroup.UsersGroup;
//import com.acme.authorization.domain.entities.UsersGroupEntity;
//import com.acme.authorization.infrastructure.repository.UsersGroupRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//import java.util.UUID;
//
//@RequiredArgsConstructor
//@Component
//public class UsersGroupParentImpl implements UsersGroup.UsersGroupParent {
//    private final UUID parentId;
//    private final UsersGroupRepository repository;
//    private ObjectProvider<UsersGroup.UsersGroupUsers> usersGroupUsersObjectProvider;
//    private ObjectProvider<UsersGroup.UsersGroupParent> usersGroupParentObjectProvider;
//    private ObjectProvider<UsersGroup.UsersGroupChilds> usersGroupChildsObjectProvider;
//    private ObjectProvider<UsersGroup.UsersGroupHierarchies> usersGroupHierarchiesObjectProvider;
//    private ObjectProvider<UsersGroup.UsersGroupPermissions> getUsersGroupPermissionsObjectProvider;
//
//    @Override
//    public UsersGroup get(UUID child) {
//        Optional<UsersGroupEntity> entity = repository.findById(parentId);
//
//        if(entity.isPresent()) {
//            UsersGroupEntity parentEntity = entity.get();
//            return map(parentEntity);
//        } else
//            return null;
//    }
//
//    private UsersGroup map(UsersGroupEntity entity) {
//        var usersGroupUsers = usersGroupUsersObjectProvider.getObject(entity.getId());
//        var usersGroupParent =  usersGroupParentObjectProvider.getObject(entity.getId());
//        var usersGroupChilds =  usersGroupChildsObjectProvider.getObject(entity.getId());
//        var usersGroupHierarchies = usersGroupHierarchiesObjectProvider.getObject(entity.getId());
//        var usersGroupPermissions = getUsersGroupPermissionsObjectProvider.getObject(entity.getId());
//
//        return new UsersGroup(entity,usersGroupParent,usersGroupUsers,usersGroupChilds,usersGroupHierarchies,usersGroupPermissions);
//    }
//}
