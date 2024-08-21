package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.UsersGroup;
import com.acme.authorization.domain.entities.UsersGroupEntity;
import com.acme.authorization.infrastructure.repository.UsersGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroupChildsImpl implements UsersGroup.UsersGroupChilds {
    private final UUID parentId;
    private final UsersGroupRepository repository;
    @Override
    public List<UsersGroup> findAll() {
        return
            repository.findByParentId(parentId)
                .stream().map(repository::build).toList();
    }

    @Override
    public UsersGroup findByName(String usersGroupName) {
        return
            repository.findOneByName(usersGroupName)
                    .map(repository::build).orElse(null);
    }

    @Override
    public UsersGroup add(String usersGroupName) {
        UsersGroupEntity entity = new UsersGroupEntity();
        entity.setName(usersGroupName);
        entity.setParentId(parentId);
        repository.save(entity);
        return repository.build(entity);
    }

    @Override
    public int count() {

        return 0;
    }
}
