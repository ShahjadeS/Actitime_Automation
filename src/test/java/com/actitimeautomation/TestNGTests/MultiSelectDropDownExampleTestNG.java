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

public class MultiSelectDropDownExampleTestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    @Test
    public void MultiSelectDropDownExampleTest(String[] args) throws InterruptedException {
        new MultiSelectDropDownExampleTestNG();
        driver.get("C:\\SHAHJADE SHAIKH\\CS (Selenium)\\HTML Files\\MultipleValuesDropDown.html");
        Thread.sleep(2000);
        Select multiSelect = new Select(driver.findElement(By.id("fruits")));

        Thread.sleep(2000);
        //Select multiple values from the multiselected dropdown list --> Multiselect by Text --> selectByVisibleText()
        multiSelect.selectByVisibleText("Apple");
        multiSelect.selectByVisibleText("Cherry");
//        Actions actions = new Actions(driver);
//        actions.scrollToElement(driver.findElement(By.xpath("//option[text()='Grape']")));
        multiSelect.selectByVisibleText("Grape");

        //Check / Verify the status of multiselected dropdown list is selected multiple options or not
        boolean multiSelectStatus = multiSelect.isMultiple();
        System.out.println(multiSelectStatus);

//        Thread.sleep(2000);
        //Select multiple values from the multiselected dropdown list --> Multiselect by Value --> electByValue
//        multiSelect.selectByValue("apple");
//        multiSelect.selectByValue("cherry");
//        multiSelect.selectByValue("grape");

//        Thread.sleep(2000);
        //Select multiple values from the multiselected dropdown list --> Multiselect by Index --> selectByIndex()
//        multiSelect.selectByIndex(0);
//        multiSelect.selectByIndex(2);
//        multiSelect.selectByIndex(4);

        //Get the first selected option
        WebElement firstSelectedValue = multiSelect.getFirstSelectedOption();
        System.out.println("This is the first selected value: " + firstSelectedValue.getText());

        Thread.sleep(2000);
        //Get all selected options from the multiselected dropdown list --> getAllSelectedOptions()
        List<WebElement> allSelectedValues1 = multiSelect.getAllSelectedOptions();
        System.out.println("Total selected options size are: " + allSelectedValues1.size());
        for (WebElement selectedValues1 : allSelectedValues1) {
            String selectedOptions1 = selectedValues1.getText();
            System.out.println(selectedOptions1);
        }

        Thread.sleep(2000);
        //Deselect selected options
        multiSelect.deselectAll();

        Thread.sleep(2000);
        //Check / Verify after deselect the options from the multiselected dropdown list
        List<WebElement> allSelectedValues2 = multiSelect.getAllSelectedOptions();
        System.out.println("After deselected the options size are: " + allSelectedValues2.size());

        Thread.sleep(2000);
        //Again select multiple values from the multiselected dropdown list
        multiSelect.selectByVisibleText("Apple");
        multiSelect.selectByIndex(2);

        Thread.sleep(2000);
        //Get the selected size after the deselection of one value
        List<WebElement> allSelectedValues3 = multiSelect.getAllSelectedOptions();
        System.out.println("After deselect and then again selected options size are: " + allSelectedValues3.size());
        for (WebElement selectedValues2 : allSelectedValues3) {
            String selectedOptions2 = selectedValues2.getText();
            System.out.println(selectedOptions2);
        }
        Thread.sleep(2000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}