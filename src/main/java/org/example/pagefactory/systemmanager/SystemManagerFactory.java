package org.example.pagefactory.systemmanager;


import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.security.acl.LastOwnerException;
import java.util.List;
import java.util.Set;

/**
 * @author leifeng.cai
 * @description 主页-系统管理
 * @time: 2021/1/14 17:27
 **/

public class SystemManagerFactory extends TestBase {

    public SystemManagerFactory() {
        PageFactory.initElements(driver, this);
    }

    //    点击系统管理
    @FindBy(xpath = "//*[@id=\"side-menu\"]/li[3]/a/span[1]")
    WebElement system_manager_button;

    public void clickSystemManagerButton() {
        system_manager_button.click();
    }

    //    点击用户管理并且切换到该iframe下
    @FindBy(xpath = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")
    WebElement user_manager_button;

    public void clickUserManagerButton() throws InterruptedException {
        user_manager_button.click();
        Thread.sleep(3000);
        driver.switchTo().frame("iframe2");
    }

    //    用户table中所有的tr数据
    @FindBy(xpath = "//*[@id=\"bootstrap-table\"]/tbody")
    WebElement user_table;

    public List<WebElement> getUserTable() {
        return user_table.findElements(By.tagName("tr"));

    }
//   登录名输入框
    @FindBy(xpath = "//*[@id=\"user-form\"]/div/ul/li[1]/input")
    WebElement login_name;
    public void setLogin_name(){
        login_name.sendKeys(properties.getProperty("username"));
    }


//  手机号码输入框
    @FindBy(xpath = "//*[@id=\"user-form\"]/div/ul/li[2]/input")
    WebElement phone;
    public void setPhone(){
        phone.sendKeys(properties.getProperty("phone"));
    }


//    搜索按钮
    @FindBy(xpath = "//*[@id=\"user-form\"]/div/ul/li[5]/a[1]")
    WebElement searchButton;
    public void clickSearchButton(){
        searchButton.click();
    }

//    重置按钮
    @FindBy(xpath = "//*[@id=\"user-form\"]/div/ul/li[5]/a[2]")
    WebElement recoverButton;
    public void clickRecoverButton(){
        recoverButton.click();

    }


}
