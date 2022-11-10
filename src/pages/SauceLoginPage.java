package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceLoginPage {
    private WebDriver driver;
    private By username = new By.ById("user-name");
    private By password = new By.ById("password");
    private By submitBtn = new By.ById("login-button");
    private By error = new By.ByClassName("error");

    public SauceLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String keys) {
        driver.findElement(username).sendKeys(keys);
    }

    public void setPassword(String keys) {
        driver.findElement(password).sendKeys(keys);
    }

    public SauceInventoryPage setSubmitBtn() {
        driver.findElement(submitBtn).submit();
        return new SauceInventoryPage(driver);
    }

    public String getError() {
        return driver.findElement(error).getText();
    }

}
