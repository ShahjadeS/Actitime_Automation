package com.actitimeautomation.tests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetProductDetails3 extends BaseClass {
    static WebDriver driver;

    public GetProductDetails3() {
        launchBrowser("Firefox");
        driver = super.driver;
    }

    public static void main(String[] args) throws InterruptedException {
//        new GetProductDetails3();
//        driver.navigate().to("https://amazon.in");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Jeans");
//        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
//        List<WebElement> productNames = driver.findElements(By.xpath("(//div[@data-cy='title-recipe'])"));
//        System.out.println("Total products is: " + productNames.size());
//        for (WebElement productName : productNames) {
////            System.out.println(productName.getText());
////            String ad1Name = "Aishwarya Rai";
////            String ad2Name = "Prashanth";
//            WebElement ad1 = driver.findElement(By.xpath("(//div[@data-cy='title-recipe'])[5]"));
//            WebElement ad2 = driver.findElement(By.xpath("(//div[@data-cy='title-recipe'])[7]"));
//            if (!(productName.equals(ad1.getText())) && !(productName.equals(ad2.getText())))
//            if (productName.isDisplayed()) {
//                List<WebElement> productPrices = driver.findElements(By.xpath("//div[@data-cy='price-recipe']/descendant::span/span"));
////                System.out.println(productPrices.size());
//                for (WebElement productPrice : productPrices) {
////                System.out.println(productPrice.getText());
//                    if (productPrice.isDisplayed()) {
//                        System.out.println("Price of " + productName.getText() + " is " + productPrice.getText());
//                        break;
//                    }
//                }
//            }
//        }
//=================================================================================================================================================
//=================================================================================================================================================

        new GetProductDetails3();
        driver.navigate().to("https://amazon.in");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Jeans");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        Thread.sleep(2000);

        List<WebElement> productNames = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        List<WebElement> productPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

        String ad1Name = "Aishwarya Rai";
        String ad2Name = "Prashanth";

        System.out.println("Total products is: " + productNames.size());
        System.out.println("Total product of size is: "+productPrices.size());

        for (int i = 0; i < productNames.size(); i++) {
            WebElement productName = productNames.get(i);
            String nameText = productName.getText();

            if (!nameText.contains(ad1Name) && !nameText.contains(ad2Name)) {
                if (productName.isDisplayed() && i < productPrices.size()) {
                    WebElement productPrice = productPrices.get(i);
                    if (productPrice.isDisplayed()) {
                        System.out.println("Price of " + nameText + " is " + productPrice.getText());
                    }
                }
            }
        }
        driver.close();
    }
}