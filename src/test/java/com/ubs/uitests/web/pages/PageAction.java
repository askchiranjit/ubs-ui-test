package com.ubs.uitests.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageAction {

    private int MAX_WAIT = 10;

    protected void waitForElement(WebDriver driver, WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElement(WebDriver driver, WebElement element) {
        waitForElement(driver, element, MAX_WAIT);
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

    protected void switchToFrame(WebDriver driver, int frameNumber) {
        driver.switchTo().frame(frameNumber);
    }
}
