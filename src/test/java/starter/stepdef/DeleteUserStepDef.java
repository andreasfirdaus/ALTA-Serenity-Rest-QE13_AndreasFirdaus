package starter.stepdef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete user with invalid {string}")
    public void deleteUserWithInvalidId(String id)
    {
        reqresAPI.deleteUserInvalid(id);
    }

}
