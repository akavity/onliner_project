import io.qameta.allure.Link;
import org.example.driver.DriverManager;
import org.example.models.UserData;
import org.example.steps.RegistrationFormSteps;
import org.example.utils.AllureListener;
import org.example.utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class OnlinerFormTest extends BaseTest {
    protected WebDriver driver;
    private RegistrationFormSteps registrationFormSteps;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        registrationFormSteps = new RegistrationFormSteps(driver);
    }

    @Link("https://profile.onliner.by/registration")
    @Test(description = "Check registration form onliner",
            dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void checkRegistrationOnliner(UserData userData) {
        registrationFormSteps.enterEmail(userData.getEmail());
        registrationFormSteps.enterPassword(userData.getPassword());
        registrationFormSteps.enterPasswordAgan(userData.getPassword());
        registrationFormSteps.clickConsentButton();
        registrationFormSteps.clickSubmitButton();

        Assert.assertTrue(registrationFormSteps.getTextGoToMail().contains(userData.getText()));
    }
}
