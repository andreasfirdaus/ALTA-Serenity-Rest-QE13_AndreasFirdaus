package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //scenario 1
    @Given("Get single user with valid {int}")
    public void getSingleUserWithValid(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when()
                .get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.and()
                .body(ReqresResponses.DATA_ID,equalTo(id));
    }

    @And("Validate get single users json schema {string}")
    public void validateGetSingleUsersJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //scenario 2
    @Given("Get single user with not found {int}")
    public void getListSingleUserWithInvalid(int id) {
        reqresAPI.getSingleUser(id);
    }

    //scenario 3
    @Given("Get single user with invalid {string}")
    public void getSingleUserWithInvalid(String id) {
        reqresAPI.getSingleUser2(id);
    }
}
