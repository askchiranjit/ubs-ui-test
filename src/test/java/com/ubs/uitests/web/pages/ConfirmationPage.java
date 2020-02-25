package com.ubs.uitests.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends PageAction {

    @FindBy(xpath = "//div[contains(@class, 'textimage__listicon')]/h4")
    private WebElement confirmMessage;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isConfirmed() {
        waitForElement(confirmMessage);
        return isDisplayed(confirmMessage) && !text(confirmMessage).isEmpty();
    }
}
