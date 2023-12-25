package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class RegisterUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Post register successful user with valid json {string}")
    public void postRegisterSuccessfulUserWithValidJson(String json)
    {
        File jsonRegisterSuccessful =new File(Constants.REQ_BODY+json);
        reqresAPI.PostRegisterSuccessful(jsonRegisterSuccessful);
    }
    @When("Send request post register successful")
    public void sendRequestPostRegisterSuccessful()
    {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }
    @Then("Status code register should be {int}")
    public void statusCodeShouldBe(int statusCode)
    {
        SerenityRest.then().statusCode(statusCode);
    }
    @And("Validate post register successful user json schema {string}")
    public void validatePostRegisterSuccessfulUserJsonSchema(String json)
    {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
    @When("Send request post register unsuccessful")
    public void sendRequestPostRegisterUnsuccessful()
    {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @Given("Post register user with invalid json {string}")
    public void postRegisterUserWithInvalidJson(String json)
    {
        File jsonUnregisterUser = new File(Constants.REQ_BODY+json);
        reqresAPI.PostRegisterUnsuccessful(jsonUnregisterUser);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser()
    {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @And("Validate register user json schema {string}")
    public void validateRegisterUserJsonSchema(String json)
    {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
