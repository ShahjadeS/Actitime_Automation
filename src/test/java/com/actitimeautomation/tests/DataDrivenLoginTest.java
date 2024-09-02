package com.actitimeautomation.tests;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class DataDrivenLoginTest extends BaseClass
{
    static WebDriver driver;
    public DataDrivenLoginTest()
    {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    public static void main(String[] args) throws Exception {
        new DataDrivenLoginTest();
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

        for (int i = 0; i < excelData.length; i++)
        {
            if (excelData[i][0] != null && excelData[i][1] != null) {
                String username = excelData[i][0].toString();
                String password = excelData[i][1].toString();
                System.out.println("Login Credentials with Username: " + username + " and Password: " + password);
                loginPage.login(username, password);
                Thread.sleep(5000);
            }
            else
            {
                System.out.println("Null value encountered at row: " + (i + 1));
            }
        }
//        driver.close();
    }
}