package com.ubs.uitests.web.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static final String environmentPropFile = "src/test/resources/environment.properties";

    public static String getBrowserDriverPath() {
        return getProperty("browserDriver");
    }

    public static String getHomePage() {
        return getProperty("baseURL");
    }

    private static String getProperty(String propertyName) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(environmentPropFile));
            return properties.getProperty(propertyName);
        }
        catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
