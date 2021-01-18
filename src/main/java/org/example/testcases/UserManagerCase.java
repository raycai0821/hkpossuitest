package org.example.testcases;

import org.example.base.TestBase;
import org.example.pageobject.systemmanager.SystemManagerObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;

/**
 * @author leifeng.cai
 * @description 系统管理-用户管理
 * @time: 2021/1/15 11:39
 **/
public class UserManagerCase {

    SystemManagerObject systemManagerObject = new SystemManagerObject();

    @Test(testName = "系统设置-获取用户列表测试", priority = 1)
    public void testGetUser() throws InterruptedException {
        Assert.assertNotEquals(systemManagerObject.getUsers().size(), 0, "获取用户列表失败");
    }

    @Test(testName = "使用用户名搜索测试", priority = 2)
    public void testSearchUserByUsername(){
        Assert.assertEquals(systemManagerObject.searchByUsername().size(),1,"使用用户名查询失败");

    }

    @Test(testName = "使用手机搜索测试", priority = 3)
    public void testSearchUserByPhone(){
        Assert.assertEquals(systemManagerObject.searchByPhone().size(),1,"使用手机号查询失败");

    }
}
