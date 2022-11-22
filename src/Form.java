import graphql.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class Form {
    private WebDriver driver;
    private FormyHome formyHome;
    private FormyForm formyForm;
    private FormyThanks formyThanks;
    @BeforeEach
    public void beforeFunction() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/");
        formyHome = new FormyHome(driver);
        formyForm = formyHome.clickCompleteWebFormLink();
    }
    @Test
    public void completeWebForm() {
        formyForm.setFirstName("Lana");
        formyForm.setLastName("Lana");
        formyForm.setJob("Mahasiswa");
        formyForm.setEducation();
        formyForm.setSex();
        formyForm.setExperience();
        formyForm.setDate("11/11/2022");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        formyForm.submitForm();
    }
}
