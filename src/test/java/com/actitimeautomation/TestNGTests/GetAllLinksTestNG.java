package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class GetAllLinksTestNG extends BaseClass {
    //==================================================================================================================
    //1. Launch Browser
    //2. Navigate to amazon.in website
    //3. Get all links available on page
    //4. Print them one by one
    //5. Ignore Null & Javascript:void(0) which is not a links
    //6. Converting String into Actual URL
    //7. Then we are converting (downcasting) that URL into HttpURLConnection
    //8. Then fetch that broken link by implementing condition (statusCode>299)
    //9. Close the connection of HttpURLConnection
    //==================================================================================================================
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Firefox");
        driver = super.driver;
    }

    @Test
    //throws MalformedURLException
    public void GetAllLinksTest() throws Exception {
        new GetAllLinksTestNG();
        driver.navigate().to("https://amazon.in");

        List<WebElement> tagElements = driver.findElements(By.tagName("a"));
        System.out.println(tagElements.size());

        for (WebElement allElements : tagElements) {
            String allHyperlinks = allElements.getAttribute("href");
            if (allHyperlinks != null && !allHyperlinks.startsWith("javascript")) {
                //Convert String URL into actual URL
                URL allLinks = new URL(allHyperlinks);
                //Open the connection
                URLConnection connection = allLinks.openConnection();
                //Convert URLConnection to HTTPURLConnection --> (Typecast = Downcasting)
                HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
                //Connect to HTTPURLConnection
                httpURLConnection.connect();
                //Get Response Code of that links
                int statusCode = httpURLConnection.getResponseCode();
                //Print broken links
                if (statusCode > 299) {
                    System.out.println(statusCode + " " + allHyperlinks);
                }
                //Close the connection
                httpURLConnection.disconnect();
            }
        }
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}