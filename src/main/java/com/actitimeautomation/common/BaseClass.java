package com.actitimeautomation.common;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    public WebDriver driver;
    public ExtentTest extentTest;

    public void launchBrowser(String browserName) {
        //Using If condition
        if (browserName.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equals("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("Edge")) {
            driver = new EdgeDriver();
        }

        //Using switch statement
//        switch (browserName)
//        {
//            case "Chrome":
//                driver = new ChromeDriver();
//                System.out.println("Chrome browser launched.");
//                break;
//            case "Firefox":
//                driver = new FirefoxDriver();
//                System.out.println("Firefox browser launched.");
//                break;
//            case "Edge":
//                driver = new EdgeDriver();
//                System.out.println("Edge browser launched.");
//                break;
//            default:
//                driver = null;
//                System.out.println("Invalid browser name. Please select Chrome, Firefox, or Edge.");
//                break;
//        }
    }

    @BeforeMethod
    public void beforeMethod() {
        extentTest = ExtentReportUtil.objectMap.get("extentTest");
    }
}