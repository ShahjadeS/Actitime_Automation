package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllLabelsTestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Firefox");
        driver = super.driver;
    }

    @Test
    public void GetAllLabelsTest() {
        driver.navigate().to("https://amazon.in");
        //Get All Label elements
        List<WebElement> inputList = driver.findElements(By.tagName("input"));
        System.out.println(inputList.size());
        //Iterate through each label/input element
        for (WebElement inputElement : inputList) {
            String inputElementValue = inputElement.getAttribute("placeholder");
            if (inputElementValue != null && !inputElementValue.isBlank()) {
                System.out.println(inputElementValue);
            }
        }
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
