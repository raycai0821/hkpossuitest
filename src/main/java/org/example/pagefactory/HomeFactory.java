package org.example.pagefactory;

import org.example.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author leifeng.cai
 * @description 首页
 * @time: 2020/12/30 16:25
 **/
public class HomeFactory extends TestBase {

//    主页
    @FindBy(xpath = "//*[@id=\"side-menu\"]/li[2]/a/span[1]")
    WebElement home_header;
    public void clickHomeHeader(){
        home_header.click();
    }

//    获取主页title
    public String getTitle() {

        return driver.getTitle();
    }

    public HomeFactory() {
        PageFactory.initElements(driver,this);
    }





}
