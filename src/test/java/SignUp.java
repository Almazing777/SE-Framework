import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SignUp {

    private static WebDriver driver;
    private static By username = By.cssSelector("[id=\'username\']");
    private static By email = By.cssSelector("[id=\'email\']");
    private static By password = By.cssSelector("[id=\'password\']");
    private static By button = By.cssSelector(("[class*=button]"));

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://deens.com/?internaltraffic");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[href*='register']")).click();
    }

    @AfterMethod
        public void tearUp(){
        driver.quit();
    }

    //1. Sign Up Success. (Please make sure you can run your Sign Up test more than 2 times !)
    @Test(invocationCount = 3)
    public static void signUpSuccess() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        driver.findElement(username).sendKeys("newusername" + randomInt);
        driver.findElement(email).sendKeys("newnewemail" + randomInt + "@gmail.com");
        driver.findElement(password).sendKeys("zxczxczxc");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.findElement(button).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("[class=\' ls-is-cached lazyloaded\']") ).isDisplayed());
    }

//  2. Sign Up Wrong credentials (not existing email)
    @Test
    public static void signUpWrongEmail() {
        driver.findElement(username).sendKeys("username");
        driver.findElement(email).sendKeys("gmail.com");
        driver.findElement(password).sendKeys("zxczxczxc");
        driver.findElement(button).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS) ;
        String errorMessage = driver.findElement(By.cssSelector("[class=\'ui message\']")).getText();
        Assert.assertTrue(errorMessage.equals("Please enter a valid email address"));
    }

//  3. Sign Up Empty credentials
    @Test
    public static void signUpEmptyCredentials() throws InterruptedException {
        driver.findElement(username).sendKeys("");
        driver.findElement(email).sendKeys("");
        driver.findElement(password).sendKeys("");
        driver.findElement(button).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS) ;
        String errorMessage = driver.findElement(By.cssSelector("[class=\'ui message\']")).getText();
        Assert.assertTrue(errorMessage.equals("Password must be at least 8 characters long"));
    }
}
