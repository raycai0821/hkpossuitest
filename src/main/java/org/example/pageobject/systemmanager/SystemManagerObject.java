package org.example.pageobject.systemmanager;

import org.example.base.TestBase;
import org.example.pagefactory.systemmanager.SystemManagerFactory;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author leifeng.cai
 * @description 系统管理
 * @time: 2021/1/14 17:31
 **/
public class SystemManagerObject {


    /**
     * 获取usertable中的数据
     */
    public List<WebElement> getUsers() throws InterruptedException {
        SystemManagerFactory systemManagerFactory = new SystemManagerFactory();
        systemManagerFactory.clickSystemManagerButton();
        systemManagerFactory.clickUserManagerButton();
        return systemManagerFactory.getUserTable();
    }

    /**
     * 输入登录名搜索
     *
     * */
    public List<WebElement> searchByUsername() {
        SystemManagerFactory systemManagerFactory = new SystemManagerFactory();
        systemManagerFactory.setLogin_name();
        systemManagerFactory.clickSearchButton();
        return systemManagerFactory.getUserTable();
    }

    /**
     * 输入手机号搜索
     * */
    public List<WebElement>  searchByPhone() {
        SystemManagerFactory systemManagerFactory = new SystemManagerFactory();
//        清空当前搜索框
        systemManagerFactory.clickRecoverButton();
        systemManagerFactory.setPhone();
        systemManagerFactory.clickSearchButton();
        return systemManagerFactory.getUserTable();
    }

}
