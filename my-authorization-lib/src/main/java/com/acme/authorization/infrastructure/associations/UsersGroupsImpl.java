package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.UsersGroup;
import com.acme.authorization.domain.UsersGroups;
import com.acme.authorization.domain.entities.UsersGroupEntity;
import com.acme.authorization.infrastructure.factory.UsersGroupAssociationsFactory;
import com.acme.authorization.infrastructure.repository.UsersGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroupsImpl implements UsersGroups {
    private final UsersGroupRepository repository;
    private final UsersGroupAssociationsFactory usersGroupAssociationsFactory;

    @Override
    public UsersGroup add(String usersGroupName) {
        UsersGroupEntity entity = new UsersGroupEntity();
        entity.setId(UUID.randomUUID());
        entity.setName(usersGroupName);
        repository.save(entity);
        return repository.build(entity);
    }

    @Override
    public UsersGroup findUsersGroupByName(String name) {
        Optional<UsersGroupEntity> entity = repository.findOneByName(name);
        return entity.map(repository::build).orElse(null);

    }

}
