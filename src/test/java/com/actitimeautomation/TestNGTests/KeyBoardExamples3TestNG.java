package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class KeyBoardExamples3TestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    @Test
    public void KeyBoardExamples3Test() throws Exception {
        new KeyBoardExamples3TestNG();
//        driver.get("https://online.actitime.com/selenium68/login.do");
        driver.navigate().to("https://amazon.in");
        driver.manage().window().maximize();

        //Wait for 5 sec
        Thread.sleep(5000);

        //Robot class ===================================================

        //=================================================================
        Robot robot = new Robot();

        //Mouse left button press --> (Press Login button using mouse)
//        driver.findElement(By.id("username")).sendKeys("shahjadeselenium68");
//        driver.findElement(By.name("pwd")).sendKeys("Masoom@1937");
//        WebElement loginButton1 = driver.findElement(By.xpath("//div[starts-with(text(),'Login')]"));

        //Get the location / co-ordinates of the Login button
//        Point point = loginButton1.getLocation();
//        System.out.println(point);

//        robot.mouseMove(552, 458);
//        robot.mousePress(KeyEvent.VK_LEFT);
//        robot.mouseRelease(KeyEvent.VK_LEFT);

//        robot.mouseMove(point.getX(), point.getY());
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        //Key press for Login button (Enter Key)
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

        //Wait for 5 sec
//        Thread.sleep(5000);

        //Zoom the page use Control + Plus key at a time
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_PLUS);
//        robot.keyRelease(KeyEvent.VK_PLUS);
//        robot.keyPress(KeyEvent.VK_PLUS);
//        robot.keyRelease(KeyEvent.VK_PLUS);
//        robot.keyRelease(KeyEvent.VK_CONTROL);

        //Up & Down scroll using MouseWheel
        robot.mouseWheel(1000);
        robot.mouseWheel(-500);

        //Wait for 3 sec
        Thread.sleep(3000);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}