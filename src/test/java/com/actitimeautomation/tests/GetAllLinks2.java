package com.actitimeautomation.tests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetAllLinks2 extends BaseClass
{
    //==================================================================================================================
    //1. Launch Browser
    //2. Navigate to amazon.in website
    //3. Get all links available on page
    //4. Print them one by one
    //==================================================================================================================
    static WebDriver driver;
    public GetAllLinks2()
    {
        launchBrowser("Firefox");
        driver = super.driver;
    }

    public static void main(String[] args)
    {
        new GetAllLinks2();
        try
        {
            // Open the desired website
            driver.get("https://amazon.in");

            // Find all anchor elements on the page
            List<WebElement> anchorElements = driver.findElements(By.tagName("a"));

            // Loop through each anchor element and print the href attribute
            for (WebElement anchor : anchorElements)
            {
                String href = anchor.getAttribute("href");
                if (href != null && !href.isEmpty() && !href.equals("javascript: void(0)") && !href.equals("javascript:void(0)"))
                {
                    System.out.println(href);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            // Close the browser
            driver.quit();
        }
    }
}