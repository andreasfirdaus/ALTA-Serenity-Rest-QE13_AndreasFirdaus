package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DelayedResponseStepDef {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Get user delayed response with delay {int}")
    public void getUserDelayedResponseWithDelay(int delay)
    {
        reqresAPI.GetdelayedResponse(delay);
    }

    @When("Send request get user delayed response")
    public void sendRequestGetUserDelayedResponse()
    {
        SerenityRest.when().get(ReqresAPI.GET_DELAYED_RESPONSE);
    }

}
