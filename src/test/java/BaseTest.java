import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://deens.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
        driver.findElement(By.cssSelector("a[href*='fun-getaway-with-friends-in-london']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
    }

    @AfterMethod
    public void tearUp(){
        driver.quit();
    }
}
