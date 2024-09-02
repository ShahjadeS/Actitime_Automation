package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.pages.AddCustomer;
import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import com.actitimeautomation.pages.TaskPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TaskTestTestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    @Test
    public void TaskTestTest(String[] args) throws InterruptedException {
        new TaskTestTestNG();
        LoginPage loginPage = new LoginPage(driver);
        TaskPage taskPage = new TaskPage(driver);
        AddCustomer addCustomer = new AddCustomer(driver);

        driver.manage().window().maximize();

        loginPage.login("csseleniumbatch", "CSSeleniumBatch");
        Thread.sleep(5000);
        addCustomer.clickOnTaskModule();
        Thread.sleep(2000);

        //Locate select all check box and verify it is displayed
        boolean selectAllCheckBox = driver.findElement(By.xpath("(//div[@class='img'])[1]")).isDisplayed();
        if (selectAllCheckBox) {
            driver.findElement(By.xpath("(//div[@class='img'])[1]")).click();
            Thread.sleep(2000);
            boolean selectedCheckBox = driver.findElement(By.xpath("(//div[@class='img'])[1]")).isSelected();
            if (selectedCheckBox) {
                System.out.println("All Checkboxes are selected...!");
            } else {
                System.out.println("Unable to select all Checkboxes...!");
            }
        } else {
            System.out.println("The select all check box is not displayed");
        }
    }

    @AfterClass(enabled = false)
    public void closeBrowser() {
        driver.close();
    }
}