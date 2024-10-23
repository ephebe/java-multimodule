package com.acme.authorization;

import com.acme.authorization.domain.*;
import com.acme.authorization.domain.entities_groups.EntitiesGroup;
import com.acme.authorization.domain.entities_groups.IEntitiesGroups;
import com.acme.authorization.domain.permissions.Permission;
import com.acme.authorization.domain.users.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class AuthorizationServiceTests {
    @Autowired
    private IEntitiesGroups entitiesGroups;
    private User user;
    private Feature feature;

    @Test
    public void WillReturnFalseIfNoPermissionHasBeenDefined() {
        boolean isAllowed = user.IsAllowed("/Account/Edit");
        Assert.isTrue(!isAllowed, "");
    }

    @Test
    public void WillReturnFalseIfOperationNotDefined() {
        boolean isAllowed = user.IsAllowed("/Account/Delete");
        Assert.isTrue(!isAllowed, "");
    }

    @Test
    public void WillReturnTrueIfAllowPermissionWasDefined() {
        Permission
                .Allow("/Account/Edit")
                .For(user)
                .OnEverything()
                .DefaultLevel()
                .Save();


        boolean isAllowed = user.IsAllowed("/Account/Edit");
        Assert.isTrue(isAllowed, "");
    }

    @Test
    public void WillReturnFalseIfAllowPermissionWasDefinedOnGroupAndDenyPermissionOnUser() {
        Permission
                .Allow("/Account/Edit")
                .For(user)
                .OnEverything()
                .DefaultLevel()
                .Save();
        Permission
                .Deny("/Account/Edit")
                .For("Administrators")
                .OnEverything()
                .DefaultLevel()
                .Save();


        boolean isAllowed = user.IsAllowed("/Account/Edit");
        Assert.isTrue(!isAllowed, "");
    }

    @Test
    public void WillReturnFalseIfAllowedPermissionWasDefinedWithDenyPermissionWithHigherLevel() {
        Permission
                .Allow("/Account/Edit")
                .For(user)
                .OnEverything()
                .DefaultLevel()
                .Save();
        Permission
                .Deny("/Account/Edit")
                .For("Administrators")
                .OnEverything()
                .Level(5)
                .Save();


        boolean isAllowed = user.IsAllowed("/Account/Edit");
        Assert.isTrue(!isAllowed, "");
    }

    @Test
    public void WillReturnTrueIfAllowedPermissionWasDefinedWithDenyPermissionWithLowerLevel() {
        Permission
                .Allow("/Account/Edit")
                .For(user)
                .OnEverything()
                .Level(10)
                .Save();
        Permission
                .Deny("/Account/Edit")
                .For("Administrators")
                .OnEverything()
                .Level(5)
                .Save();


        boolean isAllowed = user.IsAllowed("/Account/Edit");
        Assert.isTrue(isAllowed, "");
    }


    @Test
    public void WillReturnTrueOnAccountIfPermissionWasGrantedOnAnything() {
        Permission
                .Allow("/Account/Edit")
                .For(user)
                .OnEverything()
                .DefaultLevel()
                .Save();


        boolean isAllowed = user.IsAllowed(feature, "/Account/Edit");
        Assert.isTrue(isAllowed, "");
    }

    @Test
    public void WillReturnFalseOnAccountIfPermissionWasDeniedOnAnything() {
        Permission
                .Deny("/Account/Edit")
                .For(user)
                .OnEverything()
                .DefaultLevel()
                .Save();


        boolean isAllowed = user.IsAllowed(feature, "/Account/Edit");
        Assert.isTrue(!isAllowed, "");
    }

    @Test
    public void WillReturnTrueOnAccountIfPermissionWasGrantedOnGroupAssociatedWithUser() {
        Permission
                .Allow("/Account/Edit")
                .For("Administrators")
                .On(feature)
                .DefaultLevel()
                .Save();


        boolean isAllowed = user.IsAllowed(feature, "/Account/Edit");
        Assert.isTrue(isAllowed, "");
    }

    @Test
    public void WillReturnFalseOnAccountIfPermissionWasDeniedOnGroupAssociatedWithUser() {
        Permission
                .Deny("/Account/Edit")
                .For("Administrators")
                .On(feature)
                .DefaultLevel()
                .Save();


        boolean isAllowed = user.IsAllowed(feature, "/Account/Edit");
        Assert.isTrue(!isAllowed, "");
    }

    @Test
    public void WillReturnTrueOnAccountIfPermissionWasGrantedToUser() {
        Permission
                .Allow("/Account/Edit")
                .For(user)
                .On(feature)
                .DefaultLevel()
                .Save();


        boolean isAllowed = user.IsAllowed(feature, "/Account/Edit");
        Assert.isTrue(isAllowed, "");
    }

    @Test
    public void WillReturnFalseOnAccountIfPermissionWasDeniedToUser() {
        Permission
                .Deny("/Account/Edit")
                .For(user)
                .On(feature)
                .DefaultLevel()
                .Save();


        boolean isAllowed = user.IsAllowed(feature, "/Account/Edit");
        Assert.isTrue(!isAllowed, "");
    }

    @Test
    public void WillReturnTrueOnEntityGroupIfPermissionWasGrantedToUsersGroupAssociatedWithUser() {
        Permission
                .Allow("/Account/Edit")
                .For("Administrators")
                .On("Important Accounts")
                .DefaultLevel()
                .Save();


        boolean isAllowed = user.IsAllowed(feature, "/Account/Edit");
        Assert.isTrue(isAllowed, "");
    }

    @Test
    public void WillReturnFalseOnAccountIfNoPermissionIsDefined() {
        boolean isAllowed = user.IsAllowed(feature, "/Account/Edit");
        Assert.isTrue(!isAllowed, "");
    }

    @Test
    public void WillReturnFalseOnAccountIfPermissionWasDeniedToUserOnTheGroupTheEntityIsAssociatedWith() {
        Permission
                .Deny("/Account/Edit")
                .For(user)
                .On("Important Accounts")
                .DefaultLevel()
                .Save();


        boolean isAllowed = user.IsAllowed(feature, "/Account/Edit");
        Assert.isTrue(!isAllowed, "");
    }

    @Test
    public void WillReturnTrueOnAccountIfPermissionWasAllowedToUserOnTheGroupTheEntityIsAssociatedWith() {
        Permission
                .Allow("/Account/Edit")
                .For(user)
                .On("Important Accounts")
                .DefaultLevel()
                .Save();


        boolean isAllowed = user.IsAllowed(feature, "/Account/Edit");
        Assert.isTrue(isAllowed, "");
    }

    @Test
    public void WillReturnTrueOnAccountIfPermissionWasAllowedToUserOnTheNestedEntityGroupIsAssociatedWith() {
        Feature beto = new Feature();
        beto.getSrc().setName("beto account");

        EntitiesGroup executiveAccounts = entitiesGroups.add("Executive Accounts");
        EntitiesGroup managerAccounts = executiveAccounts.addChild("Manager Accounts");
        EntitiesGroup employeeAccounts = managerAccounts.addChild("Employee Accounts");

        employeeAccounts.associateEntity(beto);

        Permission
                .Allow("/Account/Edit")
                .For(user)
                .On("Executive Accounts")
                .DefaultLevel()
                .Save();

        boolean isAllowed = user.IsAllowed(beto, "/Account/Edit");
        Assert.isTrue(isAllowed, "");
    }

    @Test
    public void WillReturnTrueOnGlobalIfPermissionWasAllowedOnGlobalButDeniedOnEntitiesGroup() {
        Permission
                .Allow("/Account/Edit")
                .For(user)
                .OnEverything()
                .DefaultLevel()
                .Save();


        Permission
                .Deny("/Account/Edit")
                .For(user)
                .On("Important Accounts")
                .DefaultLevel()
                .Save();


        boolean IsAllowed = user.IsAllowed("/Account/Edit");
        Assert.isTrue(IsAllowed, "");
    }

    @Test
    public void WillReturnTrueOnGlobalIfPermissionWasAllowedOnGlobalButDeniedOnNestedEntitiesGroup() {
        Feature beto = new Feature();
        beto.getSrc().setName("beto account");

        EntitiesGroup executiveAccounts = entitiesGroups.add("Executive Accounts");
        EntitiesGroup managerAccounts = executiveAccounts.addChild("Manager Accounts");
        EntitiesGroup employeeAccounts = managerAccounts.addChild("Employee Accounts");

        employeeAccounts.associateEntity(beto);

        Permission
                .Allow("/Account/Edit")
                .For(user)
                .OnEverything()
                .DefaultLevel()
                .Save();
        Permission
                .Deny("/Account/Edit")
                .For(user)
                .On("Executive Accounts")
                .DefaultLevel()
                .Save();

        boolean IsAllowed = user.IsAllowed("/Account/Edit");
        Assert.isTrue(IsAllowed, "");
    }

    @Test
    public void WillReturnTrueOnGlobalIfPermissionWasAllowedOnGlobalButDeniedOnSpecificEntity() {
        Permission
                .Allow("/Account/Edit")
                .For(user)
                .OnEverything()
                .DefaultLevel()
                .Save();


        Permission
                .Deny("/Account/Edit")
                .For(user)
                .On(feature)
                .DefaultLevel()
                .Save();


        boolean IsAllowed = user.IsAllowed("/Account/Edit");
        Assert.isTrue(IsAllowed, "");
    }

    @Test
    public void UseSecondLevelCacheForSecurityQuestions_WillBeUpdatedWhenGoingThroughNHiberante() {
        Permission
                .Allow("/Account/Edit")
                .For(user)
                .On("Important Accounts")
                .DefaultLevel()
                .Save();


        boolean isAllowed = user.IsAllowed(feature, "/Account/Edit");
        Assert.isTrue(isAllowed, "");

        // should return true since it loads from cache
        isAllowed = user.IsAllowed(feature, "/Account/Edit");
        Assert.isTrue(!isAllowed, "");
    }


    @Test
    public void WillReturnFalseIfPermissionWasAllowedToChildGroupUserIsAssociatedWith() {
        EntitiesGroup administrators = entitiesGroups.findEntitiesGroupByName("Administrators");
        administrators.addChild("Helpdesk");

        Permission
                .Allow("/Account/Edit")
                .For("Helpdesk")
                .On("Important Accounts")
                .DefaultLevel()
                .Save();


        boolean isAllowed = user.IsAllowed(feature, "/Account/Edit");
        Assert.isTrue(!isAllowed, "");
    }

    @Test
    public void WillReturnTrueIfPermissionWasAllowedToParentGroupUserIsAssociatedWith() {
        EntitiesGroup administrators = entitiesGroups.findEntitiesGroupByName("Administrators");
        EntitiesGroup helpdesk = administrators.addChild("Helpdesk");

        helpdesk.associateEntity(user);


        Permission
                .Allow("/Account/Edit")
                .For("Administrators")
                .On("Important Accounts")
                .DefaultLevel()
                .Save();


        boolean isAllowed = user.IsAllowed(feature, "/Account/Edit");
        Assert.isTrue(isAllowed, "");
    }

}
