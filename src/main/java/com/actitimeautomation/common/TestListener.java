package com.actitimeautomation.common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import java.io.File;
import java.io.IOException;

public class TestListener implements ISuiteListener, ITestListener {

    ExtentReports extentReports;
    ExtentTest extentTest;
    ExtentReportUtil extentReportUtil;
    public void onStart(ISuite suite) {
//        System.out.println("This is onStart method of ISuiteListener");
        //Get the path of the 'report' folder
        String reportFolderPath = System.getProperty("user.dir") + "/report";
        //Convert 'reportFolderPath' into 'File'
        File file = new File(reportFolderPath);
        //Check the file/folder is present OR not
        if (!file.exists()) {
            //If the given path is doesn't present the create a file/folder accordingly
            file.mkdir();
            System.out.println("report folder is created successfully...!");
        }
        //Create a HTML File
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFolderPath + "/AutomationReport.html");
        //To save the file, we have to create an instance of "ExtentReports" class
        extentReportUtil = new ExtentReportUtil();
        extentReports = extentReportUtil.extentReports;
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("User", "Shahjade Shaikh");
        extentReports.setSystemInfo("Operating System", "Windows 10");
        extentReports.setSystemInfo("Browser", "Google Chrome");
    }

    public void onFinish(ISuite suite) {
//        System.out.println("This is onFinish method of ISuiteListener");
        extentReports.flush();
    }

    public void onStart(ITestContext context) {
        System.out.println("This is onStart method of ITestListener");
    }

    public void onFinish(ITestContext context) {
        System.out.println("This is onFinish method of ITestListener");
    }

    public void onTestStart(ITestResult result) {
//        System.out.println("This is onTestStart method of ITestListener");
        System.out.println("Test: " + result.getMethod().getMethodName() + " started executing...!");

        //Create a sectionfor each test through ExtentReport reference
        extentTest = extentReportUtil.createTest(result.getMethod().getMethodName());
        ExtentReportUtil.objectMap.put("extentTest", extentTest);
    }

    public void onTestSuccess(ITestResult result) {
//        System.out.println("This is onTestSuccess method of ITestListener");
        System.out.println("Test: " + result.getMethod().getMethodName() + " executed successfully...!");
        extentTest.pass("Test: " + result.getMethod().getMethodName() + " passed successfully...!");
    }

    public void onTestFailure(ITestResult result) {
//        System.out.println("This is onTestFailure method of ITestListener");
        System.out.println("Test: " + result.getMethod().getMethodName() + " failed due to below reason...!");
        //To print/know the whats are errors are occured
        System.out.println(result.getThrowable().getMessage());
        //Get the driver context and convert/typecast into WenDriver
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        //Create an object on CommonUtil class for TakesScreenshot use
        CommonUtil commonUtil = new CommonUtil(driver);
        //Take Screenshot
        try {
            commonUtil.takesScreenshot("CreateProject");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.fail(result.getThrowable().getMessage());
    }

    public void onTestSkipped(ITestResult result) {
//        System.out.println("This is onTestSkipped method of ITestListener");
        System.out.println("Test: " + result.getMethod().getMethodName() + " got skipped...!");
        extentTest.skip("Test: " + result.getMethod().getMethodName() + " is skipped...!");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("This is onTestFailedButWithinSuccessPercentage method of ITestListener");
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }
}