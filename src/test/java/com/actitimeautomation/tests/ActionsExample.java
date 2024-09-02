package com.actitimeautomation.tests;


import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsExample extends BaseClass
{
    static WebDriver driver;
    public ActionsExample()
    {
        launchBrowser("Chrome");
        driver = super.driver;
    }


    public static void main(String[] args) throws InterruptedException {
        new ActionsExample();
        Thread.sleep(2000);


//        driver.get("https://online.actitime.com/selenium68/login.do");
        driver.navigate().to("https://online.actitime.com/selenium68/login.do");
        Thread.sleep(5000);


        Actions actions = new Actions(driver);


        actions.sendKeys(driver.findElement(By.id("username")), "shahjadeselenium68").build().perform();


        actions.sendKeys(driver.findElement(By.name("pwd")), "Masoom@1937").build().perform();


        actions.click(driver.findElement(By.xpath("//div[starts-with(text(),'Login')]"))).build().perform();
        Thread.sleep(2000);


//        actions.moveToElement(driver.findElement(By.xpath("//div[starts-with(text(),'Login')]"))).build().perform();
//        Thread.sleep(2000);
    }
}