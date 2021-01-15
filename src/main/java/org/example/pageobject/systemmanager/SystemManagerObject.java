package org.example.pageobject.systemmanager;

import org.example.base.TestBase;
import org.example.pagefactory.systemmanager.SystemManagerFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

/**
 * @author leifeng.cai
 * @description 系统管理
 * @time: 2021/1/14 17:31
 **/
public class SystemManagerObject extends TestBase {

    public SystemManagerObject() {
        PageFactory.initElements(driver, this);
    }

    /**
     * 获取usertable中的数据
     *
     * */
    public List<WebElement> getUsers() throws InterruptedException {
        SystemManagerFactory systemManagerFactory = new SystemManagerFactory();
        systemManagerFactory.clickSystemManagerbutton();
        systemManagerFactory.clickUserManagerButton();
        return systemManagerFactory.getUserTable();
    }

}
