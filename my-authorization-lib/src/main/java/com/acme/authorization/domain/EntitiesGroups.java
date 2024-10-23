package com.acme.authorization.domain;

public interface EntitiesGroups {
    EntitiesGroup add(String entitiesGroupName);

    EntitiesGroup findEntitiesGroupByName(String entitiesGroupName);
}
