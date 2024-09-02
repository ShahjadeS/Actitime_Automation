package com.actitimeautomation.tests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class GetAllImages extends BaseClass
{
    static WebDriver driver;

    public GetAllImages()
    {
        launchBrowser("Firefox");
        driver = super.driver;
    }

    public static void main(String[] args) throws Exception {
        new GetAllImages();
        driver.navigate().to("https://amazon.in");
        //Get All Img elements
        List<WebElement> imgList = driver.findElements(By.tagName("img"));
        System.out.println(imgList.size());
        //Iterate through each Img element
        for (WebElement images : imgList)
        {
            String imagesLists = images.getAttribute("src");
            if(imagesLists!=null && !imagesLists.isBlank()) {
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
    }
}