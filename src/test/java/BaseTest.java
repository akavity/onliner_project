import org.example.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.ResourceBundle;

public class BaseTest {
    private WebDriver driver;
    static ResourceBundle bundle = ResourceBundle.getBundle("onliner_framework");
    private final String URL = bundle.getString("path_to_url");

    @BeforeTest
    public void init() {
        driver = DriverManager.getDriver();
    }

    @BeforeMethod
    public void preparation() {
        driver = DriverManager.getDriver();
        driver.get(URL);
    }

    @AfterTest
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
