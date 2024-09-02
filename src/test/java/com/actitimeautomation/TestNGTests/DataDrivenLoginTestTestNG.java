package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import com.actitimeautomation.tests.ExcelHandling3;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataDrivenLoginTestTestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    @Test
    public void DataDrivenLoginTest() throws Exception {
        driver.navigate().to("https://online.actitime.com/actiselenium68/login.do");

        LoginPage loginPage = new LoginPage(driver);

        ExcelHandling3 excelHandling3 = new ExcelHandling3();
        String filePath = "C:\\SHAHJADE SHAIKH\\CS (Selenium)\\Files\\Credentials.xlsx";

        Object[][] excelData = excelHandling3.getExcelData(filePath, "Credentials_Data");

//        for (int i = 0; i <= excelData.length-1; i++)
//        {
//            String username = excelData[i][0].toString();
//            String password = excelData[i][1].toString();
//            loginPage.login(username, password);
//            Thread.sleep(5000);
//        }

        for (int i = 0; i < excelData.length; i++) {
            if (excelData[i][0] != null && excelData[i][1] != null) {
                String username = excelData[i][0].toString();
                String password = excelData[i][1].toString();
                System.out.println("Login Credentials with Username: " + username + " and Password: " + password);
                loginPage.login(username, password);
                Thread.sleep(5000);
            } else {
                System.out.println("Null value encountered at row: " + (i + 1));
            }
        }
    }
    @AfterClass (enabled = false)
    public void closeBrowser()
    {
        driver.close();
    }
}