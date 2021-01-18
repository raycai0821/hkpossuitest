package org.example.testcases.fx;

import org.example.pagefactory.fxmanager.FxApplyFactory;
import org.example.pageobject.fxmanager.FxApplyObject;
import org.testng.annotations.Test;

/**
 * @author leifeng.cai
 * @description
 * @time: 2021/1/18 15:15
 **/
public class FxTestCase {

    FxApplyObject fxApplyObject = new FxApplyObject();

    @Test(testName = "换汇询价测试")
    public void testFxConversion() throws InterruptedException {
        fxApplyObject.createConversion();
    }
}
