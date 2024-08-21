package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.UsersGroup;
import com.acme.authorization.domain.UsersGroupsHierarchy;
import com.acme.authorization.domain.entities.UsersGroupsHierarchyEntity;
import com.acme.authorization.infrastructure.repository.UsersGroupHierarchyRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UsersGroupHierarchiesImpl implements UsersGroup.UsersGroupHierarchies {
    private final UUID usersGroupId;
    private final UsersGroupHierarchyRepository repository;
    @Override
    public List<UsersGroupsHierarchy> findDescendants() {
        return
        repository.findDescendants(usersGroupId).stream()
                .map(repository::Build)
                .toList();
    }

    @Override
    public void addDescendant(UUID descendantId) {
        UsersGroupsHierarchyEntity entity = new UsersGroupsHierarchyEntity();
        entity.setParentGroupId(usersGroupId);
        entity.setChildGroupId(descendantId);
        repository.save(entity);
    }

    @Override
    public void removeDescendant(UUID usersGroupId) {

    }

    @Override
    public List<UsersGroupsHierarchy> findAncestors() {
        return
                repository.findAncestors(usersGroupId).stream()
                        .map(repository::Build)
                        .toList();
    }

    @Override
    public void addAncestor(UUID ancestor) {
        UsersGroupsHierarchyEntity entity = new UsersGroupsHierarchyEntity();
        entity.setParentGroupId(ancestor);
        entity.setChildGroupId(usersGroupId);
        repository.save(entity);
    }

    @Override
    public void removeAncestor(UUID usersGroupId) {

    }
}
