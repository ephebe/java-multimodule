package com.acme.authorization;

import com.acme.authorization.domain.*;
import com.acme.authorization.domain.users.IUsers;
import com.acme.authorization.domain.users.User;
import com.acme.authorization.domain.users_groups.IUsersGroups;
import com.acme.authorization.domain.users_groups.UsersGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScenariosTests {
    @Autowired
    private IUsersGroups usersGroups;
//    @Autowired
//    private EntitiesGroups entitiesGroups;
//    @Autowired
//    private Operations operations;
    @Autowired
    private IUsers users;

    private User user;
    private Feature feature;
    private UsersGroup group1;
    private UsersGroup group2;

    @Test
    public void DeeplyNestedUsersGroup() {
//        UsersGroup group = usersGroups.add("Root");
//
//        for (int j = 0; j < 50; j++) {
//            group = group.addChild("Child #" + j);
//        }
//
//        UsersGroup childGroup = usersGroups.findUsersGroupByName("Child #49");
//
//        childGroup.associateUser(user);
//
//        UsersGroup[] groups = user.getAncestryAssociation("Root");
//        Assert.state(groups.length == 51, "");
    }

    @Test
    public void DeeplyNestedEntitiesGroup() {
//        EntitiesGroup group = entitiesGroups.add("Root");
//
//        for (int j = 0; j < 50; j++) {
//            group = group.addChild("Child #" + j);
//        }
//
//        group.associateEntity(feature);
//        EntitiesGroup[] groups = feature.getAncestryAssociation("Root");
//        Assert.state(groups.length == 51, "");
    }

    @Test
    public void CanOnlyAssignAccountsThatAreAssignedToMe() {
        // during first deploy
//        Operation operation = operations.add("/Feature/Delete");
//
//        User secondUser = new User();
//        secondUser.getSrc().setName("Second user");
//        users.add(secondUser);
//
//        EntitiesGroup group1 = entitiesGroups.add("Assigned to " + secondUser.getSrc().getName());
//        AddDefaultPermissions(operation, secondUser);
//
//        EntitiesGroup group2 = entitiesGroups.add("Assigned to " + user.getSrc().getName());
//        AddDefaultPermissions(operation, user);
//
//
//        group2.associateEntity(feature);


        // validate that I can assign a case
//        boolean allowed = user.IsAllowed(feature, "/Feature/Delete");
//        Assert.isTrue(allowed, "");

        // validate that second cannot
//        allowed = secondUser.IsAllowed(feature, "/Feature/Delete");
//        Assert.isTrue(!allowed, "");

        // the act of assigning is simply moving from one entity group to another
        //authorizationRepository.DetachEntityFromGroup(account, "Assigned to " + user.Name);
//        group1.associateEntity(feature);

        // validate that I can not longer assign a case
//        allowed = user.IsAllowed(feature, "/Account/Assign");
//        Assert.isTrue(!allowed, "");

        // validate that second now can assign
//        allowed = secondUser.IsAllowed(feature, "/Account/Assign");
//        Assert.isTrue(allowed, "");
    }

    @Test
    public void CanOnlyViewAccountsThatUserBelongsTo() {
        // on first deploy
//        Operation operation = operations.add("/Account/View");
        // when creating account
//        UsersGroup group = usersGroups.add("Belongs to " + feature.getSrc().getName());

        // setting permission so only associated users can view
//        Permission
//                .Allow(operation)
//                .For(group)
//                .On(feature)
//                .DefaultLevel()
//                .Save();

        // when adding user to account
//        group.associateUser(user);

//        boolean allowed = user.IsAllowed(feature, "/Account/View");
//        Assert.isTrue(allowed, "");
    }

    private void AddDefaultPermissions(Operation operation, User toUser) {
//        EntitiesGroup group = entitiesGroups.add("Assigned to " + toUser.getSrc().getName());
//        Permission
//                .Allow(operation)
//                .For(toUser)
//                .On(group)
//                .DefaultLevel()
//                .Save();
    }
}
