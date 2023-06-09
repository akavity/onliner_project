import org.example.driver.DriverManager;
import org.example.pages.RegistrationFromPage;
import org.example.pages.SoppingInStorePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OnlinerFormTest extends BaseTest {
    protected WebDriver driver;
    private RegistrationFromPage registrationFromPage;
    private SoppingInStorePage soppingInStorePage;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        registrationFromPage = new RegistrationFromPage(driver);
        soppingInStorePage = new SoppingInStorePage(driver);
    }

    @Test
    public void checkRegistrationOnliner() {
        registrationFromPage.enterEmail("wipilet483@onlcool.com");
        registrationFromPage.enterPassword("Ed9KDd55jWHW6k");
        registrationFromPage.enterPasswordAgan("Ed9KDd55jWHW6k");
        registrationFromPage.clickConsentButton();
        registrationFromPage.clickSubmitButton();

        Assert.assertTrue(registrationFromPage.getTextGoToMail().contains("Перейти в почту"));
    }
}
