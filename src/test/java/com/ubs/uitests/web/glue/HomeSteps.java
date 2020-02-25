package com.ubs.uitests.web.glue;

import com.ubs.uitests.web.pages.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class HomeSteps extends BaseSteps {

    private HomePage homePage = new HomePage(driver);;

    @Given("I open UBS site")
    public void iOpenUBSSite() {
        homePage.navigateToHome()
                .acceptCookiePopUp();
    }

    @And("I specify below information:$")
    public void iSpecifyBelowInformation(DataTable testData) {
        List<Map<String, String>> domicileData = testData.asMaps(String.class, String.class);
        homePage.selectDocmicile(domicileData.get(0).get("domicile").trim(), domicileData.get(0).get("country").trim());
    }

    @When("I navigate to contact us from contact menu")
    public void iNavigateToContactUsFromContactMenu() {
        homePage.openContactOptions()
                .selectContactUs();
    }

    @When("I navigate to login as {string}")
    public void iNavigateToLoginAs(String userOption) {
        homePage.openLoginOptions()
                .chooseLoginOption(userOption);
    }
}
