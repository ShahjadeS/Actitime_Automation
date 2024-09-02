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

public class GetAllImagesTestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Firefox");
        driver = super.driver;
    }

    @Test
    public void GetAllImagesTest() throws Exception {
        new GetAllImagesTestNG();
        driver.navigate().to("https://amazon.in");
        //Get All Img elements
        List<WebElement> imgList = driver.findElements(By.tagName("img"));
        System.out.println(imgList.size());
        //Iterate through each Img element
        for (WebElement images : imgList) {
            String imagesLists = images.getAttribute("src");
            if (imagesLists != null && !imagesLists.isBlank()) {
//            System.out.println(imagesLists);
                URL imageLinks = new URL(imagesLists);
                //Open the connection
                URLConnection imgConnection = imageLinks.openConnection();
                //Convert URLConnection to HTTPURLConnection --> (Typecast = Downcasting)
                HttpURLConnection httpURLConnection = (HttpURLConnection) imgConnection;
                //Connect to HTTPURLConnection
                httpURLConnection.connect();
                //Get Response Code of that links
                int statusCode = httpURLConnection.getResponseCode();
                //Print broken links
                if (statusCode > 299) {
                    System.out.println(statusCode + " " + imagesLists);
                }
                //Close the connection
                httpURLConnection.disconnect();
            }
        }
        Thread.sleep(5000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}