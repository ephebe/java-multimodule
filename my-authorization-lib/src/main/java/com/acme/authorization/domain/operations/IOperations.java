package com.acme.authorization.domain.operations;

public interface IOperations {
    Operation getOperationByName(String name);
    void remove(Operation operation);
    Operation add(String operationName);
}
