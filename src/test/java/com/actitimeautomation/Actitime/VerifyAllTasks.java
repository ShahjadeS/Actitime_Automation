package com.actitimeautomation.Actitime;

import TestNGMain.ActitimeLoginPage;
import TestNGMain.ActitimeTaskPage;
import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class VerifyAllTasks extends BaseClass
{
    WebDriver driver;
    @BeforeClass
    public void setupBrowser()
    {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    @Test
    public void verifyTasks() throws InterruptedException {
        ActitimeLoginPage actitimeLoginPage = new ActitimeLoginPage(driver);
        ActitimeTaskPage actitimeTaskPage = new ActitimeTaskPage(driver);
        actitimeLoginPage.login("csseleniumbatch", "CSSeleniumBatch");
        Thread.sleep(5000);
        actitimeTaskPage.clickOnTaskModule();
        Thread.sleep(5000);
        actitimeTaskPage.verifyAllTasks();
        Thread.sleep(5000);
    }

    @AfterClass
    public void closeBrowser()
    {
        driver.close();
    }
}