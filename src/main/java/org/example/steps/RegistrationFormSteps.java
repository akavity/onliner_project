package org.example.steps;

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

    public void enterEmail(String email) {
        Waiters.waitForVisibility(registrationFormPage.getEmail());
        log.info("Enter email");
        registrationFormPage.getEmail().sendKeys(email);
    }

    public void enterPassword(String password) {
        log.info("Enter password");
        registrationFormPage.getPassword().sendKeys(password);
    }

    public void enterPasswordAgan(String password) {
        log.info("Enter password agan");
        registrationFormPage.getPasswordAgan().sendKeys(password);
    }

    public void clickConsentButton() {
        log.info("Enter consent button");
        registrationFormPage.getConsentButton().click();
    }

    public void clickSubmitButton() {
        log.info("Enter submit button");
        registrationFormPage.getSubmitButton().click();
    }

    public String getTextGoToMail() {
        log.info("Get text go to mail button");
        return registrationFormPage.getTextGoToMail().getText();
    }
}
