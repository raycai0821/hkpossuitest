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


    @Test(testName = "系统设置-用户管理测试")
    public void testGetUser() throws InterruptedException {
        SystemManagerObject systemManagerObject = new SystemManagerObject();
        Assert.assertNotEquals(systemManagerObject.getUsers().size(),0);
    }

}
