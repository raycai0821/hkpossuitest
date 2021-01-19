package org.example.pageobject.fxmanager;

import org.example.pagefactory.fxmanager.FxApplyFactory;
import org.example.pagefactory.fxmanager.FxManagerFactory;

/**
 * @author leifeng.cai
 * @description 汇兑申请
 * @time: 2021/1/18 14:29
 **/
public class FxApplyObject {

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
        fxApplyFactory.switchToCurrentIframe();
        //输入询价条件
        fxApplyFactory.selectOriginCurrency();
        fxApplyFactory.selectTargetCurrency();
        fxApplyFactory.selectFxGroup();
        fxApplyFactory.selectMember();
        System.out.println("=====获取到" + fxApplyFactory.getMemberTable().get(0).getText());

    }

}
