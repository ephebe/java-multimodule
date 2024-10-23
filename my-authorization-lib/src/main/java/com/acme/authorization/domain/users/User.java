package com.acme.authorization.domain.users;

import com.acme.authorization.domain.Permission;
import com.acme.authorization.domain.users_groups.UsersGroup;
import com.acme.authorization.domain.entities.UserEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class User {
    private final UserEntity src;
    private final UserPermissions permissions;

    public UserEntity getSrc() {
        return this.src;
    }

    public <TEntity> boolean IsAllowed(TEntity entity,String operationName) {
        List<Permission> allowPermission =  this.permissions.getByEntityOperation(entity.toString(),operationName);
        if(allowPermission.size() > 0) {
            return true;
        }

        return false;
    }

    public <TEntity> boolean IsAllowed(String operationName) {
//        List<Permission> allowPermission =  this.permissions.getByEntityOperation(entity.toString(),operationName);
//        if(allowPermission.size() > 0) {
//            return true;
//        }

        return false;
    }

    public UsersGroup[] getAncestryAssociation(String ancestryName) {
        throw new RuntimeException();
    }


    public interface UserPermissions {
        List<Permission> getByEntityOperation(String entityType,String operationName);
    }
}
