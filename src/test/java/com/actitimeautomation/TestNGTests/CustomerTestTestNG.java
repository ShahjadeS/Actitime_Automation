package com.actitimeautomation.TestNGTests;

import com.actitimeautomation.pages.AddCustomer;
import com.actitimeautomation.pages.AddProject;
import com.actitimeautomation.pages.LoginPage;
import com.actitimeautomation.pages.TaskPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerTestTestNG {
    @Test
    public void CustomerTestTest()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        LoginPage loginPage = new LoginPage(driver);
        TaskPage taskPage = new TaskPage(driver);
        AddCustomer addCustomer = new AddCustomer(driver);
        AddProject addProject = new AddProject(driver);

        loginPage.login("csseleniumbatch", "CSSeleniumBatch");
        addCustomer.clickOnTaskModule();

        //Verify created Customer is displayed or not
        if (!taskPage.getActualCustomer("Java").equals("Java"))
        {
            addCustomer.addNewButton();
            addCustomer.clickOnNewCustomer();
            addCustomer.enterCustomerName("Java");
            addCustomer.enterCustomerDescription("This is a Programming Language");
            addCustomer.clickOnCreateCustomerButton();
            if (taskPage.getActualCustomerElement().isDisplayed())
            {
                String customerName = taskPage.getActualCustomerElement().getText();
                if (customerName.equals("Java"))
                {
                    System.out.println("Customer " + customerName + " is created successfully...!");
                    //taskPage.clickOnCustomer();
                    addCustomer.addNewButton();
                    addProject.clickOnNewProject();
                    addProject.enterProjectName("JDK");
                    addProject.enterProjectDescription("JVM");
                    addProject.enterTask1Name("TASK1");
                    addProject.enterTask2Name("TASK2");
                    addProject.clickOnCreateProjectButton();
                } else {
                    System.out.println("Customer did not created...!");
                }
            } else {
                System.out.println("Customer did not displayed...!");
            }
        } else {
            System.out.println("Customer is already exist...!");
        }
    }
}