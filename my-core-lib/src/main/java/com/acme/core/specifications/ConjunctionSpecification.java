package com.acme.core.specifications;

import java.util.List;

public class ConjunctionSpecification<T> extends AbstractSpecification<T> {

    private final List<AbstractSpecification<T>> leafComponents;

    @SafeVarargs
    ConjunctionSpecification(AbstractSpecification<T>... selectors) {
        this.leafComponents = List.of(selectors);
    }

    /**
     * Tests if *all* selectors pass the test.
     */
    @Override
    public boolean test(T t) {
        return leafComponents.stream().allMatch(comp -> (comp.test(t)));
    }
}
