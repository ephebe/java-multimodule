package com.acme.authorization;

import com.acme.authorization.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class UsersGroupTest {
    @Autowired
    private UsersGroups usersGroups;
    @Autowired
    private Users users;

    @Test
    public void CreateUsersGroupTest() {
        UsersGroup aaa =  usersGroups.add("aaa");
        UsersGroup db = usersGroups.findUsersGroupByName("aaa");
        Assert.notNull(db,"找不到資料");
    }

    @Test
    public void AddUserGroupToChildsTest() {
        UsersGroup aaaa = usersGroups.findUsersGroupByName("aaaa");
        UsersGroup cccc = aaaa.addChild("cccc");

        Assert.state(cccc.getParent() == aaaa,"");
        Assert.state(aaaa.getDescendants().contains(cccc),"");
        Assert.state(aaaa.getChilds().contains(cccc),"");
    }

    @Test
    public void SetParentUsersGroupTest() {
        UsersGroup aaaa = usersGroups.findUsersGroupByName("aaaa");
        UsersGroup bbbb = usersGroups.findUsersGroupByName("bbbb");
        aaaa.switchParent(bbbb);
    }

    @Test
    public void GetDescendantsTest() {
        UsersGroup aaaa = usersGroups.findUsersGroupByName("aaaa");
        List<UsersGroupsHierarchy> descendants =  aaaa.getDescendants();
        Assert.state(descendants.size() == 1,"");
    }

    @Test
    public void GetAncestorsTest() {
        UsersGroup aaaa = usersGroups.findUsersGroupByName("aaaa");
        List<UsersGroupsHierarchy> ancestors =  aaaa.getAncestors();
        Assert.state(ancestors.size() == 1,"");
    }

    public void AssociateUserToUsersGroup() {
        UsersGroup aaaa = usersGroups.findUsersGroupByName("aaaa");
        User k = users.findByName("k");

        aaaa.associateUser(k);

        Assert.state(aaaa.getUsersGroupUsers().size() ==1,"");
    }
}
