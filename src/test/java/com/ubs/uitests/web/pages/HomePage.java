package com.ubs.uitests.web.pages;

import com.ubs.uitests.web.utility.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageAction {

    @FindBy(xpath = "//div[@id='metanav']/div[contains(@class, 'metaNav__list')]/ul")
    private WebElement firstLevel;

    @FindBy(xpath = "//button[contains(@class, 'domicileSelection__select--region')]")
    private WebElement regionList;

    @FindBy(xpath = "//button[contains(@class, 'domicileSelection__select--domicile')]")
    private WebElement countryList;

    @FindBy(xpath = "//button[contains(@data-nn-init, 'cookiemanagement')]")
    private WebElement acceptCookiePolicy;

    @FindBy(xpath = "//ul[@id='supportingnav']/li")
    private WebElement contactOption;

    @FindBy(xpath = "//a[contains(@href, 'contact-us/get-in-touch')]")
    private WebElement getInTouchLink;

    @FindBy(xpath = "//button[contains(@class, 'header-login-open')]")
    private WebElement ubsLogin;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage navigateToHome() {
        driver.get(ConfigManager.getHomePage());
        return this;
    }

    public HomePage selectDocmicile(String domicile, String country) {
        waitForElement(firstLevel);
        click(firstLevel);
        waitForElement(regionList);
        click(regionList);
        WebElement region = driver.findElement(By.xpath("//button[@data-region='" + domicile + "']"));
        click(region);
        waitForElementNotDisplayed(region, 5);
        click(countryList);
        WebElement countryToSelect = driver.findElement(By.xpath("//a[contains(text(), '" + country + "')]"));
        click(countryToSelect);
        waitForElementNotDisplayed(countryToSelect, 5);
        return this;
    }

    public HomePage acceptCookiePopUp() {
        switchToFrame(0);
        waitForElement(acceptCookiePolicy);
        click(acceptCookiePolicy);
        return this;
    }

    public HomePage openContactOptions() {
        click(contactOption);
        return this;
    }

    public HomePage selectContactUs() {
        waitForElement(getInTouchLink);
        click(getInTouchLink);
        return this;
    }

    public HomePage openLoginOptions() {
        waitForElement(ubsLogin);
        click(ubsLogin);
        return this;
    }

    public HomePage chooseLoginOption(String userOption) {
        String optionPath = String.format("//li[contains(@class, 'headerLogin__item')]/a[contains(text(), '%s')]/parent::li",
                userOption.trim());
        WebElement loginOption = driver.findElement(By.xpath(optionPath));
        waitForElement(loginOption);
        click(loginOption);
        return this;
    }
}
