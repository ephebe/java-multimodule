package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.EntitiesGroup;

import java.util.List;

public class EntitiesGroupParentsImpl implements EntitiesGroup.EntitiesGroupParents {
    @Override
    public List<EntitiesGroup> findAll() {
        return null;
    }

    @Override
    public void removeChild(EntitiesGroup entitiesGroup) {

    }
}
