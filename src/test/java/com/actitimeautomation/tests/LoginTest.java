package com.actitimeautomation.tests;

import com.actitimeautomation.pages.LoginPage;
import com.actitimeautomation.pages.LogoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest
{
    public static void main(String[] args) throws InterruptedException {
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