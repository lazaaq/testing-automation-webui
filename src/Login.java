import graphql.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ResultPage;
import pages.SauceInventoryPage;
import pages.SearchPage;
import pages.SauceLoginPage;

public class Login {
    private WebDriver driver;

    @Test
    public void googleTest() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        SearchPage search = new SearchPage(driver);
        search.setSearch_bar("lana");
        ResultPage result = search.clickButton();
        String title = result.getPageTitle();
        Assert.assertTrue(title.contains("lana"));
    }

    @Test
    public void sauceLoginStandard() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        SauceLoginPage sauceLogin = new SauceLoginPage(driver);
        sauceLogin.setUsername("standard_user");
        sauceLogin.setPassword("secret_sauce");
        SauceInventoryPage sauceInventory = sauceLogin.setSubmitBtn();
        String pageUrl = driver.getCurrentUrl();
        Assert.assertTrue(pageUrl.contains("inventory.html"));
    }

    @Test
    public void sauceLoginLocked() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        SauceLoginPage sauceLogin = new SauceLoginPage(driver);
        sauceLogin.setUsername("locked_out_user");
        sauceLogin.setPassword("secret_sauce");
        SauceInventoryPage sauceInventory = sauceLogin.setSubmitBtn();
        String pageUrl = driver.getCurrentUrl();
        Assert.assertFalse(pageUrl.contains("inventory.html"));
    }

    @Test
    public void sauceLoginProblem() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        SauceLoginPage sauceLogin = new SauceLoginPage(driver);
        sauceLogin.setUsername("problem_user");
        sauceLogin.setPassword("secret_sauce");
        SauceInventoryPage sauceInventory = sauceLogin.setSubmitBtn();
        String pageUrl = driver.getCurrentUrl();
        Assert.assertTrue(pageUrl.contains("inventory.html"));
    }
}
