package com.acme.core.specifications;

import java.util.function.Predicate;

public abstract class AbstractSpecification<T> implements Predicate<T> {

    public AbstractSpecification<T> and(AbstractSpecification<T> other) {
        return new ConjunctionSpecification<>(this, other);
    }

    public AbstractSpecification<T> or(AbstractSpecification<T> other) {
        return new DisjunctionSpecification<>(this, other);
    }

    public AbstractSpecification<T> not() {
        return new NegationSpecification<>(this);
    }
}
