package com.actitimeautomation.pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class ProjectPage {
    WebDriver driver;
    //    @FindBy(xpath = "//div[@class='addNewButton']")
//    WebElement addNewButton;
    @FindBy(xpath = "//div[contains(@class,'createNewProject')]")
    public WebElement createNewProject;
    @FindBy(xpath = "//div[@id='createProjectPopup']/descendant::input[@placeholder='Enter Project Name']")
    public WebElement enterProjectName;
    @FindBy(xpath = "//div[@id='createProjectPopup']//div[@class='dropdownButton']")
    public WebElement dropDownButton;
    @FindBy(xpath = "//div[@id='createProjectPopup']//div[@class='emptySelection']")
    public WebElement customerDropDownList;
    @FindBy(xpath = "//div[@id='createProjectPopup']//div[@class='scrollableDropdownView']//div[@class='searchItemList']/div")
    public List<WebElement> listOfCustomer;
    @FindBy(xpath = "//div[@id='createProjectPopup']//div[@class='searchItemList']")
    public WebElement searchedCustomer;
    @FindBy(xpath = "//div[@id='createProjectPopup']//div[@class='components_button_label']")
    public WebElement createProjectButton;
    public By searchProject = By.xpath("//div[@class='searchAndExportContainer']//input[contains(@placeholder,'Start')]");
    public By searchedProject = By.xpath("//div[@class='filteredContainer']//div[@class='itemsContainer']//div[@class='text']");

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public String verifyProject(String projectName) {
        driver.findElement(searchProject).sendKeys(projectName);
        String projectFound = driver.findElement(searchedProject).getText();
        return projectFound;
    }
}