package org.example.pageobject.systemmanager;

import org.example.pagefactory.systemmanager.FxApplyFactory;
import org.example.pagefactory.systemmanager.FxManagerFactory;

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

//        进入汇兑申请
        fxManagerFactory.clickFxManagerButton();
        fxManagerFactory.clickFxApplyButton();
        fxManagerFactory.clickCreateFxButton();

//        进入换汇询价
        fxApplyFactory.selectOriginCurrency();
        fxApplyFactory.selectTargeCurrency();
        fxApplyFactory.selectFxGroup();
        fxApplyFactory.selectMember();

        
    }

}
