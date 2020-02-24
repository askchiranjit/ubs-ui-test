package com.ubs.uitests.web.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver createDriver() {
        String driverPath = String.format("%s/%s", System.getProperty("user.dir"),
                ConfigManager.getBrowserDriverPath());
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static void main(String[] args) {
        createDriver();
    }
}
