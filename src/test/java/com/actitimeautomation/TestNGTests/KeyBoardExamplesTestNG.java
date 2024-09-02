package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyBoardExamplesTestNG extends BaseClass {
    WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        launchBrowser("Chrome");
        driver = super.driver;
    }

    @Test
    public void KeyBoardExamplesTest() throws Exception {
        new KeyBoardExamplesTestNG();
        driver.get("https://online.actitime.com/actiselenium68/login.do");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("uiuwyiurew", "fwfd");

    /*    Actions actions= new Actions(driver);

        actions.keyDown(Keys.ENTER).build().perform();
        actions.keyUp(Keys.ENTER).build().perform();*/


        Robot robot = new Robot();

       /* robot.mouseMove(500,500);

        //mouse left button press
        robot.mousePress(KeyEvent.VK_LEFT);
        robot.mouseRelease(KeyEvent.VK_LEFT);
*/
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(5000);

        //press control+Plus button at a time
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_PLUS);
        robot.keyPress(KeyEvent.VK_PLUS);
        robot.keyRelease(KeyEvent.VK_PLUS);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(5000);

        robot.mouseWheel(600);
        robot.mouseWheel(-600);
    }

    @AfterClass(enabled = false)
    public void closeBrowser() {
        driver.close();
    }
}