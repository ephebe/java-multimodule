package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.users_groups.UsersGroup;
import com.acme.authorization.domain.users_groups.UsersGroupsHierarchy;
import com.acme.authorization.domain.entities.UsersGroupsHierarchyEntity;
import com.acme.authorization.infrastructure.repository.UsersGroupHierarchyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UsersGroupHierarchiesImpl implements UsersGroup.UsersGroupHierarchies {
    private final UsersGroupHierarchyRepository repository;

    @Override
    public Boolean exists(UUID ancestorId,UUID descendorId) {
        UsersGroupsHierarchyEntity entity = new UsersGroupsHierarchyEntity();
        entity.setAncestorId(ancestorId);
        entity.setDescendantId(descendorId);
        var ex =  Example.of(entity);
        return repository.exists(ex);
    }

    @Override
    public List<UsersGroupsHierarchy> findDescendants(UUID ancestorId) {
        return
        repository.findByAncestorId(ancestorId).stream()
                .map(this::map)
                .toList();
    }

    @Override
    public void addHierarchy(UUID ancestorId, UUID descendantId) {
        UsersGroupsHierarchyEntity entity = new UsersGroupsHierarchyEntity();
        entity.setAncestorId(ancestorId);
        entity.setDescendantId(descendantId);
        repository.save(entity);
    }

    @Override
    public void removeDescendant(UUID usersGroupId) {

    }

    @Override
    public List<UsersGroupsHierarchy> findAncestors(UUID descendorId) {
        return
                repository.findByDescendantId(descendorId).stream()
                        .map(this::map)
                        .toList();
    }

    @Override
    public void removeAncestor(UUID usersGroupId) {

    }

    private UsersGroupsHierarchy map(UsersGroupsHierarchyEntity entity) {
        return new UsersGroupsHierarchy(entity);

    }
}
