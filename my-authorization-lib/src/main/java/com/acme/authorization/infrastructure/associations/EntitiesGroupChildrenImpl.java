package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.entities_groups.EntitiesGroup;
import com.acme.authorization.infrastructure.repository.EntitiesGroupRepository;

import java.util.List;
import java.util.UUID;

public class EntitiesGroupChildrenImpl implements EntitiesGroup.EntitiesGroupChildren {
    private UUID parentId;
    private EntitiesGroupRepository repository;

    public EntitiesGroupChildrenImpl(UUID parentId, EntitiesGroupRepository repository) {
        this.parentId = parentId;
        this.repository = repository;
    }
    @Override
    public List<EntitiesGroup> findAll() {
        return null;
    }
}
