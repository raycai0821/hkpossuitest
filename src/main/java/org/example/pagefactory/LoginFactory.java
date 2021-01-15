package org.example.pagefactory;

import org.example.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author leifeng.cai
 * @description 登录页
 * @time: 2020/12/29 13:41
 **/
public class LoginFactory extends TestBase {

    public LoginFactory() {
        PageFactory.initElements(driver,this);
    }

    //定位账号的位置
    @FindBy(xpath = "//*[@id=\"signupForm\"]/input[1]")
    WebElement accountpos;
    public void setAccount(String account) {
        accountpos.sendKeys(account);
    }

    //定位密码的位置
    @FindBy(xpath = "//*[@id=\"signupForm\"]/input[2]")
    WebElement passwordpos;
    public void setPassword(String password) {
        passwordpos.sendKeys(password);
    }

    //定位验证码的位置
    @FindBy(xpath = "//*[@id=\"signupForm\"]/div[1]/div[1]/input")
    WebElement verifycodepos;
    public void setVerifycode(String verifycode) {
        verifycodepos.sendKeys(verifycode);
    }

    //定位登录按钮
    @FindBy(xpath = "//*[@id=\"btnSubmit\"]")
    WebElement loginBtn;
    public void clickLoginBtn() {
        loginBtn.click();
    }

}
