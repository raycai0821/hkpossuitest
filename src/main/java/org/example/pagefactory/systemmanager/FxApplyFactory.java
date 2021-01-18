package org.example.pagefactory.systemmanager;

import org.example.base.TestBase;
import org.openqa.selenium.support.PageFactory;

/**
 * @author leifeng.cai
 * @description 换汇询价页面
 * @time: 2021/1/18 11:21
 **/
public class FxApplyFactory extends TestBase {

    public FxApplyFactory() {
        PageFactory.initElements(driver,this);
    }
}
