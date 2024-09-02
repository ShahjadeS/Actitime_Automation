package com.actitimeautomation.tests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptExcecutorExample2 extends BaseClass
{
    static WebDriver driver;
    public JavaScriptExcecutorExample2()
    {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    public static void main(String[] args) throws InterruptedException {
        new JavaScriptExcecutorExample2();
        driver.get("https://amazon.in");

        Thread.sleep(5000);

        //Typecast / Downcast "driver" variable into JavaScriptExcecutor
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Scroll Down by pixel using javascript
        js.executeScript("window.scrollBy(0, 1000)");
        System.out.println("Scroll Down by pixel --> Done");

        Thread.sleep(3000);

        //Scroll at the bottom of the page
//        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        System.out.println("Scroll bottom of the page --> Done");

        Thread.sleep(3000);

        //Scroll Up by pixel using javascript
        js.executeScript("window.scrollBy(0, -500)");
        System.out.println("Scroll Up by pixel --> Done");

        Thread.sleep(3000);

        //To scroll down the web page by the visibility of the element
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[@class='action-inner']")));
        System.out.println("Scroll down till visibility of the element --> Done");

        Thread.sleep(3000);

        driver.close();
    }
}