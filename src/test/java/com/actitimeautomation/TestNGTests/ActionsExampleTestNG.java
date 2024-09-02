package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsExampleTestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    @Test
    public void ActionExampleTest() throws InterruptedException {

//        driver.get("https://online.actitime.com/selenium68/login.do");
        driver.navigate().to("https://online.actitime.com/actiselenium68/login.do");
        Thread.sleep(5000);

        Actions actions = new Actions(driver);

        actions.sendKeys(driver.findElement(By.id("username")), "csseleniumbatch").build().perform();

        actions.sendKeys(driver.findElement(By.name("pwd")), "CSSeleniumBatch").build().perform();

        actions.click(driver.findElement(By.xpath("//div[starts-with(text(),'Login')]"))).build().perform();
        Thread.sleep(5000);

//        actions.moveToElement(driver.findElement(By.xpath("//div[starts-with(text(),'Login')]"))).build().perform();
//        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
//        driver.quit();
    }
}