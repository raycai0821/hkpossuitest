package org.example.testcases;

import org.example.base.TestBase;
import org.example.pagefactory.*;
import org.example.pageobject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

/**
 * @author leifeng.cai
 * @description 登录测试
 * @time: 2020/12/30 9:23
 **/

public class LoginCase extends TestBase {

    //开始测试前使用init打开浏览器，初始化配置
    @BeforeTest
    public void setUp() {
        //打开浏览器，登录主页
        init();
    }

    LoginObject loginObject = new LoginObject();
    HomeObject homeObject = new HomeObject();

//    测试登录成功
    @Test(testName = "登录测试")
    public void testLoginSuccess() throws InterruptedException {

        homeObject = loginObject.loginHkposs(properties.getProperty("username"), properties.getProperty("password"));
//        等待跳转到主页
        Thread.sleep(3000);
//        用title断言是否登录
        Assert.assertEquals(homeObject.getTile(), properties.getProperty("home_title"));


    }

//    测试登录失败
//    @Test
//    public void testLoginFail() {
//        homeObject = loginObject.loginHkposs(properties.getProperty("username_fail"), properties.getProperty("password_fail"));
//        //用title断言是否登录
//
//    }


}
