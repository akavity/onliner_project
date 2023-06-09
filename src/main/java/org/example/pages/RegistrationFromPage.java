package org.example.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class RegistrationFromPage extends BasePage {

    protected WebDriver driver;

    @FindBy(xpath = "//input[@type=\"email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder=\"Придумайте пароль\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@placeholder=\"Повторите пароль\"]")
    private WebElement repeatPasswordField;

    @FindBy(xpath = "//span[@class=\"auth-checkbox__faux\"]")
    private WebElement consentButton;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@href=\"http://mail.onlcool.com/\"]")
    private WebElement goButton;

    public RegistrationFromPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmail() {
        return emailField;
    }

    public WebElement getPassword() {
        return passwordField;
    }

    public WebElement getPasswordAgan() {
        return repeatPasswordField;
    }

    public WebElement getConsentButton() {
        return consentButton;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getTextGoToMail() {
        return goButton;
    }
}
