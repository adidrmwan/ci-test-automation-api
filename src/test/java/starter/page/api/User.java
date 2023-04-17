package starter.page.api;

import com.github.javafaker.Faker;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

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
        SerenityRest.given().queryParam("page",2).get(endpoint);
    }

    @Step("I receive valid HTTP response code 200")
    public void validateHttpResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I have endpoint post new user")
    public String setPostEndpoint() {
        return endpoint;
    }

    @Step("i send post new user")
    public void sendPostHttpRequest() {
        Faker faker = new Faker();
        String nama = faker.name().firstName();
        String job = faker.job().title();

        String body = "{\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        JSONObject reqBody = new JSONObject(body);

//        ======================POST======================
        SerenityRest.given().header("Authorization", "Bearer Token").body(reqBody.toString()).post(setPostEndpoint());
////        ======================PUT======================
//        SerenityRest.given().contentType("application/json").body(reqBody.toString()).put(setPostEndpoint());
////        ======================PATCH======================
//        SerenityRest.given().contentType("application/json").body(reqBody.toString()).patch(setPostEndpoint());
////        ======================DELETE======================
//        SerenityRest.given().delete(setPostEndpoint());
    }

    @Step("i see status code 201")
    public void validateHttpResponseCode201() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("i validate response body")
    public void validateResponseBody() {
        restAssuredThat(response -> response.body("data[0].id", equalTo(7)));
        restAssuredThat(response -> response.body("data[0].email", equalTo("michael.lawson@reqres.in")));
    }
}
