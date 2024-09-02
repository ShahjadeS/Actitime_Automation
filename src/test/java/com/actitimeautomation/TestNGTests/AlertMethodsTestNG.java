package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AlertMethodsTestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Firefox");
        driver = super.driver;
    }

    @Test
        public void AlertMethodsTest() throws InterruptedException {
        driver.navigate().to("https://google.com");

        Thread.sleep(5000);

        //Downcasting driver variable from WebDriver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

//        //Information Alert =====================================
//        js.executeScript("alert('This is a Information Alert...!')");
//        Thread.sleep(5000);
//        //Handling Information Alert
//        Alert alert1 = driver.switchTo().alert();
//        Thread.sleep(5000);
//        //1. By using accept() method
//        alert1.accept();

//        //Confirmation Alert =====================================
//        js.executeScript("confirm('This is a Confirmation Alert...!')");
//        Thread.sleep(5000);
//        //Handling Confirmation Alert
//        Alert alert2 = driver.switchTo().alert();
//        Thread.sleep(5000);
//        //2. By using accept() or dismiss() method
////        alert2.accept();
//        alert2.dismiss();

        //Propmt Alert =====================================
        js.executeScript("prompt('This is a Prompt Alert...!')");
        Thread.sleep(5000);
        //Handling Propmt Alert
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Hello");
        Thread.sleep(5000);
        //3. By using SendKeys() and accept() or dismiss() method
        // and getText() for get the text which we we pass into the sendKeys() method
        alert3.accept();
//        alert3.dismiss();
        Thread.sleep(5000);
    }
    @AfterClass
    public void closeBrowser()
    {
        driver.close();
    }
}