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

public class LoginUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post login successful user with valid json {string}")
    public void postLoginSuccessfulUserWithValidJson(String json)
    {
        File jsonLoginSuccessful =new File(Constants.REQ_BODY+json);
        reqresAPI.PostloginSuccessful(jsonLoginSuccessful);
    }

    @When("Send request post login successful")
    public void sendRequestPostLoginSuccessful()
    {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_SUCCESFUL_USER);
    }
    @Then("Status code login successful should be {int}")
    public void statusCodeShouldBe(int statusCode)
    {
        SerenityRest.then().statusCode(statusCode);
    }
    @And("Validate post login successful user json schema {string}")
    public void validatePostLoginSuccessfulUserJsonSchema(String json)
    {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }



    @Given("Post login unsuccessful user with invalid json {string}")
    public void postLoginUnsuccessfulUserWithInvalidJson(String json)
    {
        File jsonLoginUnsuccessful =new File(Constants.REQ_BODY+json);
        reqresAPI.PostloginUnsuccessful(jsonLoginUnsuccessful);
    }

    @When("Send request post login unsucessful")
    public void sendRequestPostLoginUnsucessful()
    {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_UNSUCCESFUL_USER);
    }
    @Then("Status code login unsuccessful should be {int}")
    public void statusCodeLoginUnsuccessfulShouldBe(int statusCode)
    {
        SerenityRest.then().statusCode(statusCode);
    }
    @And("Validate post login unsuccessful user json schema {string}")
    public void validatePostLoginUnsuccessfulUserJsonSchema(String json)
    {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
