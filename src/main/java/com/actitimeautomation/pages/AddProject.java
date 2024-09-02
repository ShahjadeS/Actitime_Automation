package com.actitimeautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProject
{
    WebDriver driver;
    public AddProject(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnNewProject()
    {
        driver.findElement(By.xpath("//div[contains(@class,'createNewProject')]")).click();
    }

    public void enterProjectName(String projectName)
    {
        driver.findElement(By.xpath("//input[starts-with(@class,'projectNameField')]")).sendKeys(projectName);
    }

    public void enterProjectDescription(String projectDescription)
    {
        driver.findElement(By.xpath("//div[@class='inputContainer']//textarea[@placeholder='Add Project Description']")).sendKeys(projectDescription);
    }

    public void enterTask1Name(String task1)
    {
        driver.findElement(By.xpath("(//input[@placeholder='Enter task name'])[1]")).sendKeys(task1);
    }

    public void enterTask2Name(String task2)
    {
        driver.findElement(By.xpath("(//input[@placeholder='Enter task name'])[2]")).sendKeys(task2);
    }

    public void clickOnCreateProjectButton()
    {
        driver.findElement(By.xpath("//div[text()='Create Project']")).click();
    }
}