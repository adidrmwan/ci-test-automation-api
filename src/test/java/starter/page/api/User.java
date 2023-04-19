package starter.page.api;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class User {

    public String endpoint = "https://reqres.in/api/users";

    @Step("I set GET api endpoints")
    public String setApiEndpoint() {
        return endpoint + "/2";
    }

    @Step("I send GET HTTP request")
    public void sendGetHttpRequest() {
        SerenityRest.given().get(setApiEndpoint());
    }

    @Step("I receive valid HTTP response code 200")
    public void validateHttpResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("i validate response body")
    public void validateResponseBody() {
        restAssuredThat(response -> response.body("data.id", equalTo(2)));
        restAssuredThat(response -> response.body("data.email", equalTo("janet.weaver@reqres.in")));
        restAssuredThat(response -> response.body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!")));
    }
}
