//package com.acme.authorization.infrastructure.associations;
//
//import com.acme.authorization.domain.UsersGroup;
//import com.acme.authorization.domain.entities.UsersGroupEntity;
//import com.acme.authorization.infrastructure.repository.UsersGroupRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.data.domain.Example;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.UUID;
//
//@RequiredArgsConstructor
//@Component
//public class UsersGroupChildsImpl implements UsersGroup.UsersGroupChilds {
//    private final UUID parentId;
//    private final UsersGroupRepository repository;
//    private ObjectProvider<UsersGroup.UsersGroupUsers> usersGroupUsersObjectProvider;
//    private ObjectProvider<UsersGroup.UsersGroupParent> usersGroupParentObjectProvider;
//    private ObjectProvider<UsersGroup.UsersGroupChilds> usersGroupChildsObjectProvider;
//    private ObjectProvider<UsersGroup.UsersGroupHierarchies> usersGroupHierarchiesObjectProvider;
//    private ObjectProvider<UsersGroup.UsersGroupPermissions> getUsersGroupPermissionsObjectProvider;
//
//    @Override
//    public List<UsersGroup> findAll() {
//        return
//            repository.findByParentId(parentId)
//                .stream().map(this::map).toList();
//    }
//
//    @Override
//    public UsersGroup findByName(String usersGroupName) {
//        return
//            repository.findOneByName(usersGroupName)
//                    .map(this::map).orElse(null);
//    }
//
//    @Override
//    public UsersGroup add(String usersGroupName) {
//        UsersGroupEntity entity = new UsersGroupEntity();
//        entity.setName(usersGroupName);
//        entity.setParentId(parentId);
//        repository.save(entity);
//        return map(entity);
//    }
//
//    @Override
//    public int count() {
//
//        return 0;
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
