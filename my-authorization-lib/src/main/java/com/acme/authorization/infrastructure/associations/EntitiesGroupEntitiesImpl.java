package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.EntitiesGroup;
import com.acme.authorization.domain.EntityReference;

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
