package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.CommonUtil;
import com.actitimeautomation.common.PropertyHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class FileUploadTest extends BaseClass {
    WebDriver driver;
    CommonUtil commonUtil;

    @BeforeClass
    public void setup(ITestContext context) throws IOException {
        PropertyHandling propertyHandling = new PropertyHandling();
        String browser = propertyHandling.getProperty("browser");
        launchBrowser(browser);
        driver = super.driver;
        String fileUploadURL = propertyHandling.getProperty("fileUploadURL");
        driver.navigate().to(fileUploadURL);
        commonUtil = new CommonUtil(driver);
    }

    @Test
    public void verifyFileUpload() throws InterruptedException, IOException {
        commonUtil.waitForElementClickable2(By.xpath("//span[text()='Add Files']"));
        driver.findElement(By.xpath("//span[text()='Add Files']")).click();
        Thread.sleep(5000);
        //Without Command Line
//        Runtime.getRuntime().exec("C:\\SHAHJADE SHAIKH\\CS (Selenium)\\AutoIT\\FileUpload1.exe");
        //With Command Line
        Runtime.getRuntime().exec("C:\\SHAHJADE SHAIKH\\CS (Selenium)\\AutoIT\\FileUploadCmdLine1.exe C:\\Users\\lenovo\\Desktop\\Demo.png");
        System.out.println("File Upload Successfully...!");
    }

    @AfterClass(enabled = true)
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}