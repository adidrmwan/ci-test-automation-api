package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.page.LoginPage;

public class LoginSteps {
    @Steps
    LoginPage loginPage;

    @Given("user on login page")
    public void userOnLoginPage() {
        loginPage.userOnloginPage();
    }

    @When("user input invalid username")
    public void userInputInvalidUsername() {
        System.out.println("input invalid username");
    }

    @And("user input valid password")
    public void userInputValidPassword() {
        System.out.println("input valid username");
    }

    @And("user click login button")
    public void userClickLoginButton() {
        System.out.println("click login button");
    }

    @Then("user see error message")
    public void userSeeErrorMessage() {
        System.out.println("see error message");
    }
}
