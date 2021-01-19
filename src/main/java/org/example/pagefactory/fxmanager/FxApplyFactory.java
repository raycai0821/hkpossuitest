package org.example.pagefactory.fxmanager;

import org.example.base.TestBase;
import org.example.utiles.IframeFinder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * @author leifeng.cai
 * @description 换汇询价页面
 * @time: 2021/1/18 11:21
 **/
public class FxApplyFactory extends TestBase {

    public FxApplyFactory() throws InterruptedException {
        PageFactory.initElements(driver, this);
    }

    //源币种选择框
    @FindBy(xpath = "//*[@id=\"sourceCur\"]")
    WebElement originCurrency;

    //选中cny
    public void selectOriginCurrency() {
        Select select = new Select(originCurrency);
        select.selectByValue(properties.getProperty("originCurrency"));
    }


    //目标币种选择框
    @FindBy(xpath = "//*[@id=\"targetCur\"]")
    WebElement targetCurrency;

    //选中USD
    public void selectTargetCurrency() {
        Select select = new Select(targetCurrency);
        select.selectByValue(properties.getProperty("targetCurrency"));
    }

    //汇兑组选择框
    @FindBy( xpath = "//*[@id=\"groupId\"]")
    WebElement fxGroup;

    public void selectFxGroup() {
        Select select = new Select(fxGroup);

        System.out.println("所有选项" + select.getOptions());
        select.selectByVisibleText(properties.getProperty("fxGroup"));
    }

    //会员选择框
    @FindBy(xpath = "//*[@id=\"memberInfo\"]")
    WebElement member;

    public void selectMember() throws InterruptedException {
        member.click();
        Thread.sleep(1000);

    }

    //获取会员table中的所有会员数据
    @FindBy(xpath = "//*[@id=\"bootstrap-table\"]/tbody")
    WebElement memberTable;

    public List<WebElement> getMemberTable() {
        return memberTable.findElements(By.tagName("tr"));

    }

    public void switchToCurrentIframe() throws InterruptedException {
        driver.switchTo().frame(IframeFinder.getIframeBySrc(("/fx/transBatch/add"),driver));
    }
}
