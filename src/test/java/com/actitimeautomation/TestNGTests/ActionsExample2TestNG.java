package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.PropertyHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ActionsExample2TestNG extends BaseClass {
    WebDriver driver;
    PropertyHandling propertyHandling;

    @BeforeClass
    public void setupBrowser() throws IOException {
        launchBrowser("Chrome");
        driver = super.driver;
        propertyHandling = new PropertyHandling();
    }

    @Test
    public void ActionsExample2Test() throws InterruptedException {

//        driver.get("https://online.actitime.com/selenium68/login.do");
        driver.navigate().to(propertyHandling.getProperty("actitimeURL"));
        Thread.sleep(5000);

        Actions actions = new Actions(driver);

        actions.sendKeys(driver.findElement(By.id("username")), propertyHandling.getProperty("username")).build().perform();

        actions.sendKeys(driver.findElement(By.name("pwd")), propertyHandling.getProperty("password")).build().perform();

        actions.click(driver.findElement(By.xpath("//div[starts-with(text(),'Login')]"))).build().perform();
        Thread.sleep(2000);

//        actions.moveToElement(driver.findElement(By.xpath("//div[starts-with(text(),'Login')]"))).build().perform();
//        Thread.sleep(2000);

        //Click on Task module
        actions.click(driver.findElement(By.xpath("//div[text()='Tasks']"))).build().perform();

        //Wait for 5 sec
        Thread.sleep(5000);

        //Scroll to element and perform click operation using Action class
        actions.scrollToElement(driver.findElement(By.xpath("//div[text()='Big Bang Company' and @class='text']")))
                .click(driver.findElement(By.xpath("//div[text()='Big Bang Company' and @class='text']")))
                .build().perform();

        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}