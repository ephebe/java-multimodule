package com.acme.authorization.domain.entities_groups;

public interface IEntitiesGroups {
    EntitiesGroup add(String entitiesGroupName);

    EntitiesGroup findEntitiesGroupByName(String entitiesGroupName);
}
