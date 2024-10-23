package com.acme.authorization;

import com.acme.authorization.domain.users.IUsers;
import com.acme.authorization.domain.users.User;
import com.acme.authorization.domain.users_groups.IUsersGroups;
import com.acme.authorization.domain.users_groups.UsersGroup;
import com.acme.authorization.domain.users_groups.UsersGroupsHierarchy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class UsersGroupTest {
    @Autowired
    private IUsersGroups usersGroups;
    @Autowired
    private IUsers users;

    @Test
    public void CreateUsersGroupTest() {
        UsersGroup aaa =  usersGroups.add("aaa");
        UsersGroup db = usersGroups.findUsersGroupByName("aaa");
        Assert.notNull(db,"找不到資料");
    }

    @Test
    public void AddUserGroupToChildsTest() {
        UsersGroup aaa = usersGroups.findUsersGroupByName("aaa");
        UsersGroup ccc =  aaa.addChild("ccc");

        Assert.state(ccc.getParent().getId().equals(aaa.getId()),"ccc's Parent is not aaa");
        Assert.state(aaa.getDescendants().stream().anyMatch(s -> s.getDescendantId().equals(ccc.getId())),"aaa's descendants do not have ccc");
        Assert.state(aaa.getChilds().stream().anyMatch(s -> s.getId().equals(ccc.getId())),"aaa's childs do not have ccc");
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
