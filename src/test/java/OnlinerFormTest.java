import org.example.driver.DriverManager;
import org.example.pages.RegistrationFromPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OnlinerFormTest extends BaseTest {
    protected WebDriver driver;
    private RegistrationFromPage registrationFromPage;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        registrationFromPage = new RegistrationFromPage(driver);
    }

    @Test
    public void checkRegistrationOnliner() {
        registrationFromPage.enterEmail("wipilet483@onlcool.com");
        registrationFromPage.enterPassword("Ed9KDd55jWHW6k");
        registrationFromPage.enterPasswordAgan("Ed9KDd55jWHW6k");
        registrationFromPage.clickConsentButton();
        registrationFromPage.clickSubmitButton();

        WebElement goToMailButton = driver.findElement(By.
                xpath("//a[@href=\"http://mail.onlcool.com/\"]"));

        Assert.assertTrue(goToMailButton.getText().contains("Перейти в почту"));
    }
}
