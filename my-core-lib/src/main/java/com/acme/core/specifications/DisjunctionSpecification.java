package com.acme.core.specifications;

import java.util.List;

public class DisjunctionSpecification<T> extends AbstractSpecification<T> {

    private final List<AbstractSpecification<T>> leafComponents;

    @SafeVarargs
    DisjunctionSpecification(AbstractSpecification<T>... selectors) {
        this.leafComponents = List.of(selectors);
    }

    /**
     * Tests if *at least one* selector passes the test.
     */
    @Override
    public boolean test(T t) {
        return leafComponents.stream().anyMatch(comp -> comp.test(t));
    }
}
