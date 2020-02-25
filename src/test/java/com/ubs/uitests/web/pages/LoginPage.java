package com.ubs.uitests.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageAction {

    @FindBy(name = "isiwebuserid")
    private WebElement contactNumberTxt;

    @FindBy(id = "AuthGetContractNrDialog_submit")
    private WebElement continueBtn;

    @FindBy(xpath = "//div[contains(@class, 'message-box-type-warning')]/div[last()]")
    private WebElement warningMessage;

    @FindBy(xpath = "//input[contains(@class, 'verify-email-input')]")
    private WebElement emailTxt;

    @FindBy(xpath = "//button[contains(@class, 'verify-email-button')]")
    private WebElement clientPortalLoginButton;

    @FindBy(xpath = "//input[contains(@class, 'digits-input')]")
    private WebElement phoneDigit;

    @FindBy(xpath = "//button[contains(@class, 'digits-button')]")
    private WebElement textActivation;

    @FindBy(xpath = "//div[contains(@class, 'send-text-section')]/p[contains(@class, 'error-section')]")
    private WebElement errorDetailsNotInRecords;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void contact(String number) {
        waitForElement(contactNumberTxt);
        write(contactNumberTxt, number);
        click(continueBtn);
    }

    public boolean isWarning() {
        waitForElement(warningMessage);
        return isDisplayed(warningMessage) && !text(warningMessage).isEmpty();
    }

    public LoginPage typeEmail(String email) {
        waitForElement(emailTxt);
        write(emailTxt, email);
        return this;
    }

    public LoginPage loginClientPortal() {
        waitForElement(clientPortalLoginButton);
        click(clientPortalLoginButton);
        return this;
    }

    public LoginPage typePhoneDigitsForClientPortal(String phone) {
        waitForElement(phoneDigit);
        write(phoneDigit, phone);
        return this;
    }

    public LoginPage textMeActivationCode() {
        waitForElement(textActivation);
        click(textActivation);
        return this;
    }


    public boolean isErrorAsDetailsDoNotMatch() {
        waitForElement(errorDetailsNotInRecords);
        return isDisplayed(errorDetailsNotInRecords);
    }
}
