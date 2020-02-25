package com.ubs.uitests.web.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageAction {

    private int MAX_WAIT = 10;
    protected WebDriver driver;

    public PageAction(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    protected void waitForElement(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementNotDisplayed(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForElement(WebElement element) {
        waitForElement(element, MAX_WAIT);
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void switchToFrame(int frameNumber) {
        driver.switchTo().frame(frameNumber);
    }

    protected void scrollDown(WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0, 100)");
    }

    protected void scrollIntoView(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void write(WebElement element, String textToWrite) {
        element.sendKeys(textToWrite);
    }

    protected void selectByIndex(WebElement element, int indexToSelect) {
        Select select = new Select(element);
        select.selectByIndex(indexToSelect);
    }

    protected void selectByValue(WebElement element, String option) {
        Select select = new Select(element);
        select.selectByValue(option);
    }

    protected boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    protected boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }

    protected String text(WebElement element) {
        return element.getText();
    }
}
