package com.actitimeautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage
{
    WebDriver driver;
    public LogoutPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public void logout()
    {
        WebElement logoutbutton1 = driver.findElement(By.xpath(("(//a[@id='logoutLink'])[1]")));
        logoutbutton1.click();
    }
}
