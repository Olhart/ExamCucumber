package api.regres.steps;

import api.regres.config.Properties;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static api.common.steps.CommonAPISteps.getJSONFromResponse;
import static api.regres.steps.APISteps.createNewUserAndGetResponce;
import static api.regres.steps.APISteps.setBodyOfRequest;
import static api.regres.steps.AssertSteps.*;
import static api.regres.steps.ParseJSONSteps.getJSONObjFromFile;

public class TestSteps {
    private static Properties properties = Properties.properties;
    private static JSONObject requestBodyJSON;

    private static Response response;

    @Дано("Подготовить тело запроса из ранее созданного файла, поменяв \"name\" и добавив поле \"Job\"")
    public static void getJSONByParsingFileAndChangeData(DataTable arg) throws IOException {
        requestBodyJSON = getJSONObjFromFile(properties.jsonFileName());

        List<Map<String, String>> table = arg.asMaps(String.class, String.class);

        for (Map<String, String> map : table) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                requestBodyJSON.put(entry.getKey(), entry.getValue());
            }
        }
        setBodyOfRequest(requestBodyJSON);
    }

    @Затем("Выполнить POST запрос на создание пользователя")
    public static void createNewUser() {
        response = createNewUserAndGetResponce();
    }

    @Тогда("Код статуса ответа должен быть {int}")
    public static void checkStatusCode(int statusCode) {
        resStatusCodeEqual(response, statusCode);
    }

    @И("Проверить валидность возвращенных данных")
    public static void validateDataFromResponse() {
        JSONObject responseBodyJSON = getJSONFromResponse(response);

        for (String key : requestBodyJSON.keySet()) {
            assertThatEntryEqualTo(responseBodyJSON, key, requestBodyJSON.get(key).toString());
        }

        validateID(responseBodyJSON);
        validateCreateAt(responseBodyJSON);
    }
}
