package com.actitimeautomation.tests2;

import com.actitimeautomation.common.BaseClass;
import com.actitimeautomation.common.CommonUtil;
import com.actitimeautomation.common.PropertyHandling;
import com.actitimeautomation.common.TestListener;
import com.actitimeautomation.pages2.CustomerPage;
import com.actitimeautomation.pages2.LoginPage;
import com.actitimeautomation.pages2.ProjectPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(TestListener.class)
public class ProjectTest extends BaseClass {

    WebDriver driver;
    PropertyHandling propertyHandling;
    LoginPage loginPage;
    CustomerPage customerPage;
    ProjectPage projectPage;
    CommonUtil commonUtil;

    @BeforeClass
    public void setup(ITestContext context) throws IOException {
        propertyHandling = new PropertyHandling();
        String browser = propertyHandling.getProperty("browser");
        launchBrowser(browser);
        driver = super.driver;
        String url = propertyHandling.getProperty("actitimeURL");
        driver.navigate().to(url);
        loginPage = new LoginPage(driver);
        String username = propertyHandling.getProperty("username");
        String password = propertyHandling.getProperty("password");
        loginPage.login(username, password);
        customerPage = new CustomerPage(driver);
        projectPage = new ProjectPage(driver);
        commonUtil = new CommonUtil(driver);
        //Set the driver context
        context.setAttribute("driver", driver);
    }

    @BeforeMethod
    public void clickOnTaskModule() {
        commonUtil.waitForElementClickable2(customerPage.taskModule);
        customerPage.clickOnTaskModule();
    }

    @Test
    public void CreateProject() {
        String projectName = "Project2";
        String customerName = "Shrikant";
        driver.findElement(customerPage.addNewButton).click();
        projectPage.createNewProject.click();
        projectPage.enterProjectName.sendKeys(projectName);
        projectPage.dropDownButton.click();
//        projectPage.customerDropDownList.sendKeys("Srimant Dagdusheth Halwai Ganpati");
//        projectPage.searchedCustomer.click();
        for (WebElement customerList : projectPage.listOfCustomer) {
            String selectCustomer = customerList.getText();
            if (selectCustomer.equalsIgnoreCase(customerName)) {
                customerList.click();
                break;
            }
        }
        projectPage.createProjectButton.click();
        projectPage.verifyProject(projectName);
    }

    @Test(enabled = false)
    public void verifyProject() {
        projectPage.verifyProject("Project1");
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}