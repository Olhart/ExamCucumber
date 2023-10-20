package api.regres.steps;

import api.common.steps.CommonAssertSteps;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.util.Date;

import static api.regres.steps.ParseJSONSteps.*;
import static api.regres.utils.DateParser.parseDataFromString;


public class AssertSteps extends CommonAssertSteps {
    @Step("Проверить, что код статус ответа = {expectedStatusCode}")
    public static void resStatusCodeEqual(Response response, int expectedStatusCode){
        int statusCode = response.getStatusCode();
        String msg = String.format("Код статуса ответа не соответствует ожидаемому:" +
                        "\nожидается %s: получен: %s",
                expectedStatusCode, statusCode);

        assertThatEqualTo(expectedStatusCode, statusCode, msg);
    }

    @Step("Проверить, совпадает ли значение по ключу \"{key}\" с переданным значением {expected} в теле ответа")
    public static void assertThatEntryEqualTo(JSONObject jsonObject, String key, String expected){
        String actual = getValueFromJSONByKey(jsonObject, key);
        String msg = String.format("Значение в теле ответа по ключу %s не соответствует ожидаемому:" +
                        "\nожидается %s: получен: %s",
                key, expected, actual);

        assertThatEqualTo(expected, actual, msg);
    }

    @Step("Проверить валидность значения даты по ключу \"createdAt\" в теле ответа")
    public static void validateCreateAt(JSONObject jsonObject) {
        Date date = Assertions.assertDoesNotThrow(() -> parseDataFromString(getStrDateFromJSON(jsonObject)));
        Assertions.assertTrue(date.before(new Date()));
    }

    @Step("Проверить валидность значения ID по ключу \"id\" в теле ответа")
    public static void validateID(JSONObject jsonObject) {
        String strID = getStrIDFromJSON(jsonObject);
        int id = Assertions.assertDoesNotThrow(() -> Integer.parseInt(strID));
        Assertions.assertTrue(id > -1);
    }
}
