package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormyForm {
    private WebDriver driver;
    private By btnSubmit = new By.ByXPath("//a[@href='/thanks']");
    private By firstName = new By.ByXPath("//input[@id='first-name']");
    private By lastName = new By.ByXPath("//input[@id='last-name']");
    private By job = new By.ByXPath("//input[@id='job-title']");
    private By education = new By.ByXPath("//input[@id='radio-button-1']");
    private By sex = new By.ByXPath("//input[@id='checkbox-1']");
    private By experiences = new By.ByXPath("//select[@id='select-menu']");
    private By date = new By.ByXPath("//input[@id='datepicker']");

    public FormyForm(WebDriver driver) { this.driver = driver; }
    public void setFirstName(String name) {
        driver.findElement(firstName).sendKeys(name);
    }
    public void setLastName(String name) {
        driver.findElement(lastName).sendKeys(name);
    }
    public void setJob(String jobTitle) {
        driver.findElement(job).sendKeys(jobTitle);
    }
    public void setEducation() {
        driver.findElement(education).click();
    }
    public void setSex() {
        driver.findElement(sex).click();
    }
    public void setExperience() {
        Select sel = new Select(driver.findElement(experiences));
        sel.selectByVisibleText("0-1");
    }
    public void setDate(String mydate) {
        driver.findElement(date).sendKeys(mydate);
    }

    public FormyThanks submitForm() {
        driver.findElement(btnSubmit).click();
        return new FormyThanks(driver);
    }
}
