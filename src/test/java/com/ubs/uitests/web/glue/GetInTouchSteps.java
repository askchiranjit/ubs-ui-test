package com.ubs.uitests.web.glue;

import com.ubs.uitests.web.pages.GetInTouchPage;
import cucumber.api.java.en.And;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class GetInTouchSteps extends BaseSteps {

    private GetInTouchPage getInTouchPage = new GetInTouchPage(driver);;

    @And("I fill request using option number with request:$")
    public void iFillRequestUsingOptionNumberWithRequest(DataTable testData) {
        List<Map<String, String>> requestData = testData.asMaps(String.class, String.class);

        getInTouchPage.selectFromHowCanWeHelpList(requestData.get(0).get("How can we help you?"))
                .selectFromMyInvestibleAssets(requestData.get(0).get("My investible assets"))
                .specifyYourRequest("sdfd");
    }

    @And("I enter my details:$")
    public void iEnterMyDetails(DataTable testData) {
        List<Map<String, String>> requestData = testData.asMaps(String.class, String.class);
        Map<String, String> req = requestData.get(0);

        getInTouchPage.selectTitle(req.get("Title"))
                .yourDetails(req.get("First name"),
                        req.get("Last name"),
                        req.get("City"),
                        req.get("Email"),
                        req.get("Country"));
    }

    @And("I confirm terms and conditions")
    public void iConfirmTermsAndConditions() {
        getInTouchPage.cofirmTerms();
    }

    @And("I submit the request")
    public void iSubmitTheRequest() {
        getInTouchPage.submit();
    }
}
