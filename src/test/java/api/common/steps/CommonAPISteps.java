package api.common.steps;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CommonAPISteps {
    public static RequestSpecification requestSpecification;

    @Step("Задать Request спецификацию c базовым URI \"{baseUri}\"")
    public static void setRequestSpecificationBaseUri(String baseUri) {
        requestSpecification = given()
                .baseUri(baseUri)
                .filter(new AllureRestAssured());
    }

    @Step("Получить JSON-объект из тела ответа (Response объект)")
    public static JSONObject getJSONFromResponse(Response response) {
        return new JSONObject(response.getBody().asString());
    }

}