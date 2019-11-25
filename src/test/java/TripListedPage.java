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

        //then click to individual trip name link you will be landed on the Trip details page, like:
        //  https://deens.com/book/accommodation/sohostel-in-london_5bb61189a965f27332f9ea7a
        for (int i = 0; tripTitles.size() > i; i++) {
            tripTitles = driver.findElements(By.cssSelector("[class*='Itinerary__ServiceTitle-fHxCEn kubSIN'] a"));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tripTitles.get(1));
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-200)");

            String titleFromPLP = tripTitles.get(1).getText();
            tripTitles.get(1).click();

            //You need to verify that trip’s name on Trip details page are equal to the title from Trip Listing page
            String header = driver.findElement(By.cssSelector("[class*='Service__HeaderWrap'] h2")).getText();

            Assert.assertEquals(titleFromPLP,header);
            driver.navigate().back();
        }
    }
}
