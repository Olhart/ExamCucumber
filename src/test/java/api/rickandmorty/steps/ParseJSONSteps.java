package api.rickandmorty.steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJSONSteps {
    @Step("Получить значение по ключу \"name\" подоъекта \"location\" JSON-объекта тела ответа")
    public static String getCharCurrLocationName(JSONObject JSONResBody) {
        return JSONResBody.getJSONObject("location").get("name").toString();
    }

    @Step("Получить значение по ключу \"species\" JSON-объекта тела ответа")
    public static String getCharSpecies(JSONObject JSONResBody) {
        return JSONResBody.get("species").toString();
    }

    @Step("Получить число из последнего значение массива \"characters\" JSON-объекта тела ответа")
    public static String getLastCharIDFromEpisode(JSONObject EpisodeJSON) {
        JSONArray characterJSONArray = EpisodeJSON.getJSONArray("characters");
        return characterJSONArray.get(characterJSONArray.length() - 1).toString().replaceAll("[^0-9]", "");
    }

    @Step("Получить число из последнего значение массива \"episode\" JSON-объекта тела ответа")
    public static String getLastEpisodeIDWithCharacter(JSONObject CharacterJSON) {
        JSONArray episodeJSONArray = CharacterJSON.getJSONArray("episode");
        return episodeJSONArray.get(episodeJSONArray.length() - 1).toString().replaceAll("[^0-9]", "");
    }
}
