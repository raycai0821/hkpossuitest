package org.example.pagefactory.fxmanager;

import org.example.base.TestBase;
import org.example.pagefactory.SwitchIframe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.example.base.TestBase.driver;

/**
 * @author leifeng.cai
 * @description 换汇询价页面
 * @time: 2021/1/18 11:21
 **/
public class FxApplyFactory extends TestBase implements SwitchIframe{

    public FxApplyFactory() {
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
    WebElement targeCurrency;

    //选中USD
    public void selectTargeCurrency() {

        Select select = new Select(targeCurrency);
        select.selectByValue(properties.getProperty("targeCurrency"));
    }

    //汇兑组选择框
    @FindBy(xpath = "//*[@id=\"groupId\"]")
    WebElement fxGroup;

    public void selectFxGroup() {
        Select select = new Select(fxGroup);
        select.selectByValue(properties.getProperty("fxGroup"));
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

    public String getCurrentIframeName(){

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        String currentIframeName = null;
        Iterator<WebElement> iterator = iframes.iterator();
        while(iterator.hasNext()){
            WebElement iframe = iterator.next();
            if(iframe.getAttribute("src").equals("/fx/transBatch/add")){
                currentIframeName = iframe.getAttribute("name");
                break;
            }
        }
        return currentIframeName;
    }

    @Override
    public void switchToCurrentIframe(String iframeName) {
        driver.switchTo().frame(iframeName);
    }

    @Override
    public void switchToTopIframe() {

    }
}
