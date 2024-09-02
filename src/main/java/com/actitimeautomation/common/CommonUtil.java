package com.actitimeautomation.common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class CommonUtil {
    WebDriver driver;

    public CommonUtil(WebDriver driver) {
        this.driver = driver;
    }

    //visibilityOf()
    public void waitForElementVisible(WebElement webElement) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    //visibilityOfAllElements =====> WebElement
    public void waitForAllElementsVisible1(WebElement webElement) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
    }

    //visibilityOfAllElements =====> By Locator
    public void waitForAllElementsVisible2(By locator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(locator)));
    }

    //visibilityOfAllElements =====> List<WebElement>
    public void waitForAllElementsVisible3(List<WebElement> webElements) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    //visibilityOfAllElementsLocatedBy =====> By Locator
    public void waitForAllElementsVisibleLocated(By locator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    //PresenceOfElementLocated =====> By Locator
    public void waitForElementToPresent(By locator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //elementToBeClickable =====> WebElement
    public void waitForElementClickable1(WebElement webElement) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    //elementToBeClickable =====> By Locator
    public void waitForElementClickable2(By locator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    //Fluient Wait
    public void fluientWait(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(Exception.class);

        //Based on Anonymous Class logic here
        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                System.out.println("Wait for 2 sec until element is available...!");
                return driver.findElement(locator);
            }
        };
        wait.until(function);
    }

    //TakesScreenshot Logic here
    public void takesScreenshot(String fileName) throws IOException {
        //Typecasting 'driver' into 'TakesScreenshot'
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        //Source of the file (The file is without any name and extension)
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //Save the screenshot at this path OR location
        String filePath = System.getProperty("user.dir") + "/report" + fileName + ".png";
        //Convert 'filePath' into 'File'
        File destination = new File(filePath);
        //Copy file from source to destination
        FileUtils.copyFile(source, destination);
    }
}