package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GetProductDetails2TestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Firefox");
        driver = super.driver;
    }

    @Test
    public void GetProductDetails2Tes() throws InterruptedException {
        new GetProductDetails2TestNG();
        driver.navigate().to("https://amazon.in");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("One Plus Phones");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
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
//        List<WebElement> productList = driver.findElements(By.xpath("(//div[contains(@class,'s-main-slot')])/div"));
//        System.out.println(productList.size());
//        for (WebElement products: productList)
//        {
//            String productName = products.getText();
//            System.out.println(productName);
//        }
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}