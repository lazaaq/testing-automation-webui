package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FormyHome {
    private WebDriver driver;
    private By btnLg = new By.ByXPath("//a[@href='/form']");
    public FormyHome(WebDriver driver) {
        this.driver = driver;
    }
    public FormyForm clickCompleteWebFormLink() {
        driver.findElement(btnLg).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new FormyForm(driver);
    }
}
