package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.UsersGroup;
import com.acme.authorization.domain.UsersGroups;
import com.acme.authorization.domain.entities.UsersGroupEntity;
import com.acme.authorization.infrastructure.repository.UsersGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UsersGroupsImpl implements UsersGroups {
    private final UsersGroupRepository repository;
    private final UsersGroup.UsersGroupUsers usersGroupUsers;
    private final UsersGroup.UsersGroupHierarchies usersGroupHierarchies;
    private final UsersGroup.UsersGroupPermissions usersGroupPermissions;

    @Override
    public UsersGroup add(String usersGroupName) {
        UsersGroupEntity entity = new UsersGroupEntity();
        entity.setId(UUID.randomUUID());
        entity.setName(usersGroupName);
        repository.save(entity);
        return map(entity);
    }

    @Override
    public void save(UsersGroup usersGroup) {
        repository.save(usersGroup.getSrcEntity());
    }

    @Override
    public UsersGroup findUsersGroupByName(String name) {
        Optional<UsersGroupEntity> entity = repository.findOneByName(name);
        return entity.map(this::map).orElse(null);
    }

    @Override
    public UsersGroup findUsersGroupById(UUID usersGroupId) {
        Optional<UsersGroupEntity> usersGroup = repository.findById(usersGroupId);
        return usersGroup.map(this::map).orElse(null);
    }

    @Override
    public List<UsersGroup> findAllChilds(UUID usersGroupId) {
        return
        repository.findByParentId(usersGroupId).stream().map(this::map).toList();
    }

    private UsersGroup map(UsersGroupEntity entity) {
        return new UsersGroup(entity,this,usersGroupUsers,usersGroupHierarchies,usersGroupPermissions);
    }

}
