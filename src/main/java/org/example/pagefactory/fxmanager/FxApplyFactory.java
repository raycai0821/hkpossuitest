package org.example.pagefactory.fxmanager;

import org.example.base.TestBase;
import org.example.utiles.DirectionEnum;
import org.example.utiles.LocaterHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;
import java.math.BigDecimal;
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
    @FindBy(xpath = "//*[@id=\"groupId\"]")
    WebElement fxGroup;

    public void selectFxGroup() {
        Select select = new Select(fxGroup);
        select.selectByVisibleText(properties.getProperty("fxGroup"));
    }

    //会员选择框
    @FindBy(xpath = "//*[@id=\"memberInfo\"]")
    WebElement member;

    public void clickMember() throws InterruptedException {
        member.click();
        Thread.sleep(1000);

    }

    //获取会员table中的所有会员数据
    @FindBy(xpath = "//*[@id=\"bootstrap-table\"]/tbody")
    WebElement memberTable;

    public List<WebElement> getMemberTable() {
        return memberTable.findElements(By.tagName("tr"));

    }

    //金额输入框
    @FindBy(className = "input-sm")
    WebElement amountInputBox;

    public void sendInputAmount(String amount) {
        amountInputBox.sendKeys(amount);

    }

    //金额确认按钮
    @FindBy(className = "glyphicon-ok")
    WebElement inputConfirmButton;
    public void clickInputConfirmButton(){
        inputConfirmButton.click();
    }

    //交割方式
    @FindBy(xpath = "//*[@id=\"form1\"]/div/ul/li[1]/select")
    WebElement conversionType;
    public void selectConversionType(String type){
        Select select = new Select(conversionType);
        select.selectByValue(type);
    }

    //交易附言
    @FindBy(xpath = "//*[@id=\"form1\"]/div/ul/li[2]/textarea")
    WebElement reference;
    public void inputReference(String text){
        reference.sendKeys(text);
    }

    //提交询价
    @FindBy(xpath = "/html/body/div/section[3]/div/a")
    WebElement submitButton;
    public void clickSubmitButton(){
        submitButton.click();
    }

    //是否询价确认框
    @FindBy(className = "layui-layer-btn0")
    WebElement conversionConfirmPopup;
    public void clickConversionConfirmPopup(){
        conversionConfirmPopup.click();
    }




}
