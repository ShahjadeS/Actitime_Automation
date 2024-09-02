package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptExcecutorExampleTestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    @Test
    public void JavaScriptExcecutorExampleTest() throws InterruptedException {
        driver.get("https://online.actitime.com/actiselenium68/login.do");
//        WebElement loginButton1 = driver.findElement(By.xpath("//div[starts-with(text(),'Login')]"));

        Thread.sleep(5000);

        //Typecast / Downcast "driver" variable into JavaScriptExcecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Enter text (Username) using javascript
        js.executeScript("arguments[0].value='csseleniumbatch';", driver.findElement(By.id("username")));
        //Enter text (Password) using javascript
        js.executeScript("arguments[0].value='CSSeleniumBatch';", driver.findElement(By.name("pwd")));

        //Click on Login button using javascript
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[starts-with(text(),'Login')]")));
//        js.executeScript("arguments[0].click();", loginButton1);

        Thread.sleep(5000);

        //Get the title of the Page
        String pageTitle = js.executeScript("return document.title;").toString();
        System.out.println("Title of the Webpage is: " + pageTitle);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}