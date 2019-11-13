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
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[href*='register']")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[id=\'username\']")).sendKeys("KzMendy");
        driver.findElement(By.cssSelector("[id=\'email\']")).sendKeys("AlmasKz@gmail.com");
        driver.findElement(By.cssSelector("[id=\'password\']")).sendKeys("newpassword");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[class*=button]")).click();
        Thread.sleep(6000);

        Assert.assertTrue(driver.findElement(By.cssSelector("[class*=\'DesktopDropDownMenu__AvatarWrapper\']")).isDisplayed());
        System.out.println("SignUp Successful");
        driver.quit();
    }

//  2. Sign Up Wrong credentials (not existing email)
    @Test
    public static void SignUpWrongEmail() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://deens.com/?internaltraffic");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[href*='register']")).click();;
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[id=\'username\']")).sendKeys("Alm");
        driver.findElement(By.cssSelector("[id=\'email\']")).sendKeys("gmail.com");
        driver.findElement(By.cssSelector("[id=\'password\']")).sendKeys("newpassword");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[class*=button]")).click();

        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\'ui message\']")).isDisplayed());
        System.out.println("Error: Wrong Email");

        driver.quit();
    }

//  3. Sign Up Empty credentials
    @Test
    public static void SignUpEmptyCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://deens.com/?internaltraffic");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("[href*='register']")).click();;
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[id=\'username\']")).sendKeys("");
        driver.findElement(By.cssSelector("[id=\'email\']")).sendKeys("");
        driver.findElement(By.cssSelector("[id=\'password\']")).sendKeys("");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[class*=button]")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\'ui message\']")).isDisplayed());
        System.out.println("Empty Credentials");
        driver.quit();
    }

}
