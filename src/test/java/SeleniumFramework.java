import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class SeleniumFramework {

    @Test
    public static void LoginSuccess() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://deens.com/?internaltraffic");
        WebElement login_button = driver.findElement(By.cssSelector("a[href*='login']"));
        login_button.click();
        login_button.sendKeys("Mendygax@gmail.com");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.click();
        password.sendKeys("Positive89");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[data-testid=\'loginSubmit\']")).click();

        Thread.sleep(2000);
        driver.quit();
    }

//    TC2 Login Wrong credentials (not existing email)
    @Test
    public static void WrongEmail() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://deens.com/?internaltraffic");

        WebElement login_button = driver.findElement(By.cssSelector("a[href*='login']"));
        login_button.click();
        login_button.sendKeys("mendy@gmail.com");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.click();
        password.sendKeys("Positive89");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[data-testid=\'loginSubmit\']")).click();

        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\'ui error message\']")).isDisplayed());
        driver.quit();
    }

//    TC3 Login Empty Credentials
    @Test
    public static void EmptyCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://deens.com/?internaltraffic");

        driver.findElement(By.cssSelector("a[href*='login']")).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[data-testid=\'loginSubmit\']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\'ui error message\']")).isDisplayed());
        driver.quit();
    }

}