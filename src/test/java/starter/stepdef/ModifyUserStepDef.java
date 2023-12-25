package starter.stepdef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class ModifyUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //scenario 1
    @Given("Modify user with valid {int} and {string}")
    public void modifyUserWithValidAnd(int id, String json) {
        File jsonModifyUser = new File(Constants.REQ_BODY+json);
        reqresAPI.modifyUser(id, jsonModifyUser);
    }

    @When("Send request modify user")
    public void sendRequestModifyUser() {
        SerenityRest.when()
                .patch(ReqresAPI.UPDATE_USER);
    }

    @And("Validate modify user json schema {string}")
    public void validateModifyUserJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //scenario 2
    @Given("Modify user with invalid {string} and {string}")
    public void modifyUserWithValidAndJson(String id, String json) {
        File jsonModifyUser = new File(Constants.REQ_BODY+json);
        reqresAPI.modifyInvalidUser(id,jsonModifyUser);
    }

}
