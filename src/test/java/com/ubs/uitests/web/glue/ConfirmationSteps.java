package com.ubs.uitests.web.glue;

import com.ubs.uitests.web.pages.ConfirmationPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ConfirmationSteps extends BaseSteps {

    private ConfirmationPage confirmationPage = new ConfirmationPage(driver);

    @Then("I should see the confirmation screen")
    public void iShouldSeeTheConfirmationScreen() {
        Assert.assertEquals("Browser page is wrong", true,
                getBrowserTitle().toLowerCase().contains("confirmation"));
        Assert.assertEquals("Confirmation message not displayed", true,
                confirmationPage.isConfirmed());
    }
}
