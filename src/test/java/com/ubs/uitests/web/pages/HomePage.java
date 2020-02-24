package com.ubs.uitests.web.pages;

import com.ubs.uitests.web.utility.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageAction {

    private WebDriver driver;

    @FindBy(xpath = "//div[@id='metanav']/div[contains(@class, 'metaNav__list')]/ul")
    private WebElement firstLevel;

    @FindBy(xpath = "//button[contains(@class, 'domicileSelection__select--region')]")
    private WebElement regionList;

    @FindBy(xpath = "//button[contains(@class, 'domicileSelection__select--domicile')]")
    private WebElement countryList;

    @FindBy(xpath = "//button[contains(@data-nn-init, 'cookiemanagement')]")
    private WebElement acceptCookiePolicy;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToHome() {
        driver.get(ConfigManager.getHomePage());
    }

    public void selectDocmicile(String domicile, String country) {
        waitForElement(driver, firstLevel);
        click(firstLevel);
        waitForElement(driver, regionList);
        click(regionList);
        WebElement region = driver.findElement(By.xpath("//button[@data-region='" + domicile + "']"));
        click(region);
        click(countryList);
        WebElement countryToSelect = driver.findElement(By.xpath("//a[contains(text(), '" + country + "')]"));
        click(countryToSelect);
    }

    public void acceptCookiePopUp() {
        switchToFrame(driver, 0);
        waitForElement(driver, acceptCookiePolicy);
        click(acceptCookiePolicy);
    }
}
