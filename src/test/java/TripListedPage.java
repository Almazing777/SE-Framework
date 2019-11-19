//Find Elements:
//Open Any Trip Listing Page, for example:
//  https://deens.com/book/trip/fun-getaway-with-friends-in-london-in-greater-london-county_5be9ecaa7a5b0d2bc5980e0b
//take the trip name from each trip on listing page
//then click to individual trip name link you will be landed on the Trip details page, like:
//  https://deens.com/book/accommodation/sohostel-in-london_5bb61189a965f27332f9ea7a
//You need to verify that trip’s name on Trip details page are equal to the title from Trip Listing page

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TripListedPage {

    @Test()
    public static void VerifyCountOfDay() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;

        driver.get("https://www.viator.com/");
        WebElement textBox = driver.findElement(By.cssSelector("[data-automation='typeahead-input']"));
        textBox.sendKeys("Los Angeles");
        textBox.sendKeys(Keys.ENTER);
//        driver.findElement(By.cssSelector("[data-automation='typeahead-button']")).click();

        List<WebElement> tripTitles = driver.findElements(By.cssSelector("[data-shelf-type='TTD_RECOMMENDED_FOR_YOU_SHELF']"));
        Assert.assertTrue(tripTitles.size() > 0);

        //List<WebElement> tripTitles = driver.findElements(By.cssSelector("[class *='Itinerary__ServiceTitle']"));

//        for (int i = 0; i < tripTitles.size(); i++) {
//            WebElement day = tripTitles.get(i);
//
//            String dayText = day.getText();
//            System.out.println(dayText);
//        }
//
//        Assert.assertTrue(tripTitles.size() > 0);
//
//        driver.findElement(By.cssSelector("a[href*='href=\'/book/activity/central-london-pub-crawl-with-skip-the-line-entry-and-guide-in-london_5bdba19ef1342e59cb0f928a\"']")).click();
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////
//        WebElement pdpTitle = driver.findElement(By.cssSelector("[class*='Service_HeaderWrap']"));
//        System.out.println(pdpTitle);
//
//        Assert.assertEquals(pdpTitle, "SoHostel");
    }
}
