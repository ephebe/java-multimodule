package com.acme.authorization.domain;

import com.acme.authorization.domain.entities.FeatureEntity;

public class Feature {
    private FeatureEntity src;
    public EntitiesGroup[] getAncestryAssociation(String entitiesGroupName) {
        throw new RuntimeException();
    }

    public FeatureEntity getSrc() {
        return src;
    }
}
