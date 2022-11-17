import graphql.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SauceInventoryPage;
import pages.SauceLoginPage;

public class Login {
    private WebDriver driver;
    @BeforeEach
    public void beforeFunction() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void sauceLoginStandard() {
        SauceLoginPage sauceLogin = new SauceLoginPage(driver);
        sauceLogin.setUsername("standard_user");
        sauceLogin.setPassword("secret_sauce");
        SauceInventoryPage sauceInventory = sauceLogin.setSubmitBtn();
        String pageUrl = driver.getCurrentUrl();
        Assert.assertTrue(pageUrl.contains("inventory.html"));
    }

    @Test
    public void sauceLoginLocked() {
        SauceLoginPage sauceLogin = new SauceLoginPage(driver);
        sauceLogin.setUsername("locked_out_user");
        sauceLogin.setPassword("secret_sauce");
        SauceInventoryPage sauceInventory = sauceLogin.setSubmitBtn();
        String pageUrl = driver.getCurrentUrl();
        Assert.assertFalse(pageUrl.contains("inventory.html"));
    }

    @Test
    public void sauceLoginProblem() {
        SauceLoginPage sauceLogin = new SauceLoginPage(driver);
        sauceLogin.setUsername("problem_user");
        sauceLogin.setPassword("secret_sauce");
        SauceInventoryPage sauceInventory = sauceLogin.setSubmitBtn();
        String pageUrl = driver.getCurrentUrl();
        Assert.assertTrue(pageUrl.contains("inventory.html"));
    }
}
