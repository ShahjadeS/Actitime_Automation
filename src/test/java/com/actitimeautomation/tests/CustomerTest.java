package com.actitimeautomation.tests;

import com.actitimeautomation.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class CustomerTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        LoginPage loginPage = new LoginPage(driver);
        TaskPage taskPage = new TaskPage(driver);
        AddCustomer addCustomer = new AddCustomer(driver);
        AddProject addProject = new AddProject(driver);

        loginPage.login("csseleniumbatch", "CSSeleniumBatch");
        addCustomer.clickOnTaskModule();

        //Verify created Customer is displayed or not
        if (!taskPage.getActualCustomer("Selenium").equals("Selenium"))
        {
            addCustomer.addNewButton();
            addCustomer.clickOnNewCustomer();
            addCustomer.enterCustomerName("Selenium");
            addCustomer.enterCustomerDescription("This is Automation Tool");
            addCustomer.clickOnCreateCustomerButton();
            if (taskPage.getActualCustomerElement().isDisplayed())
            {
                String customerName = taskPage.getActualCustomerElement().getText();
                if (customerName.equals("Selenium"))
                {
                    System.out.println("Customer " + customerName + " is created successfully...!");
                    //taskPage.clickOnCustomer();
                    addCustomer.addNewButton();
                    addProject.clickOnNewProject();
                    addProject.enterProjectName("Actitime");
                    addProject.enterProjectDescription("Actitime Website");
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