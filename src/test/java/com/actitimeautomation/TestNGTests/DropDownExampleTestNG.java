package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExampleTestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        //launchBrowser("Firefox"); --> Not working
        launchBrowser("Chrome");
        driver = super.driver;
    }

    @Test
    public void DropDownExampleTest() throws InterruptedException {
        new DropDownExampleTestNG();
        driver.navigate().to("https://www.amazon.in/");
        Thread.sleep(5000);

        //Create an instance / object of Select class
        Select select = new Select(driver.findElement(By.id("searchDropdownBox")));

        //1. Select by Text --> selectByVisibleText()
//        select.selectByVisibleText("Computers & Accessories");
//        Thread.sleep(2000);

        //2. Select by Value --> selectByValue()
//        select.selectByValue("search-alias=automotive");
//        Thread.sleep(2000);

        //3. Select by Index -->
        select.selectByIndex(19); //Furniture
        Thread.sleep(2000);

//        //Enter the text in search area
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("TV Unit");
//
//        //Click on Search icon
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(5000);

        List<WebElement> productNames = driver.findElements(By.xpath("//div[@data-cy='title-recipe']//descendant::h2//span"));
        System.out.println("Total products is: " + productNames.size());
        for (WebElement productName : productNames) {
//            System.out.println(productName.getText());
            if (productName.isDisplayed()) {
                List<WebElement> productPrices = driver.findElements(By.xpath("//div[@data-cy='price-recipe']/descendant::span/span"));
//                System.out.println(productPrices.size());
                for (WebElement productPrice : productPrices) {
//                System.out.println(productPrice.getText());
                    if (productPrice.isDisplayed()) {
                        System.out.println("Price of " + productName.getText() + " is " + productPrice.getText());
                        break;
                    }
                }
            }
        }
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}