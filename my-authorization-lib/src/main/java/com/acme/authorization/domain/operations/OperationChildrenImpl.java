package com.acme.authorization.domain.operations;

import com.acme.authorization.domain.operations.Operation;

import java.util.List;

public class OperationChildrenImpl implements Operation.OperationChildren {
    @Override
    public List<Operation> findAll() {
        return null;
    }

    @Override
    public void removeChild(Operation operation) {

    }
}
