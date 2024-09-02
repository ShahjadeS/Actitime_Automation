package TestNGMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActitimeLoginPage
{
    WebDriver driver;
    public ActitimeLoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void login(String username, String password)
    {
        //2. Navigate the website (https://online.actitime.com/selenium68/login.do)
        //driver.get("https://online.actitime.com/selenium68/login.do");
        driver.navigate().to("https://online.actitime.com/actiselenium68/login.do");

        //3. Enter username & password
        WebElement username1 = driver.findElement(By.id("username"));
        username1.sendKeys(username);

        WebElement password1 = driver.findElement(By.name("pwd"));
        password1.sendKeys(password);

        //4. Click on login button
        WebElement loginButton1 = driver.findElement(By.xpath("//div[starts-with(text(),'Login')]"));
        loginButton1.click();
    }
}