package com.actitimeautomation.tests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExample2 extends BaseClass
{
    static WebDriver driver;
    public ActionsExample2()
    {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    public static void main(String[] args) throws InterruptedException {
        new ActionsExample2();
        Thread.sleep(2000);

//        driver.get("https://online.actitime.com/selenium68/login.do");
        driver.navigate().to("https://online.actitime.com/actiselenium68/login.do");
        Thread.sleep(5000);

        Actions actions = new Actions(driver);

        actions.sendKeys(driver.findElement(By.id("username")), "csseleniumbatch").build().perform();

        actions.sendKeys(driver.findElement(By.name("pwd")), "CSSeleniumBatch").build().perform();

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
        driver.close();
    }
}