package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import com.actitimeautomation.tests.ExcelHandling4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GetAndInsertAllCustomersInExcelTestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    @Test
    public void GetAndInsertAllCustomersInExcelTest() throws Exception {
        new GetAndInsertAllCustomersInExcelTestNG();
        driver.navigate().to("https://online.actitime.com/actiselenium68/login.do");

        //Login to ActiTime application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("csseleniumbatch", "CSSeleniumBatch");

        Thread.sleep(5000);

//        //Typecast / Downcast "driver" variable into JavaScriptExcecutor
//        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Click on Task module
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();

        Thread.sleep(5000);

        //Get the control of all the customers collapse button and click it
        List<WebElement> allCollapseButton = driver.findElements(By.xpath("//div[contains(@class,'customerNode ')]//div[@class='collapseButton']"));
        for (WebElement collapseButton : allCollapseButton) {
            collapseButton.click();
        }

        //Get all customers names from the ActiTime application
        List<WebElement> allCustomersList = driver.findElements(By.xpath("//div[contains(@class,'customerNode')]//div[@class='text']"));
        System.out.println(allCustomersList.size());

//        //To scroll down the web page by the visibility of the element
//        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[contains(@class,'customerNode ')]//div[text()='Our company']")));

        //Create a 2-Dimentional Array
        Object[][] customerData = new Object[allCustomersList.size()][1];

        for (int i = 0; i <= allCustomersList.size() - 1; i++) {
            String customerName = allCustomersList.get(i).getText();
            customerData[i][0] = customerName;
        }
        ExcelHandling4 excelHandling4 = new ExcelHandling4();
        String filepath = "C:\\SHAHJADE SHAIKH\\CS (Selenium)\\Files\\Credentials.xlsx";
        String sheetName = "CustomersData";
        excelHandling4.writeExcelData(filepath, sheetName, customerData);
        Thread.sleep(5000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}