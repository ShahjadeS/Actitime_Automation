package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.pages.LoginPage;
import com.actitimeautomation.pages.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ActitimeLoginTestTestNG
{
    @Test
    public void LoginTestTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("csseleniumbatch", "CSSeleniumBatch");
        System.out.println("User Login Successfully...!");

        Thread.sleep(10000);
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();
        System.out.println("User Logout Successfully...!");

        Thread.sleep(5000);
        driver.close();
        System.out.println("Browser Closed...!");
    }
}