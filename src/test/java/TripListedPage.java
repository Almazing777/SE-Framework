import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TripListedPage extends BaseTest {

    //Find Elements:
    //Open Any Trip Listing Page, for example:
    //  https://deens.com/book/trip/fun-getaway-with-friends-in-london-in-greater-london-county_5be9ecaa7a5b0d2bc5980e0b
    //take the trip name from each trip on listing page

    @Test()
    public static void verifyCountOfDay() throws InterruptedException {
        List<WebElement> tripTitles = driver.findElements(By.cssSelector("[class*='Itinerary__ServiceTitle']"));
        Assert.assertTrue(tripTitles.size() > 0);
        System.out.println("tripTitles.get(0) " + tripTitles.get(0).getText());
        System.out.println("tripTitles.get(0) " + tripTitles.get(0));

        //then click to individual trip name link you will be landed on the Trip details page, like:
        //  https://deens.com/book/accommodation/sohostel-in-london_5bb61189a965f27332f9ea7a
        for (int i = 0; tripTitles.size() > i; i++) {
            tripTitles = driver.findElements(By.cssSelector("[class*='Itinerary__ServiceTitle-fHxCEn kubSIN'] a"));
            System.out.println("Number is " + i);

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tripTitles.get(i));
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-200)");

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;

            String titleFromPLP = tripTitles.get(i).getText();
            tripTitles.get(i).click();

            Thread.sleep(5000);

            //You need to verify that trip’s name on Trip details page are equal to the title from Trip Listing page
            String header = driver.findElement(By.cssSelector("[class*='Service__HeaderWrap'] h2")).getText();
            System.out.println("Header " + header);

            Assert.assertEquals(titleFromPLP,header);
            driver.navigate().back();
        }
    }
}
