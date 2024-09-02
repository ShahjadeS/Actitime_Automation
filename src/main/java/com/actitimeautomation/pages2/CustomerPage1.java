package com.actitimeautomation.pages2;

import com.actitimeautomation.common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class CustomerPage1 {
    WebDriver driver;
    CommonUtil commonUtil;

    public CustomerPage1(WebDriver driver) {
        this.driver = driver;
    }

    // Common locators for creating a new customer
    public By taskModule = By.id("container_tasks");
    public By addNewButton = By.xpath("//div[@class='addNewButton']");
    public By createNewCustomer = By.xpath("//div[contains(@class,'createNewCustomer')]");
    public By enterCustomerName = By.xpath("//div[@class='customerNameDiv']/descendant::input");
    public By createCustomerButton = By.xpath("//div[@id='customerLightBox']//div[@class='commitButtonPlaceHolder']");
    public By searchCustomer = By.xpath("//div[@class='searchAndExportContainer']//input[contains(@placeholder,'Start')]");
    public By searchedCustomer = By.xpath("//div[@class='filteredContainer']//div[@class='itemsContainer']//div[@class='text']");

    public void clickOnTaskModule() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(taskModule).click();
    }

    public boolean isCustomerPresent(String customerName) {
        driver.findElement(searchCustomer).sendKeys(customerName);
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            //If matched then returns "true"
            return driver.findElement(searchedCustomer).getText().equals(customerName);
        } catch (Exception e) {
            return false;
        } finally {
            // Resetting to default
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public void createCustomer(String customerName) {
        driver.findElement(addNewButton).click();
        driver.findElement(createNewCustomer).click();
        driver.findElement(enterCustomerName).sendKeys(customerName);
        driver.findElement(createCustomerButton).click();
    }
}