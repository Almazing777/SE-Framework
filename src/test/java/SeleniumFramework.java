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
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("a[href*='login']")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[id=\'email\']")).sendKeys("Mendygax@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("Positive89");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[data-testid=\'loginSubmit\']")).click();

        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("[class*=\'DesktopDropDownMenu__AvatarWrapper\']")).isDisplayed());
        System.out.println("Login Successful");

        driver.quit();
    }

    //    TC2 Login Wrong credentials (not existing email)
    @Test
    public static void WrongEmail() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://deens.com/?internaltraffic");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("a[href*='login']")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[id=\'email\']")).sendKeys("Men@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("Positive89");

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("[data-testid=\'loginSubmit\']")).click();

        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\'ui error message\']")).isDisplayed());
        driver.quit();
    }

    //    TC3 Login Empty Credentials
    @Test
    public static void EmptyCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://deens.com/?internaltraffic");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("a[href*='login']")).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[data-testid=\'loginSubmit\']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\'ui error message\']")).isDisplayed());
        driver.quit();
    }

}