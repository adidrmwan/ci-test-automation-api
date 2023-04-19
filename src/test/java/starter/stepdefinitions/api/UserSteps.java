package starter.stepdefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.page.LoginPage;
import starter.page.api.User;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UserSteps {
    @Steps
    User user;

    @Given("user has endpoint")
    public void userHasEndpoint() {
        user.setApiEndpoint();
    }

    @When("user get detail by id")
    public void userGetDetailById() {
        user.sendGetHttpRequest();
    }

    @Then("user get status code {int}")
    public void userGetStatusCode(int arg0) {
        user.validateHttpResponseCode200();
    }

    @And("user validate response body")
    public void userValidateResponseBody() {
        user.validateResponseBody();
    }
}
