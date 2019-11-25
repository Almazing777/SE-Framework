import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/radio.html");

        WebElement option1 = driver.findElement(By.cssSelector("[value='Option 1']"));
        option1.click();
        option1.isSelected();

        WebElement checkbox1 = driver.findElement(By.cssSelector("[value='checkbox1']"));
        checkbox1.click();

    }
}
