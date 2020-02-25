package com.ubs.uitests.web.glue;

import com.ubs.uitests.web.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class LoginSteps extends BaseSteps {

    private LoginPage loginPage = new LoginPage(driver);

    @And("I enter contact number as {string}")
    public void iEnterContactNumberAs(String number) {
        loginPage.contact(number);
    }

    @Then("I should see error message")
    public void iShouldSeeErrorMessage() {
        Assert.assertEquals("error message not displayed", true, loginPage.isWarning());
    }

    @And("I login with email {string}")
    public void iLoginWithEmail(String email) {
        loginPage.typeEmail(email)
                .loginClientPortal();
    }

    @And("I try activation with three digit of phone as {string}")
    public void iTryActivationWithDigitOfPhoneAs(String phone) {
        loginPage.typePhoneDigitsForClientPortal(phone)
                .textMeActivationCode();
    }

    @Then("I should see error as details not matched")
    public void iShouldSeeErrorAsDetailsNotMatched() {
        Assert.assertEquals("error message not displayed", true,
                loginPage.isErrorAsDetailsDoNotMatch());
    }
}
