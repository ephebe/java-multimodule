package com.acme.core.specifications;

public class NegationSpecification<T> extends AbstractSpecification<T> {

    private final AbstractSpecification<T> component;

    NegationSpecification(AbstractSpecification<T> selector) {
        this.component = selector;
    }

    /**
     * Tests if the selector fails the test (yes).
     */
    @Override
    public boolean test(T t) {
        return !(component.test(t));
    }
}
