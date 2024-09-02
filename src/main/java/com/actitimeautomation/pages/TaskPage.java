package com.actitimeautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TaskPage
{
    WebDriver driver;
    public TaskPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Get Actual Customer Element
    public String getActualCustomer(String expectedCustomerName)
    {
        String existingCustomerName="";
        List<WebElement> customersList = driver.findElements(By.xpath("//div[contains(@class,'allCustomersNode')]/following-sibling::*"));
        for(WebElement customer : customersList)
        {
            if(customer.getText().equals(expectedCustomerName))
            {
                existingCustomerName = customer.getText();
            }
        }
        return existingCustomerName;
    }

    public WebElement getActualCustomerElement()
    {
        WebElement customerElement = driver.findElement(By.xpath("//div[text()='Selenium' and @class='text']"));
        return customerElement;
    }

    public void clickOnCustomer()
    {
        driver.findElement(By.xpath("//div[text()='Selenium' and @class='text']")).click();
    }
}