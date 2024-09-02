package com.actitimeautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomer
{
    WebDriver driver;
    public AddCustomer(WebDriver driver)
    {
        this.driver = driver;
    }

    //Click on Task Module
    public void clickOnTaskModule()
    {
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
    }

    //Click on "Add New" Button
    public void addNewButton()
    {
        driver.findElement(By.xpath("//div[text()='Add New']")).click();
    }

    //Click on "New Customer"
    public void clickOnNewCustomer()
    {
        driver.findElement(By.xpath("//div[contains(@class,'createNewCustomer')]")).click();
    }

    //Enter Customer Name
    public void enterCustomerName(String customerName)
    {
        driver.findElement(By.xpath("//div[@class='customerNameDiv']/input")).sendKeys(customerName);
    }

    //Enter Customer Description
    public void enterCustomerDescription(String customerDescription)
    {
        driver.findElement(By.xpath("//div[@class='inputContainer']//textarea[@placeholder='Enter Customer Description']")).sendKeys(customerDescription);
    }

    //Click on Create Customer Button
    public void clickOnCreateCustomerButton()
    {
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
    }
}