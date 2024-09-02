package com.actitimeautomation.OrgHRM;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRMLoginTest extends BaseClass {
    WebDriver driver;
    CommonUtil commonUtil;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Chrome");
        driver = super.driver;
        commonUtil = new CommonUtil(driver);
    }

    @Test
    public void verifyLogin() throws Exception {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String title = driver.getTitle();
        System.out.println("Webpage Title is: " + title);

//        //wait for username element is visible =====> //visibilityOf()
//        commonUtil.waitForElementVisible(driver.findElement(By.name("username")));

        //wait for username element is present =====> //PresenceOfElementLocated =====> By Locator
//        commonUtil.waitForElementToPresent(By.name("username"));

        //Fluent Wait
        commonUtil.fluientWait(By.name("username"));

        //Enter username
        driver.findElement(By.name("username")).sendKeys("Admin");

        //Enter password
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Click on Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        boolean enableLoginButton = loginButton.isEnabled();

        System.out.println("The Login Button is Enabled...! " + enableLoginButton);

        if (enableLoginButton) {
//            loginButton.click();
            loginButton.submit();
        } else {
            throw new Exception("Login Button is not Enabled...!");
        }
    }

    @AfterClass
    public void closeBrowser() {
//        driver.quit();
        driver.close();
    }
}