package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private By search_bar = new By.ByName("q");
    private By button = new By.ByName("btnK");
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSearch_bar(String query) {
        driver.findElement(search_bar).sendKeys(query);
    }

    public ResultPage clickButton() {
        driver.findElement(button).submit();
        return new ResultPage(driver);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public By getSearch_bar() {
        return search_bar;
    }

    public By getButton() {
        return button;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
