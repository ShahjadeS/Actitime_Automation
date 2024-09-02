package com.actitimeautomation.tests;

import com.actitimeautomation.TestNGTests.TestDataProvider;
import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample extends BaseClass
{
    WebDriver driver;

    @BeforeClass(enabled = false)
    public void setupBrowser()
    {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    @DataProvider
    public Object[][] getTestData()
    {
        Object[][] objects = new Object[][]
                {
                        {"Username1", "Password1"},
                        {"Username2", "Password2"}
                };
        return objects;
    }

    @DataProvider
    public Object[][] getTestDataFromExcel() throws Exception {
        ExcelHandling3 excelHandling3 = new ExcelHandling3();
        String filePath = "C:\\SHAHJADE SHAIKH\\CS (Selenium)\\Files\\Credentials.xlsx";
        Object[][] excelData = excelHandling3.getExcelData(filePath, "Credentials_Data");
        return excelData;
    }

    //    @Test(dataProvider = "getTestData")
    @Test(dataProvider = "getTestDataFromExcel")
    public void verifyLogin(Object username, Object password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username.toString(), password.toString());
        Thread.sleep(5000);
    }

    @Test(dataProvider = "getSampleData", dataProviderClass = TestDataProvider.class)
    public void test(Object param1, Object param2, String param3)
    {
        System.out.println(param1+"     "+param2+"      "+param3);
    }
}
