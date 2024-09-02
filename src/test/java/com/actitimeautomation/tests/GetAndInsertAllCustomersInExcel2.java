package com.actitimeautomation.tests;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAndInsertAllCustomersInExcel2 extends BaseClass {
    static WebDriver driver;

    public GetAndInsertAllCustomersInExcel2() {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    public static void main(String[] args) throws Exception {
        new GetAndInsertAllCustomersInExcel2();
        driver.navigate().to("https://online.actitime.com/actiselenium68/login.do");

        // Login to ActiTime application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("csseleniumbatch", "CSSeleniumBatch");

        Thread.sleep(5000);

        // Click on Task module
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
        Thread.sleep(5000);

        // Extract customer names and their corresponding projects
        Map<String, List<String>> customerProjectMap = new HashMap<>();

        List<WebElement> customerElements = driver.findElements(By.xpath("//div[contains(@class,'customerNode')]//div[@class='text']"));
        for (WebElement customerElement : customerElements) {
            String customerName = customerElement.getText();
            List<WebElement> projectElements = customerElement.findElements(By.xpath("//div[contains(@class,'projectNode ')]//div[@class='text']"));

            List<String> projects = new ArrayList<>();
            for (WebElement projectElement : projectElements) {
                projects.add(projectElement.getText());
            }

            customerProjectMap.put(customerName, projects);
        }

        // Prepare data for writing to Excel
        List<Object[]> data = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : customerProjectMap.entrySet()) {
            String customerName = entry.getKey();
            for (String projectName : entry.getValue()) {
                data.add(new Object[] { customerName, projectName });
            }
        }

        // Convert List<Object[]> to Object[][]
        Object[][] excelData = data.toArray(new Object[0][0]);

        // Write data to Excel
        ExcelHandling5 excelHandling5 = new ExcelHandling5();
        String filepath = "C:\\SHAHJADE SHAIKH\\CS (Selenium)\\Files\\Credentials.xlsx";
        String sheetName = "CustomersProjects";
        excelHandling5.writeExcelData(filepath, sheetName, excelData);
    }
}