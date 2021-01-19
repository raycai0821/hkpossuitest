package org.example.utiles;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

/**
 * @author leifeng.cai
 * @description iframe查找跳转等
 * @time: 2021/1/19 8:58
 **/
public class IframeHelper {

    /**
     * @param attribute
     * @return iframe.name
     * @description 通过传入标签参数来找到ifram的name
     */
    public static String getIframeBySrc(String attribute, WebDriver driver) throws InterruptedException {

//        切到顶层iframe
        switchToTopIframe(driver);
        Thread.sleep(1000);

//        通过tag=iframe找到当前所有ifame
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        String currentIframeName = null;
        Iterator<WebElement> iterator = iframes.iterator();
        System.out.println("一共几个iframes" + iframes.size());

//        遍历找到的iframes根据data-id定位所需iframe的name
        while (iterator.hasNext()) {
            WebElement iframe = iterator.next();
            if (iframe.getAttribute("data-id").equals(attribute)) {
                currentIframeName = iframe.getAttribute("name");
                System.out.println("当前frame" + currentIframeName);
                break;
            }
        }
        return currentIframeName;
    }

    /**
     * @description 切换到指定src对应的name iframe下
     * @param src
     * @param driver
     * @throws InterruptedException
     */

    public static void switchByIframeSrc(String src,WebDriver driver) throws InterruptedException {
        String iframe = getIframeBySrc(src, driver);
        System.out.println("要切换的frame为" + iframe);
        driver.switchTo().frame(iframe);
    }

    /**
     * @description  切换到顶层iframe
     * @param driver
     */
    public static void switchToTopIframe(WebDriver driver){
        driver.switchTo().defaultContent();
    }


}
