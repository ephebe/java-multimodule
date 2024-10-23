package com.acme.authorization.domain.operations;

import com.acme.authorization.domain.entities.OperationEntity;
import lombok.Data;

import java.util.List;

@Data
public class Operation {
    private OperationEntity sourceEntity;
    private OperationParent parent;
    private OperationChildren children;

    public Operation(OperationEntity sourceEntity,
                     OperationChildren children) {
        this.sourceEntity = sourceEntity;
        this.children = children;
    }

    public void delete() {
        if(this.parent != null) {
            this.parent.get().removeChild(this);
        }
    }

    public void removeChild(Operation operation) {
        this.children.removeChild(operation);
    }
    public interface OperationChildren {
        List<Operation> findAll();
        void removeChild(Operation operation);
    }

    public interface OperationParent {
        Operation get();
    }
}
