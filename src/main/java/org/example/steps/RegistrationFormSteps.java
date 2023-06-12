package org.example.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.pages.RegistrationFormPage;
import org.example.utils.Waiters;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RegistrationFormSteps {

    private final RegistrationFormPage registrationFormPage;

    public RegistrationFormSteps(WebDriver driver) {
        registrationFormPage = new RegistrationFormPage(driver);
    }
    @Step("Enter email")
    public void enterEmail(String email) {
        Waiters.waitForVisibility(registrationFormPage.getEmail());
        log.info("Enter email");
        registrationFormPage.getEmail().sendKeys(email);
    }
    @Step("Enter password")
    public void enterPassword(String password) {
        log.info("Enter password");
        registrationFormPage.getPassword().sendKeys(password);
    }
    @Step("Enter password agan")
    public void enterPasswordAgan(String password) {
        log.info("Enter password agan");
        registrationFormPage.getPasswordAgan().sendKeys(password);
    }
    @Step("Enter consent button")
    public void clickConsentButton() {
        log.info("Enter consent button");
        registrationFormPage.getConsentButton().click();
    }
    @Step("Enter submit button")
    public void clickSubmitButton() {
        log.info("Enter submit button");
        registrationFormPage.getSubmitButton().click();
    }
    @Step("Get text go to mail button")
    public String getTextGoToMail() {
        log.info("Get text go to mail button");
        return registrationFormPage.getTextGoToMail().getText();
    }
}
