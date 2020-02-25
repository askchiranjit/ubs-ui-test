package com.ubs.uitests.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GetInTouchPage extends PageAction {

    @FindBy(id = "How-can-we-help-you")
    private WebElement howCanWeHelpYouList;

    @FindBy(id = "My-investible-assets")
    private WebElement myInvestibleAssetsList;

    @FindBy(id = "Please-specify-your-request")
    private WebElement requestText;

    @FindBy(xpath = "//input[@value='Mrs']")
    private WebElement titleRadio;

    @FindBy(id = "First-name")
    private WebElement firstName;

    @FindBy(id = "Last-name")
    private WebElement lastName;

    @FindBy(id = "City")
    private WebElement cityTxt;

    @FindBy(id = "E-mail")
    private WebElement emailTxt;

    @FindBy(id = "Country-of-residence")
    private WebElement countryOfResidenceList;

    @FindBy(xpath = "//label[@for='Confirmation_1']")
    private WebElement confirm1;

    @FindBy(xpath = "//label[@for='Confirmation-optional_1']")
    private WebElement confirmationOptional;

    @FindBy(name = "senddata")
    private WebElement submit;

    public GetInTouchPage(WebDriver driver) {
        super(driver);
    }

    public GetInTouchPage selectFromHowCanWeHelpList(String index) {
        scrollIntoView(howCanWeHelpYouList);
        click(howCanWeHelpYouList);
        selectByIndex(howCanWeHelpYouList, Integer.parseInt(index));
        return this;
    }

    public GetInTouchPage selectFromMyInvestibleAssets(String index) {
        waitForElement(myInvestibleAssetsList);
        click(myInvestibleAssetsList);
        selectByIndex(myInvestibleAssetsList, Integer.parseInt(index));
        return this;
    }

    public GetInTouchPage specifyYourRequest(String text) {
        waitForElement(requestText);
        write(requestText, text);
        return this;
    }

    public GetInTouchPage selectTitle(String title) {
        scrollIntoView(titleRadio);
        String titlePath = String.format("//input[@value='%s']/following-sibling::label", title.trim());
        WebElement titleToSelect = driver.findElement(By.xpath(titlePath));
        click(titleToSelect);
        return this;
    }

    public GetInTouchPage yourDetails(String firstname, String lastname, String city, String email, String country) {
        write(firstName, firstname);
        write(lastName, lastname);
        write(cityTxt, city);
        write(emailTxt, email);
        selectByValue(countryOfResidenceList, country);
        return this;
    }

    public GetInTouchPage cofirmTerms() {
        scrollIntoView(confirm1);
        click(confirm1);
        click(confirmationOptional);
        return this;
    }

    public GetInTouchPage submit() {
        waitForElement(submit);
        click(submit);
        return this;
    }

}
