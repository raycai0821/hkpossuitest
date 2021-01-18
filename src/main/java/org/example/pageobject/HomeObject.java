package org.example.pageobject;

import org.example.base.TestBase;
import org.example.pagefactory.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author leifeng.cai
 * @description 首页
 * @time: 2020/12/30 16:24
 **/
public class HomeObject extends TestBase {

//    获取主页title
    public String getTile() {
        HomeFactory homeFactory = new HomeFactory();
        return homeFactory.getTitle();
    }

}
