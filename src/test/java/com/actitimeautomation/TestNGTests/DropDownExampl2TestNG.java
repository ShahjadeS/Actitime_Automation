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

public class DropDownExampl2TestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        //launchBrowser("Firefox"); --> Not working
        launchBrowser("Chrome");
        driver = super.driver;
    }

    @Test
    public void DropDownExampl2Test() throws Exception {
        new DropDownExampl2TestNG();
        driver.navigate().to("https://www.amazon.in/");
        Thread.sleep(5000);

        //Create an instance / object of Select class
        Select select = new Select(driver.findElement(By.id("searchDropdownBox")));

        //Get all options from dropdown list
        List<WebElement> valueList = select.getOptions();
        System.out.println("Total values in dropdown is: " + valueList.size());

        for (WebElement valueElement : valueList) {
            //Get the text of value
            String value = valueElement.getText();

            if (value.equals("Books")) {
                select.selectByVisibleText(value);
                System.out.println(value);

                List<WebElement> selectedValues = select.getAllSelectedOptions();

                WebElement selectedVal = selectedValues.getFirst();

                String val = selectedVal.getText();

                if (val.equals("Books")) {
                    System.out.println("Books option is clickable");

                    //Enter the text in search area
                    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Avengers");
//
//                  //Click on Search icon
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
                } else {
                    throw new Exception("Books option is not clickable");
                }
                break;
            }
        }
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}