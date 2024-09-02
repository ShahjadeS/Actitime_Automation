package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeyBoardExamples2TestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Edge");
        driver = super.driver;
    }

    @Test
    public void KeyBoardExamples2Test() throws InterruptedException {
        new KeyBoardExamples2TestNG();
        driver.get("https://online.actitime.com/actiselenium68/login.do");

        //Wait for 5 sec
        Thread.sleep(5000);

        //Actions class ===================================================
        //keyDown(CharSequence Key)
        //keyUp(CharSequence Key)
        //keyDown(WebElement target, CharSequence Key)
        //keyUp(WebElement target, CharSequence Key)
        //=================================================================
        //1st Approach
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("abc", "123");

        //Wait for 2 sec
        Thread.sleep(2000);

//        Actions actions1 = new Actions(driver);
//        actions1.keyDown(Keys.ENTER).build().perform();
//        actions1.keyUp(Keys.ENTER).build().perform();

        //2nd Approach
        WebElement loginButton1 = driver.findElement(By.xpath("//div[starts-with(text(),'Login')]"));
        Actions actions2 = new Actions(driver);
        actions2.keyDown(loginButton1, Keys.ENTER).build().perform();
        actions2.keyUp(loginButton1, Keys.ENTER).build().perform();

        //Wait for 2 sec
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}