package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

public class CalenderExample2TestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Firefox");
        driver = super.driver;
    }

    @Test
    public void CalenderExample2Test() throws InterruptedException {
//        Set the current date to first row of Deadline of Task=========================================================
//        1. Get the current day of month from machine --> got it int format
//        2. Launch the browser and navigate to website
//        3. Login to application
//        4. Click on Task module
//        5. Click on first row "Set up deadline" text -> it will open Calendar
//        6. Get all days of month (July) in the List<WebElement>
//        7. Iterate the list of days and check if the calendar day is equals with current day got from the machine
//        8. Then click on that day in calender
//        ==============================================================================================================

        //Get current day from machine / system
//        int currentDay = LocalDateTime.now().getDayOfMonth();
//        System.out.println(currentDay);

        //Get next day from the machine / system
        int nextDay = LocalDateTime.now().plusDays(1).getDayOfMonth();
        System.out.println("Next day is: " + nextDay);

        new CalenderExample2TestNG();
        driver.navigate().to("https://online.actitime.com/actiselenium68/login.do");

        //Login to Actitime application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("csseleniumbatch", "CSSeleniumBatch");

        //Wait for 5 sec
        Thread.sleep(5000);

        //Click on Task module
        driver.findElement(By.xpath("//div[@id='container_tasks']")).click();

        //Wait for 5 sec to load all the Tasks on the page
        Thread.sleep(5000);

        //Click to first row of calendar
        driver.findElement(By.xpath("(//div[text()='Set up deadline'])[1]")).click();

        //Get the all days of month
        List<WebElement> monthDays = driver.findElements(By.xpath("//tbody[@class='rc-calendar-tbody']//td[starts-with(@title,'July')]/div"));

        //Iterate the list
        for (WebElement dayElement : monthDays) {
            //Get the day
            String monthDay = dayElement.getText();

            //Convert "nextDay" into String type / format
            String nextDayOfMonth = String.valueOf(nextDay);
            if (monthDay.equals(nextDayOfMonth)) {
                dayElement.click();
                System.out.println("Next day is successfully set to Deadline...!");
            }
        }
        Thread.sleep(5000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}