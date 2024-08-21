package com.acme.authorization.domain;

public interface Operations {
    Operation getOperationByName(String name);
    void remove(Operation operation);
    Operation add(String operationName);
}
