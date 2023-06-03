package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ResourceBundle;

public class DriverManager {
    static ResourceBundle bundle = ResourceBundle.getBundle("onliner_framework");
    private static WebDriver driver = null;

    public DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get(bundle.getString("path_to_url"));
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            driver.quit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}