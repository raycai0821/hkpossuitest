package org.example.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author leifeng.cai
 * @description
 * @time: 2020/12/30 9:51
 **/


public class TestBase {

    public static WebDriver driver;
    public static Properties properties;

  /**  加载配置类
   *
   * **/
    public TestBase() {
        try {
            properties = new Properties();
            //读取配置文件
            FileInputStream inputStream = new FileInputStream(
                    "src\\resources\\config.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    *选择浏览器，根据配置文件初始化浏览器
    *
     **/
    public static void init() {
        //获取browsername
        String browserName = properties.getProperty("browser");

        if ("chrome".equals(browserName)) {
            System.setProperty("webdriver.chrome.driver", "src\\resources\\driver\\win\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if ("firefox".equals(browserName)) {
            System.setProperty("webdriver.chrome.driver", "src\\driver\\win\\firefox.exe");
            driver = new FirefoxDriver();
        }
        //放大浏览器
        driver.manage().window().maximize();
        //从配置文件中读取页面加载过期时间
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(properties.getProperty("loadtimeout")), TimeUnit.SECONDS);
        //从配置文件读取元素等待时间
        driver.manage().timeouts().implicitlyWait(Long.parseLong(properties.getProperty("implicitly_wait")), TimeUnit.SECONDS);

        driver.get(properties.getProperty("url"));

    }

    /**
     * 退出浏览器
     *
     * **/

    public static void quit(){

        driver.quit();

    }


}
