package com.acme.authorization.infrastructure.factory;

import com.acme.authorization.domain.UsersGroup;
import com.acme.authorization.infrastructure.associations.*;
import com.acme.authorization.infrastructure.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Function;

@RequiredArgsConstructor
@Configuration
public class UsersGroupAssociationsFactory {
    private final UsersGroupRepository usersGroupRepository;
    private final UsersGroupHierarchyRepository usersGroupHierarchyRepository;
    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;
    private final UsersGroupUserRepository usersGroupUserRepository;
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public UsersGroup.UsersGroupParent getUsersGroupParent(UUID childId) {
        return new UsersGroupParentImpl(childId, usersGroupRepository);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public UsersGroup.UsersGroupChilds getUsersGroupDirects(UUID parentId) {
        return new UsersGroupChildsImpl(parentId,usersGroupRepository);
    };

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public UsersGroup.UsersGroupHierarchies getUsersGroupHierarchies(UUID childId) {
        return new UsersGroupHierarchiesImpl(childId,usersGroupHierarchyRepository);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public UsersGroup.UsersGroupUsers getUsersGroupUsers(UUID usersGroupId) {
        return new UsersGroupUsersImpl(usersGroupId,usersGroupUserRepository);
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public UsersGroup.UsersGroupPermissions getUsersGroupPermissions(UUID usersGroupId) {
        return new UsersGroupPermissionsImpl(usersGroupId,permissionRepository);
    }
}
