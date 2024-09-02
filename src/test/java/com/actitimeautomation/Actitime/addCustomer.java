package com.actitimeautomation.Actitime;

import TestNGMain.ActitimeLoginPage;
import TestNGMain.ActitimeTaskPage;
import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import com.actitimeautomation.pages.TaskPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class addCustomer extends BaseClass {
    WebDriver driver;
    ActitimeLoginPage actitimeLoginPage;
    ActitimeTaskPage actitimeTaskPage;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Chrome");
        driver = super.driver;
        actitimeLoginPage = new ActitimeLoginPage(driver);
        actitimeTaskPage = new ActitimeTaskPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void createNewActitimeCustomer() throws Exception {
        actitimeLoginPage.login("csseleniumbatch", "CSSeleniumBatch");
        actitimeTaskPage.clickOnTaskModule();
        actitimeTaskPage.verifyTaskPage();
//        actitimeTaskPage.verifyAlreadyCustomerExist("XYZ Works");
        actitimeTaskPage.createNewCustomer("ABC Works", "Dharavi, Mumbai");
        actitimeTaskPage.verifyCustomerAfterCreation("ABC Works");
    }

    @AfterClass(enabled = false)
    public void closeBrowser() {
        driver.close();
    }
}