import org.example.driver.DriverManager;
import org.example.models.UserData;
import org.example.pages.RegistrationFromPage;
import org.example.utils.JsonReader;
import org.openqa.selenium.WebDriver;
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

    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void checkRegistrationOnliner(UserData userData) {
        registrationFromPage.enterEmail(userData.getEmail());
        registrationFromPage.enterPassword(userData.getPassword());
        registrationFromPage.enterPasswordAgan(userData.getPassword());
        registrationFromPage.clickConsentButton();
        registrationFromPage.clickSubmitButton();

        Assert.assertTrue(registrationFromPage.getTextGoToMail().contains("Перейти в почту"));
    }
}
