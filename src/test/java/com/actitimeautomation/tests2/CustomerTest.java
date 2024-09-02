package com.actitimeautomation.tests2;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.CommonUtil;
import com.actitimeautomation.common.PropertyHandling;
import com.actitimeautomation.pages2.CustomerPage;
import com.actitimeautomation.pages2.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CustomerTest extends BaseClass {
    WebDriver driver;
    PropertyHandling propertyHandling;
    CustomerPage customerPage;
    CommonUtil commonUtil;

    @BeforeClass
    public void setup() throws IOException {
        propertyHandling = new PropertyHandling();
        String browserName = propertyHandling.getProperty("browser");
        launchBrowser(browserName);
        driver = super.driver;
        driver.navigate().to(propertyHandling.getProperty("actitimeURL"));
        LoginPage loginPage = new LoginPage(driver);
        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");
        loginPage.login(username, password);
        customerPage = new CustomerPage(driver);
    }

    @BeforeMethod
    public void clickONTaskModule() {
        customerPage.clickOnTaskModule();
    }

    @Test
    public void verifyCreateCustomer() throws Exception {
//        driver.findElement(customerPage.taskModule).click();
//        commonUtil.fluientWait(customerPage.addNewButton);
//        driver.findElement(customerPage.addNewButton).click();
//        driver.findElement(customerPage.createNewCustomer).click();
//        driver.findElement(customerPage.enterCustomerName).sendKeys(customerName);
//        driver.findElement(customerPage.createCustomerButton).click();
        try {
            customerPage.createCustomer("RRR");
//        customerPage.verifyCustomer("Nitish");

            String expectedCustomerName = "RRR";
//        // Create a new customer
//        customerPage.createCustomer(expectedCustomerName);
//        // Verify if the customer exists
            String actualCustomerName = customerPage.verifyCustomer("RRR");
//        // Use Hard Assert to validate the customer creation
            Assert.assertEquals(actualCustomerName, expectedCustomerName, "Customer was not created successfully");
        } catch (Exception exception) {
            throw new Exception("Customer already exist...!");
        }
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}