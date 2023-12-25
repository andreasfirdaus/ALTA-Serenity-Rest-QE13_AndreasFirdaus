package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;
public class ReqresStepDef {

  @Steps
    ReqresAPI reqresAPI;

    //================================== SCENARIO 1 LATIHAN
    @Given("Get list users with page {int}")
    public void getListUsersWithPagePage(int page)
    {
        reqresAPI.GetListUsers(page);
    }
    @When("Send request get list users")
    public void sendRequestGetListUsers()
    {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }
    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode)
    {
        SerenityRest.then().statusCode(statusCode);
    }
    @And("Response body page should be {int}")
    public void responseBodyPageShouldBePage(int page)
    {
        SerenityRest.and().body(ReqresResponses.PAGE,equalTo(page));
    }
    @And("Validate get list users json schema {string}")
    public void validateGetListUsersJsonSchema(String json)
    {
      File jsonSchema = new File(Constants.JSON_SCHEMA+json);
      SerenityRest.and()
              .assertThat()
              .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //================================== SCENARIO 2 LATIHAN
    @Given("Post Create user with valid json {string}")
    public void postCreateUserWithValidJson(String json)
    {
        File jsonCreateUser =new File(Constants.REQ_BODY+json);
        reqresAPI.postCreateUser(jsonCreateUser);
    }
    @When("Send request post create user")
    public void sendRequestPostCreateUser()
    {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }


    @And("Validate create user json schema {string}")
    public void validateCreateUserJsonSchema(String json)
    {
      File jsonSchema = new File(Constants.JSON_SCHEMA+json);
      SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
      SerenityRest.and()
              .body(ReqresResponses.NAME, equalTo(name))
              .body(ReqresResponses.JOB, equalTo(job));
    }

    //================================== SCENARIO 3 LATIHAN
    @Given("Update user with valid id {int} and json {string}")
    public void updateUserWithValidIdIdAndJson(int id, String json)
    {
        File jsonUpdateUser = new File(Constants.REQ_BODY+json);
        reqresAPI.updateUser(id, jsonUpdateUser);
    }
    @When("Send request update user")
    public void sendRequestUpdateUser()
    {
        SerenityRest.when().put(ReqresAPI.UPDATE_USER);
    }

    @And("Validate update user json schema {string}")
    public void validateUpdateUserJsonSchema(String json)
    {
      File jsonUpdateSchema = new File(Constants.JSON_SCHEMA+json);
      SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonUpdateSchema));
    }

    //================================== SCENARIO 4 LATIHAN
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdId(int id)
    {
        reqresAPI.deleteUser(id);
    }
    @When("Send request delete user")
    public void sendRequestDeleteUser()
    {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }
}
