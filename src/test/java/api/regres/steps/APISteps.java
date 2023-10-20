package api.regres.steps;

import api.common.steps.CommonAPISteps;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

public class APISteps extends CommonAPISteps {

    @Step("Создать нового пользователя POST-запросом на endpoint \"api/users\" и получить ответ")
    public static Response createNewUserAndGetResponce() {
        return requestSpecification.when().post("api/users");
    }

    @Step("Передать данные в тело запроса: {requestBodyJSON}")
    public static void setBodyOfRequest(JSONObject jsonObject) {
        requestSpecification
                .contentType("application/json")
                .with().body(jsonObject.toString());
    }
}
