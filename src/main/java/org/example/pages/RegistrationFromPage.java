package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationFromPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@type=\"email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder=\"Придумайте пароль\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@placeholder=\"Повторите пароль\"]")
    private WebElement repeatPasswordField;

    @FindBy(xpath = "//span[@class=\"i-checkbox__faux\"]")
    private WebElement consentButton;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;

//    @FindBy(xpath = "//a[@href=\"http://mail.onlcool.com/\"]")
//            private WebElement goToMailButton;

    public RegistrationFromPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterPasswordAgan(String password) {
        repeatPasswordField.sendKeys(password);
    }

    public void clickConsentButton() {
        consentButton.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

}
