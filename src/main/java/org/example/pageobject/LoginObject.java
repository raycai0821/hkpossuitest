package org.example.pageobject;

import org.example.base.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.example.pagefactory.*;

/**
 * @author leifeng.cai
 * @description 登录页
 * @time: 2020/12/29 13:34
 **/

public class LoginObject extends TestBase {

    /**
     * 登录hkposs
     *
     * @param username
     * @param password
     * @return homeoject
     */
    public HomeObject loginHkposs(String username, String password) throws InterruptedException {

        LoginFactory loginFactory = new LoginFactory();
        loginFactory.setAccount(username);
        loginFactory.setPassword(password);
//        等待输入验证码
        Thread.sleep(5000);
        loginFactory.clickLoginBtn();

        return new HomeObject();

    }

}
