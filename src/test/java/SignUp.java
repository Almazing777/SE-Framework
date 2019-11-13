import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUp {


    //1. Sign Up Success. (Please make sure you can run your Sign Up test more than 2 times !)
    @Test (invocationCount = 3)
    public static void SignUpSuccess() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://deens.com/?internaltraffic");

        WebElement signup = driver.findElement(By.cssSelector("[href*='register']"));
        signup.click();
        signup.sendKeys("AlmasMendy");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.cssSelector("[id=\'email\']"));
        email.click();
        email.sendKeys("someone@gmail.com");

        Thread.sleep(1000);

        WebElement password = driver.findElement(By.cssSelector("[id=\'password\']"));
        password.click();
        password.sendKeys("newpassword");

        Thread.sleep(1000);
        driver.quit();
    }

//  2. Sign Up Wrong credentials (not existing email)
    @Test
    public static void SignUpWrongEmail() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://deens.com/?internaltraffic");

        WebElement signup = driver.findElement(By.cssSelector("[href*='register']"));
        signup.click();
        signup.sendKeys("AlmasMendy");
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.cssSelector("[id=\'email\']"));
        email.click();
        email.sendKeys("gmail.com");

        Thread.sleep(1000);

        WebElement password = driver.findElement(By.cssSelector("[id=\'password\']"));
        password.click();
        password.sendKeys("newpassword");

        driver.findElement(By.cssSelector("[class*=button]")).click();

        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\'ui message\']")).isDisplayed());

        driver.quit();
    }

//  3. Sign Up Empty credentials
    @Test
    public static void SignUpEmptyCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://deens.com/?internaltraffic");

        driver.findElement(By.cssSelector("[href*='register']")).click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[class*=button]")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\'ui message\']")).isDisplayed());
        driver.quit();
    }

}
