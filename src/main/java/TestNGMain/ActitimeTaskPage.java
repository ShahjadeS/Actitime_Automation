package TestNGMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ActitimeTaskPage {
    WebDriver driver;

    public ActitimeTaskPage(WebDriver driver) {
        this.driver = driver;
    }

    //Click on Task Module
    public void clickOnTaskModule() {
        driver.findElement(By.xpath("//div[text()='Tasks']")).click();
    }

    //Verify Task Module
    public void verifyTaskPage() throws Exception {
        WebElement taskModule = driver.findElement(By.xpath("//td[starts-with(@class,'navItem')][2]//div[@class='label']"));
        if (taskModule.isEnabled()) {
            System.out.println("You are successfully landed on Task module");
        } else {
            throw new Exception("Task Module can't be displayed...!");
        }
    }

    //Verify all tasks are present or not
    public void verifyAllTasks() throws InterruptedException {
        Actions actions = new Actions(driver);
        List<WebElement> allTasks = driver.findElements(By.xpath("//div[@class='namesContainer']//div[@class='title']"));
        System.out.println("Total tasks is: " + allTasks.size());
        for (WebElement tasks : allTasks) {
            actions.moveToElement(tasks).perform();
            System.out.println("Task: " + tasks.getText());
        }
    }

    //searchTask using Task_Name
    public void searchTaskByTaskName() throws InterruptedException {
        WebElement taskName = driver.findElement(By.xpath("(//input[@type='text' and contains(@placeholder,'Start')])[2]"));
        taskName.sendKeys("Supplier");
        Thread.sleep(5000);
        List<WebElement> totalTasks = driver.findElements(By.xpath("//table[@class='taskRowsTable']//tr/descendant::td[3]//div[@class='title']"));
        System.out.println("Total Tasks are: " + totalTasks.size());
        for (WebElement task : totalTasks) {
            System.out.println("Task Name: " + task.getText());
        }
    }

//    public void verifyAlreadyCustomerExist(String customerName) throws Exception {
//        //Get the control of all the customers collapse button and click it
//        List<WebElement> allCollapseButton = driver.findElements(By.xpath("//div[contains(@class,'customerNode ')]//div[@class='collapseButton']"));
//        for (WebElement collapseButton : allCollapseButton) {
//            collapseButton.click();
//        }
//        List<WebElement> allCustomerNames = driver.findElements(By.xpath("//div[@class='itemsContainer']//div[@class='title']//div[@class='text']"));
//        for (WebElement custName1 : allCustomerNames) {
//            if (custName1.getText().equals(customerName)) {
//                System.out.println("This " + customerName + " customer is already exist, Try with a different name...!");
//            } else {
//                System.out.println("Lets create a new Customer...!");
//            }
//        }
//    }
//
//    public void createNewCustomer(String customerName, String Description) throws Exception {
//        driver.findElement(By.xpath("//div[@class='addNewButton']")).click();
//        List<WebElement> addNewButtonContainer = driver.findElements(By.xpath("//div[@class='dropdownContainer addNewMenu']/div"));
//        for (WebElement newCustomer : addNewButtonContainer) {
//            if (newCustomer.getText().equals("+ New Customer")) {
//                newCustomer.click();
//                driver.findElement(By.xpath("//input[@type='text' and starts-with(@class,'inputFieldWithPlaceholder')]")).sendKeys(customerName);
//                driver.findElement(By.xpath("//textarea[@class='textarea' and @placeholder='Enter Customer Description']")).sendKeys(Description);
//                driver.findElement(By.xpath("//div[@id='customerLightBox']//div[@class='commitButtonPlaceHolder']")).click();
//            }
//        }
//    }
//
//    public void verifyCustomerAfterCreation(String newlyCreatedCustName) {
//        //Get the control of all the customers collapse button and click it
//        List<WebElement> allCollapseButton = driver.findElements(By.xpath("//div[contains(@class,'customerNode ')]//div[@class='collapseButton']"));
//        for (WebElement collapseButton : allCollapseButton) {
//            collapseButton.click();
//        }
//        List<WebElement> allCustomerNames = driver.findElements(By.xpath("//div[@class='itemsContainer']//div[@class='title']//div[@class='text']"));
//        for (WebElement custName2 : allCustomerNames) {
//            if (custName2.getText().equals(newlyCreatedCustName)) {
//                System.out.println("This " + newlyCreatedCustName + " customer is successfully created...!");
//            } else {
//                System.out.println("Customer can't created...!");
//            }
//        }
//    }

    public boolean isCustomerAlreadyExist(String customerName) {
        //Get the control of all the customers collapse button and click it
        List<WebElement> allCollapseButton = driver.findElements(By.xpath("//div[contains(@class,'customerNode ')]//div[@class='collapseButton']"));
        for (WebElement collapseButton : allCollapseButton) {
            collapseButton.click();
        }
        List<WebElement> allCustomerNames = driver.findElements(By.xpath("//div[@class='itemsContainer']//div[@class='title']//div[@class='text']"));
        for (WebElement custName : allCustomerNames) {
            if (custName.getText().equals(customerName)) {
                return true;
            }
        }
        return false;
    }

    public void createNewCustomer(String customerName, String Description) throws Exception {
        if (!isCustomerAlreadyExist(customerName)) {
            driver.findElement(By.xpath("//div[@class='addNewButton']")).click();
            List<WebElement> addNewButtonContainer = driver.findElements(By.xpath("//div[@class='dropdownContainer addNewMenu']/div"));
            for (WebElement newCustomer : addNewButtonContainer) {
                if (newCustomer.getText().equals("+ New Customer")) {
                    newCustomer.click();
                    driver.findElement(By.xpath("//input[@type='text' and starts-with(@class,'inputFieldWithPlaceholder')]")).sendKeys(customerName);
                    driver.findElement(By.xpath("//textarea[@class='textarea' and @placeholder='Enter Customer Description']")).sendKeys(Description);
                    driver.findElement(By.xpath("//div[@id='customerLightBox']//div[@class='commitButtonPlaceHolder']")).click();
                }
            }
        } else {
            System.out.println("Customer already exists, no need to create a new one.");
        }
    }

    public void verifyCustomerAfterCreation(String newlyCreatedCustName) {
        //Get the control of all the customers collapse button and click it
        List<WebElement> allCollapseButton = driver.findElements(By.xpath("//div[contains(@class,'customerNode ')]//div[@class='collapseButton']"));
        for (WebElement collapseButton : allCollapseButton) {
            collapseButton.click();
        }
        List<WebElement> allCustomerNames = driver.findElements(By.xpath("//div[@class='itemsContainer']//div[@class='title']//div[@class='text']"));
        boolean isCustomerCreated = false;
        for (WebElement custName : allCustomerNames) {
            if (custName.getText().equals(newlyCreatedCustName)) {
                isCustomerCreated = true;
                break;
            }
        }
        if (isCustomerCreated) {
            System.out.println("This " + newlyCreatedCustName + " customer is successfully created...!");
        } else {
            System.out.println("Customer can't created...!");
        }
    }
}