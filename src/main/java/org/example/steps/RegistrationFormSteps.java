package org.example.steps;

import lombok.extern.log4j.Log4j2;
import org.example.pages.RegistrationFromPage;
import org.example.utils.Waiters;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RegistrationFormSteps {

    private final RegistrationFromPage registrationFromPage;

    public RegistrationFormSteps(WebDriver driver) {
        registrationFromPage = new RegistrationFromPage(driver);
    }

    public void enterEmail(String email) {
        Waiters.waitForVisibility(registrationFromPage.getEmail());
        log.info("Enter email");
        registrationFromPage.getEmail().sendKeys(email);
    }

    public void enterPassword(String password) {
        log.info("Enter password");
        registrationFromPage.getPassword().sendKeys(password);
    }

    public void enterPasswordAgan(String password) {
        log.info("Enter password agan");
        registrationFromPage.getPasswordAgan().sendKeys(password);
    }

    public void clickConsentButton() {
        log.info("Enter consent button");
        registrationFromPage.getConsentButton().click();
    }

    public void clickSubmitButton() {
        log.info("Enter submit button");
        registrationFromPage.getSubmitButton().click();
    }

    public String getTextGoToMail() {
        log.info("Get text go to mail button");
        return registrationFromPage.getTextGoToMail().getText();
    }
}
