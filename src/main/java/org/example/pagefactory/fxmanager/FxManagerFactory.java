package org.example.pagefactory.fxmanager;

import org.example.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author leifeng.cai
 * @description 汇兑申请列表页面
 * @time: 2021/1/18 11:05
 **/
public class FxManagerFactory extends TestBase {

    public FxManagerFactory() {
        PageFactory.initElements(driver, this);
    }

    //点击汇兑管理
    @FindBy(xpath = "//*[@id=\"side-menu\"]/li[9]/a")
    WebElement FxManagerButton;

    public void clickFxManagerButton() {
        FxManagerButton.click();
    }

    //点击汇兑申请并且到当前iframe
    @FindBy(xpath = "//*[@id=\"side-menu\"]/li[9]/ul/li[1]/a")
    WebElement FxApplyButton;


    public void clickFxApplyButton() {
        FxApplyButton.click();
        driver.switchTo().frame("iframe38");
    }

    //点击换汇申请按钮并且切换当前iframe
    @FindBy(xpath = "//*[@id=\"toolbar\"]/a")
    WebElement createFxButton;

    public void clickCreateFxButton() {
        createFxButton.click();
    }

}
