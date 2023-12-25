package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Update user with valid id {int} and invalid name json {string}")
    public void updateUserWithValidIdIdAndInvalidNameJson(int id,  String json)
    {
        File jsonUpdateUser = new File(Constants.REQ_BODY+json);
        reqresAPI.updateUser(id, jsonUpdateUser);
    }

    @And("Response body name was {string}")
    public void responseBodyNameWas(String name)
    {
        SerenityRest.and()
                .body(ReqresResponses.NAME, equalTo(name));
    }
}
