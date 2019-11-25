import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/newtours/register.php");
        WebElement element = driver.findElement(By.cssSelector("[name=country]"));
        Select country = new Select(element);

        List<WebElement> options = country.getOptions();

        for (WebElement countryNames : options) {
            System.out.println(countryNames.getText());;
        }
        // Another way of selecting
//        country.selectByVisibleText("RUSSIA");
//        WebElement option = country.getFirstSelectedOption();
//        System.out.println(option.getText());

        //checkbox

        //Implicit waits

    }
}
