import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class SeleniumFramework {

    @Test
    public void passwordCheck() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://deens-master.now.sh/login");

        WebElement login_button = driver.findElement(By.cssSelector("[data-testid=\'loginSubmit\']"));
        login_button.click();

        WebElement uiErrorMessage = driver.findElement(By.cssSelector(".ui.error.message p"));

        String errorMessagetext = uiErrorMessage.getText();
        System.out.println(errorMessagetext);

        Assert.assertEquals(errorMessagetext, "Empty email or password");


    }
}

//    @Test
//    public void IncorrectEmailAndPassword() {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        WebElement emailField = driver.findElement(By.cssSelector("#email"));
//        emailField.sendKeys("incorrect@email.com");
//
//        WebElement passwordField = driver.findElement(By.cssSelector("password"));
//        passwordField.sendKeys("incorrect password");
//
//        WebElement login_button = driver.findElement(By.cssSelector("[data-testid=\'loginSubmit\']"));
//        login_button.click();
//
//        WebElement uiErrorMessage = driver.findElement(By.cssSelector(".ui.error.message p"));
//
//        String errorMessagetext = uiErrorMessage.getText();
//        System.out.println(errorMessagetext);
//
//        Assert.assertEquals(errorMessagetext, "Empty email or password");
