package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.entities_groups.EntitiesGroup;

import java.util.List;

public class EntitiesGroupDirectsImpl implements EntitiesGroup.EntitiesGroupDirects {
    @Override
    public List<EntitiesGroup> findAll() {
        return null;
    }

    @Override
    public void remove(EntitiesGroup entitiesGroup) {

    }

    @Override
    public int count() {
        return 0;
    }
}
