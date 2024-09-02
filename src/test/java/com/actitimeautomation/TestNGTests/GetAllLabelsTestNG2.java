package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllLabelsTestNG2 extends BaseClass {
    WebDriver driver;
    CommonUtil commonUtil;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Chrome");
        driver = super.driver;
        driver.navigate().to("https://amazon.in");
        commonUtil = new CommonUtil(driver);
    }

    @Test
    public void verifyAllLables() {

//        //wait for all elements visible =====> //visibilityOfAllElements =====> By Locator
//        commonUtil.waitForAllElementsVisible2(By.tagName("input"));

        //wait for all elements visible =====> //visibilityOfAllElements =====> List<WebElement>
        commonUtil.waitForAllElementsVisible3(driver.findElements(By.tagName("input")));

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