package com.actitimeautomation.tests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetAllLabels extends BaseClass
{
    static WebDriver driver;
    public GetAllLabels()
    {
        launchBrowser("Firefox");
        driver = super.driver;
    }
    public static void main(String[] args)
    {
        new GetAllLabels();
        driver.navigate().to("https://amazon.in");
        //Get All Label elements
        List<WebElement> inputList = driver.findElements(By.tagName("input"));
        System.out.println(inputList.size());
        //Iterate through each label/input element
        for (WebElement inputElement : inputList)
        {
            String inputElementValue = inputElement.getAttribute("placeholder");
            if(inputElementValue!=null && !inputElementValue.isBlank())
            {
                System.out.println(inputElementValue);
            }
        }
        driver.close();
    }
}
