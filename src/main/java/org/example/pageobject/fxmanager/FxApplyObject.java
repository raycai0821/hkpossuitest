package org.example.pageobject.fxmanager;

import org.example.base.TestBase;
import org.example.pagefactory.fxmanager.FxApplyFactory;
import org.example.pagefactory.fxmanager.FxManagerFactory;
import org.example.utiles.DirectionEnum;
import org.example.utiles.IframeHelper;
import org.example.utiles.LocaterHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @author leifeng.cai
 * @description 汇兑申请
 * @time: 2021/1/18 14:29
 **/
public class FxApplyObject extends TestBase {

    //创建建汇兑申请订单
    public void createConversion() throws InterruptedException {
        FxManagerFactory fxManagerFactory = new FxManagerFactory();
        FxApplyFactory fxApplyFactory = new FxApplyFactory();

        //进入汇兑申请
        fxManagerFactory.clickFxManagerButton();
        fxManagerFactory.clickFxApplyButton();
        //进入换汇询价
        fxManagerFactory.clickCreateFxButton();
        //切到当前iframe
        IframeHelper.switchByIframeSrc("/fx/transBatch/add", driver);
        //输入询价条件
        fxApplyFactory.selectOriginCurrency();
        fxApplyFactory.selectTargetCurrency();
        fxApplyFactory.selectFxGroup();
        Thread.sleep(2000);
//        fxApplyFactory.clickMember();

        //根据配置文件中member在页面member列表中找到该元素
        WebElement memberElement = LocaterHelper.locaterByTd(fxApplyFactory.getMemberTable(),
                properties.getProperty("member"));
        String xpath = LocaterHelper.getAmountInputXpath(memberElement, DirectionEnum.TARGET);
        memberElement.click();
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(3000);
        //输入金额点击确认按钮
        fxApplyFactory.sendInputAmount(properties.getProperty("amount"));
        //确认金额
        fxApplyFactory.clickInputConfirmButton();
        //选择交割日期
        fxApplyFactory.selectConversionType("T1");
        //输入附言
        fxApplyFactory.inputReference("自动化测试");
        //点击提交询价
        fxApplyFactory.clickSubmitButton();
        //确认询价
        fxApplyFactory.clickConversionConfirmPopup();

    }

}
