package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.UsersGroup;
import com.acme.authorization.domain.entities.UsersGroupEntity;
import com.acme.authorization.infrastructure.factory.UsersGroupAssociationsFactory;
import com.acme.authorization.infrastructure.repository.UsersGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroupParentImpl implements UsersGroup.UsersGroupParent {
    private final UUID parentId;
    private final UsersGroupRepository repository;

    @Override
    public UsersGroup get() {
        Optional<UsersGroupEntity> entity = repository.findById(parentId);

        if(entity.isPresent()) {
            UsersGroupEntity parentEntity = entity.get();
            return repository.build(parentEntity);
        } else
            return null;
    }
}
