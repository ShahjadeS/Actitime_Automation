package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDropExampleTestNG extends BaseClass
{
    WebDriver driver;
    @BeforeClass
    public void setupBrowser()
    {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    @Test
    public void DragAndDropExampleTest() throws InterruptedException {
        new DragAndDropExampleTestNG();
//        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.navigate().to("https://www.globalsqa.com/demo-site/draganddrop/");

        //Wait for 5 sec
        Thread.sleep(5000);

        String windowId = driver.getWindowHandle();

        driver.switchTo().frame(driver.findElement(By.xpath("//div[@rel-title='Photo Manager']//iframe")));
//        driver.switchTo().frame(1);
//        driver.switchTo().frame("Name of iFrame / Id of iFrame");

        WebElement sourceElement =  driver.findElement(By.xpath("//ul[@id='gallery']/li[1]/img"));
        WebElement destinationElement = driver.findElement(By.xpath("//div[@id='trash']"));

        Actions actions = new Actions(driver);

//        actions.clickAndHold(sourceElement).release(destinationElement).build().perform();
        actions.dragAndDrop(sourceElement, destinationElement).build().perform();
        System.out.println("Element is succsessfully moved...!");

        //Switch control back to Window
        driver.switchTo().window(windowId);

        Thread.sleep(2000);
    }
    @AfterClass
    public void closeBrowser()
    {
        driver.close();
    }
}