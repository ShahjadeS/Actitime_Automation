package com.actitimeautomation.tests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetProductDetails4 extends BaseClass {
    static WebDriver driver;

    public GetProductDetails4() {
        launchBrowser("Firefox");
        driver = super.driver;
    }

    public static void main(String[] args) throws InterruptedException {
        new GetProductDetails4();
        driver.navigate().to("https://amazon.in");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Jeans");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        Thread.sleep(2000);

        List<WebElement> productNames = driver.findElements(By.xpath("//div[@data-cy='title-recipe']//descendant::h2[2]//span"));
        List<WebElement> productPrices = driver.findElements(By.xpath("//div[@data-cy='price-recipe']/descendant::span[@class='a-offscreen'][1]"));

//        String ad1Name = "Aishwarya Rai";
//        String ad2Name = "Prashanth";
        String adName = "Jeans";

        System.out.println("Total products is: " + productNames.size());
        System.out.println("Total products is: " + productPrices.size());

        for (int i = 0; i < productNames.size(); i++)
        {
            WebElement productName = productNames.get(i);
            String productTitle = productName.getText();

            if (!productTitle.startsWith(adName))
            {
                if (productName.isDisplayed() && i < productPrices.size())
                {
                    WebElement productPrice = productPrices.get(i);
                    if (productPrice.isDisplayed())
                    {
                        System.out.println("Price of " + productTitle + " is " + productPrice.getText());
                    }
                }
            }
        }
        driver.close();
    }
}