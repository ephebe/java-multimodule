package com.acme.core.smartdomain;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface Many<E extends BusinessEntity<?>> extends Iterable<E> {
    int size();

    Many<E> subCollection(int from, int to);

    default Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }
}
