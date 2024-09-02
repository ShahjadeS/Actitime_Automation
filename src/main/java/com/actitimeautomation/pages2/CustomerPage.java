package com.actitimeautomation.pages2;

import com.actitimeautomation.common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CustomerPage {
    WebDriver driver;
    CommonUtil commonUtil;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
    }
    //Common locators for create new customer

    //1. Task Module
    public By taskModule = By.id("container_tasks");

    //2. Add New Button
    public By addNewButton = By.xpath("//div[@class='addNewButton']");

    //3. To choose Create New Customer option
    public By createNewCustomer = By.xpath("//div[contains(@class,'createNewCustomer')]");

    //4. Enter the Customer Name
    public By enterCustomerName = By.xpath("//div[@class='customerNameDiv']/descendant::input");

    //5. Create Customer Button
    public By createCustomerButton = By.xpath("//div[@id='customerLightBox']//div[@class='commitButtonPlaceHolder']");

    //6. List of All Created Customer
    public By listOfAllCustomer = By.xpath("//div[@id='customerLightBox']//div[@class='searchItemList']//div[contains(@class,'cpItemRow')]");

    //7. Search Customer By Name
    public By searchCustomer = By.xpath("//div[@class='searchAndExportContainer']//input[contains(@placeholder,'Start')]");

    //8. Searched Customer
    // public By searchedCustomer = By.xpath("//div[@class='itemsContainer']/descendant::span");
    public By searchedCustomer = By.xpath("//div[@class='filteredContainer']//div[@class='itemsContainer']//div[@class='text']");

    public void clickOnTaskModule() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(taskModule).click();
    }
    public void createCustomer(String customerName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        commonUtil.fluientWait(addNewButton);
        driver.findElement(addNewButton).click();
        driver.findElement(createNewCustomer).click();
        driver.findElement(enterCustomerName).sendKeys(customerName);
        driver.findElement(createCustomerButton).click();
    }

    public String verifyCustomer(String customerName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        List<WebElement> listOfCustomer = driver.findElements(listOfAllCustomer);
//        for (WebElement customerList : listOfCustomer) {
//            if(customerList.getText().equals(customerName))
//            {
//                String custName = customerList.getText();
//                System.out.println(custName+ " is matched, Test Case Passed...!");
//            }
//            else
//            {
//                System.out.println("Test Case Failed...!");
//            }
        driver.findElement(searchCustomer).sendKeys(customerName);
        String customerFound = driver.findElement(searchedCustomer).getText();
//        if (customerFound.equalsIgnoreCase(customerName)) {
//            System.out.println("Test Case Passed...!");
//        } else {
//            System.out.println("Test Case Failed...!");
//        }
        return customerFound;
    }
}