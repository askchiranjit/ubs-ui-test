package com.ubs.uitests.web.glue;

import com.ubs.uitests.web.utility.DriverManager;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseSteps {

    protected static WebDriver driver = null;

    protected void openBrowser() {
        DriverManager driverManager = new DriverManager();
        driver = driverManager.createDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    protected void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    protected String getBrowserTitle() {
        return driver.getTitle();
    }
}
