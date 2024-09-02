package com.actitimeautomation.tests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class windowsOperations extends BaseClass
{
        //==============================================================================================================
        //1. Launch browser
        //2. Navigate to actitime website
        //3. Open new tab
        //4. Navigate to redus.in website
        //5. Print title of page
        //6. Close the redbus tab
        //7. Switch control to actitime tab
        //8. Print the title
        //9. Close the browser
        //==============================================================================================================
    static WebDriver driver;
    public windowsOperations()
    {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    public static void main(String[] args)
    {
        new windowsOperations();

        driver.navigate().to("https://online.actitime.com/actiselenium68/login.do");

        driver.findElement(By.linkText("actiTIME Inc.")).click();

        //Get Parent Window / Tab
        String parentWindowId = driver.getWindowHandle();
        System.out.println("Parent Window ID: "+parentWindowId);

        //Get all Window / Tab
        Set<String> allWindowIDs = driver.getWindowHandles();
        System.out.println("All Window IDs "+allWindowIDs);

        //Iterate through all IDs
        for (String Ids : allWindowIDs)
        {
            //Check if ID is not equals to ParentID
            if(!Ids.equals(parentWindowId))
            {
                System.out.println("2nd Tab ID "+Ids);

                //Switch to 2nd Tab
                driver.switchTo().window(Ids);

                //Print the Title of Child Tab
                String childWindowTitle = driver.getTitle();
                System.out.println("Child Window Title is: "+childWindowTitle);

                //Close 2nd Tab
                driver.close();
                break;
            }
        }
        //Switch control back to parent tab
        driver.switchTo().window(parentWindowId);
//        driver.switchTo().defaultContent();

        //Print the title of Parent Tab
        String parentWindowTitle = driver.getTitle();
        System.out.println("Parent Window Titile is: "+parentWindowTitle);

        //Close the 1st / Main / Parent Tab
        driver.close();
//        driver.quit();
    }
}