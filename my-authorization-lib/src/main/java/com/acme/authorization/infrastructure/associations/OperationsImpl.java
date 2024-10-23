package com.acme.authorization.infrastructure.associations;

import com.acme.authorization.domain.operations.Operation;
import com.acme.authorization.domain.operations.IOperations;

public class OperationsImpl implements IOperations {
    @Override
    public Operation getOperationByName(String name) {
        return null;
    }

    @Override
    public void remove(Operation operation) {

    }

    @Override
    public Operation add(String operationName) {
        return null;
    }
}
