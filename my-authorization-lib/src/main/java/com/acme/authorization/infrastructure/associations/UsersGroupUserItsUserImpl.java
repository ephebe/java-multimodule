//package com.acme.authorization.infrastructure.associations;
//
//import com.acme.authorization.domain.User;
//import com.acme.authorization.domain.UsersGroupUser;
//import com.acme.authorization.domain.UsersGroups;
//import com.acme.authorization.domain.entities.UserEntity;
//import com.acme.authorization.infrastructure.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//import java.util.UUID;
//
//@RequiredArgsConstructor
//public class UsersGroupUserItsUserImpl implements UsersGroupUser.UsersGroupUserItsUser {
//    private final UserRepository repository;
//    @Override
//    public UserEntity get(UUID userId) {
//        Optional<UserEntity> entity = repository.findById(userId);
//        if(entity.isEmpty())
//            return null;
//
//        return repository.build(entity.get());
//    }
//}
