package com.acme.core.rules;

public interface IRule<E> {
    boolean matches(E input);
    void apply(E input);
}
