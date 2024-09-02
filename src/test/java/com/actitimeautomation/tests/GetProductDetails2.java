package com.actitimeautomation.tests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetProductDetails2 extends BaseClass
{
    static WebDriver driver;
    public GetProductDetails2()
    {
        launchBrowser("Firefox");
        driver = super.driver;
    }
    public static void main(String[] args) throws InterruptedException {
        new GetProductDetails2();
        driver.navigate().to("https://amazon.in");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("One Plus Phones");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        List<WebElement> productNames = driver.findElements(By.xpath("//div[@data-cy='title-recipe']//descendant::h2//span"));
        System.out.println("Total products is: "+productNames.size());
        for (WebElement productName : productNames)
        {
//            System.out.println(productName.getText());
            if (productName.isDisplayed())
            {
                List<WebElement> productPrices = driver.findElements(By.xpath("//div[@data-cy='price-recipe']/descendant::span/span"));
//                System.out.println(productPrices.size());
                for (WebElement productPrice : productPrices)
                {
//                System.out.println(productPrice.getText());
                    if(productPrice.isDisplayed())
                    {
                        System.out.println("Price of "+productName.getText() +" is " + productPrice.getText());
                        break;
                    }
                }
            }
        }
        driver.close();
//        List<WebElement> productList = driver.findElements(By.xpath("(//div[contains(@class,'s-main-slot')])/div"));
//        System.out.println(productList.size());
//        for (WebElement products: productList)
//        {
//            String productName = products.getText();
//            System.out.println(productName);
//        }
    }
}