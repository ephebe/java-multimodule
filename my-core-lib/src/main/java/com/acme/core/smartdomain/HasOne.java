package com.acme.core.smartdomain;

public interface HasOne<E extends BusinessEntity<?>> {
    E get();
}
