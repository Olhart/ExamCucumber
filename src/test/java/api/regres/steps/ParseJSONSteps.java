package api.regres.steps;

import io.qameta.allure.Step;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

public class ParseJSONSteps {

    @Step("Получить JSON-объект из файла {fileName}")
    public static JSONObject getJSONObjFromFile(String fileName) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get("src", "test", "resources", "regres", fileName)));
        JSONObject jsonObject = new JSONObject(text);
        return jsonObject;
    }

    @Step("Получить строковое представление даты (\"createdAt\" из JSON-объекта")
    public static String getStrDateFromJSON(JSONObject jsonObject) {
        return jsonObject.get("createdAt").toString().trim();
    }
    @Step("Получить строку ID (\"id\") из JSON-объекта")
    public static String getStrIDFromJSON(JSONObject jsonObject) {
        return jsonObject.get("id").toString();
    }

    @Step("Получить строковое значение по ключу \"{key}\" из JSON-объекта")
    public static String getValueFromJSONByKey(JSONObject jsonObject, String key) {
        return jsonObject.get(key).toString();
    }
}
