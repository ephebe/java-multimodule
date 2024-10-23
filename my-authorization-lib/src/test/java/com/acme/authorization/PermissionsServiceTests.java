package com.acme.authorization;

import com.acme.authorization.domain.*;
import com.acme.authorization.domain.permissions.IPermissions;
import com.acme.authorization.domain.permissions.Permission;
import com.acme.authorization.domain.users.User;
import com.acme.authorization.domain.users_groups.IUsersGroups;
import com.acme.authorization.domain.users_groups.UsersGroup;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class PermissionsServiceTests {

    private IUsersGroups usersGroups;

    private IPermissions permissions;
    private User user;
    private Feature feature;

    @Test
    public void CanCreatePermission() {
        Permission permission = Permission
                .Allow("/Account/Edit")
                .For(user)
                .On(feature)
                .DefaultLevel()
                .Save();

        List<Permission> all = permissions.findAll();

        Assert.state(1 == all.size(), "it should be 1");
    }

    @Test
    public void CanGetPermissionByUser() {
        Permission
                .Allow("/Account/Edit")
                .For(user)
                .On(feature)
                .DefaultLevel()
                .Save();

        List<Permission> userPermissions = permissions.findPermissionsFor(user);
        Assert.state(1 == userPermissions.size(), "");
    }

    @Test
    public void CanGetPermissionsByUser_WhenDefinedOnGroup() {
        Permission
                .Allow("/Account/Edit")
                .For("Administrators")
                .On(feature)
                .DefaultLevel()
                .Save();

        List<Permission> userPermissions = permissions.findPermissionsFor(user);
        Assert.state(1 == userPermissions.size(), "");
    }

    @Test
    public void CanGetPermissionsByEntity() {
        Permission
                .Allow("/Account/Edit")
                .For("Administrators")
                .On(feature)
                .DefaultLevel()
                .Save();

        List<Permission> featurePermissions = permissions.findPermissionsFor(feature);
        Assert.state(1 == featurePermissions.size(), "");
    }

    @Test
    public void CanGetPermissionsByEntity_WhenDefinedOnEntityGroup() {
        Permission
                .Allow("/Account/Edit")
                .For("Administrators")
                .On("Important Accounts")
                .DefaultLevel()
                .Save();

        List<Permission> featurePermissions = permissions.findPermissionsFor(feature);
        Assert.state(1 == featurePermissions.size(), "");
    }

    @Test
    public void CanGetPermissionsByUserAndEntity() {
        Permission
                .Deny("/Account/Edit")
                .For(user)
                .On(feature)
                .DefaultLevel()
                .Save();

        List<Permission> featurePermissions = permissions.findPermissionsFor(feature);
        Assert.state(1 == featurePermissions.size(), "");
    }

    @Test
    public void CanGetPermissionsByUserAndOperationName() {
        Permission
                .Allow("/Account/Edit")
                .For(user)
                .On(feature)
                .DefaultLevel()
                .Save();

        List<Permission> featurePermissions = permissions.findPermissionsFor(feature);
        Assert.state(1 == featurePermissions.size(), "");
    }

    @Test
    public void CanGetPermissionsByUserAndOperationName_WhenParentOperationWasGranted() {
        Permission
                .Allow("/Account")
                .For(user)
                .On(feature)
                .DefaultLevel()
                .Save();

        List<Permission> featurePermissions = permissions.findPermissionsFor(feature);
        Assert.state(1 == featurePermissions.size(), "");
    }

    @Test
    public void CanGetPermissionsByUserAndOpernationName_WhenPermissionOnEverything() {
        Permission
                .Allow("/Account")
                .For(user)
                .OnEverything()
                .DefaultLevel()
                .Save();

        List<Permission> userPermissions = permissions.findGlobalPermissionsFor(user, "/Account/Edit");
        Assert.state(1 == userPermissions.size(), "");
    }

    @Test
    public void CanGetPermissionByUserEntityAndOperation() {
        Permission
                .Allow("/Account")
                .For(user)
                .On("Important Accounts")
                .DefaultLevel()
                .Save();

        List<Permission> userPermissions = permissions.findPermissionsFor(user, feature, "/Account/Edit");
        Assert.state(1 == userPermissions.size(), "");
    }

    @Test
    public void CanGetPermissionByOperation() {
        Permission
                .Allow("/Account/Edit")
                .For(user)
                .On(feature)
                .DefaultLevel()
                .Save();

        List<Permission> operationPermissions = permissions.findPermissionsFor("/Account/Edit");
        Assert.state(1 == operationPermissions.size(), "");
    }

    @Test
    public void CanGetPermissionByOperation_WhenParentOperationWasGranted() {
        Permission
                .Allow("/Account")
                .For(user)
                .On(feature)
                .DefaultLevel()
                .Save();

        List<Permission> operationPermissions = permissions.findPermissionsFor("/Account/Edit");
        Assert.state(1 == operationPermissions.size(), "");
    }

    @Test
    public void PermissionsAreOrderedByLevelAndThenByDenyOrAllow() {
        Permission
                .Allow("/Account")
                .For(user)
                .On("Important Accounts")
                .DefaultLevel()
                .Save();
        Permission
                .Deny("/Account/Edit")
                .For(user)
                .On("Important Accounts")
                .DefaultLevel()
                .Save();
        Permission
                .Allow("/Account/Edit")
                .For(user)
                .On("Important Accounts")
                .Level(20)
                .Save();
        Permission
                .Deny("/Account/Edit")
                .For(user)
                .On("Important Accounts")
                .Level(20)
                .Save();

        List<Permission> userPermissions = permissions.findPermissionsFor(user);
        Assert.state(4 == userPermissions.size(), "");

        Assert.state(20 == userPermissions.get(0).getSrcEntity().getLevel(), "");
        Assert.isTrue(!userPermissions.get(0).getSrcEntity().getAllow(), "");

        Assert.state(20 == userPermissions.get(1).getSrcEntity().getLevel(), "");
        Assert.isTrue(userPermissions.get(1).getSrcEntity().getAllow(), "");

        Assert.state(1 == userPermissions.get(2).getSrcEntity().getLevel(), "");
        Assert.isTrue(!userPermissions.get(2).getSrcEntity().getAllow(), "");

        Assert.state(1 == userPermissions.get(3).getSrcEntity().getLevel(), "");
        Assert.isTrue(userPermissions.get(3).getSrcEntity().getAllow(), "");
    }

    @Test
    public void CanSetPermissionOnEverythingAndGetItOnEntity() {
        Permission
                .Allow("/Account")
                .For(user)
                .OnEverything()
                .DefaultLevel()
                .Save();

        List<Permission> userPermissions = permissions.findPermissionsFor(user, feature, "/Account/Edit");
        Assert.state(1 == userPermissions.size(), "");
    }

    @Test
    public void CanGetPermissionsSetOnarentGroupUserIsAssociatedWith() {
        UsersGroup administrators = usersGroups.add("Administrators");
        UsersGroup helpdesk = administrators.addChild("Helpdesk");

        helpdesk.associateUser(user);

        Permission
                .Allow("/Account/Edit")
                .For("Administrators")
                .On("Important Accounts")
                .DefaultLevel()
                .Save();


        List<Permission> userPermissions = permissions.findPermissionsFor(user, feature, "/Account/Edit");
        Assert.state(1 == userPermissions.size(), "");
    }

    @Test
    public void CanRemovePermission() {
        Permission permission = Permission
                .Allow("/Account/Edit")
                .For("Administrators")
                .On("Important Accounts")
                .DefaultLevel()
                .Save();

        List<Permission> userPermissions = permissions.findPermissionsFor(user, feature, "/Account/Edit");
        Assert.state(1 == userPermissions.size(), "");

        permissions.remove(permission);

        userPermissions = permissions.findPermissionsFor(user, feature, "/Account/Edit");
        Assert.state(0 == userPermissions.size(), "");
    }
}
