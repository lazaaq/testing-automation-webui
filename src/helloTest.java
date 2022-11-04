import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class helloTest {
    private WebDriver driver;

    @Test
    public void driverTest() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://lazaaq.github.io");
        String title = driver.getTitle();
        System.out.println(title);

        WebElement heading = driver.findElement(By.className("display-4"));
        System.out.println(heading.getText());
//        driver.quit();
    }
}
