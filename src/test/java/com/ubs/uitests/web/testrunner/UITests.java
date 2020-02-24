package com.ubs.uitests.web.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/contact_ubs.feature"},
        plugin = {"pretty", "html:target/cucumber-reports"
                , "json:target/cucumber-reports/Cucumber.json"
        },
        glue = {"com.ubs.uitests.web"})
public class UITests {
}
