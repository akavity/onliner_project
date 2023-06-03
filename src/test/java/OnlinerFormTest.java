import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OnlinerFormTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "G:\\Installation\\chromedriver.exe");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://profile.onliner.by/registration");
    }

    @Test
    public void checkRegistrationOnliner() {

//        WebElement enterButton = driver.findElement(By.xpath("//div[@class=\"auth-bar__item auth-bar__item--text\"]"));
//        enterButton.click();

        WebElement emailField = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        emailField.sendKeys("wipilet483@onlcool.com");

        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder=\"Придумайте пароль\"]"));
        passwordField.sendKeys("Ed9KDd55jWHW6k");

        WebElement repeatPassword = driver.findElement(By.xpath("//input[@placeholder=\"Повторите пароль\"]"));
        repeatPassword.sendKeys("Ed9KDd55jWHW6k");

        WebElement consentButton = driver.findElement(By.xpath("//span[@class=\"i-checkbox__faux\"]"));
        consentButton.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        submitButton.click();

        WebElement goToMailButton = wait.until(ExpectedConditions.elementToBeClickable(By.
                xpath("//a[@href=\"http://mail.onlcool.com/\"]")));

        Assert.assertTrue(goToMailButton.getText().contains("Перейти в почту"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
