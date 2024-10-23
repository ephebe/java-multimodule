package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.entities_groups.EntitiesGroup;
import com.acme.authorization.domain.entities_groups.EntityReference;

import java.util.List;

public class EntitiesGroupEntitiesImpl implements EntitiesGroup.EntitiesGroupEntities {
    @Override
    public List<EntityReference> findAll() {
        return null;
    }

    @Override
    public void removeAll() {

    }
}
