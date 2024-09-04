package com.actitimeautomation.tests2;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.PropertyHandling;
import com.actitimeautomation.pages2.CustomerPage1;
import com.actitimeautomation.pages2.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class CustomerTest1 extends BaseClass {
    WebDriver driver;
    PropertyHandling propertyHandling;
    CustomerPage1 customerPage1;

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
        customerPage1 = new CustomerPage1(driver);
    }

    @BeforeMethod
    public void clickONTaskModule() {
        customerPage1.clickOnTaskModule();
    }

    @Test
    public void verifyCreateCustomer() {
        String customerName = "Srimant Dagdusheth Halwai Ganpati1";

        if (customerPage1.isCustomerPresent(customerName)) {
            Assert.fail("Customer name already exists: " + customerName);
        } else {
            customerPage1.createCustomer(customerName);
            Assert.assertTrue(customerPage1.isCustomerPresent(customerName), "Customer was not created successfully.");
        }
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}