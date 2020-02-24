package com.ubs.uitests.web.glue;

import com.ubs.uitests.web.utility.DriverManager;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseSteps {

    protected WebDriver driver;

    protected void openBrowser() {
        DriverManager driverManager = new DriverManager();
        driver = driverManager.createDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
