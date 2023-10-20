package api.rickandmorty.steps;

import api.common.steps.CommonAPISteps;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class APISteps extends CommonAPISteps {

    @Step("Получить Response-объект персонажа с ID={characterID}")
    public static Response getCharacterResponse(String characterID) {
        return getResponseFromGetRequest("character/" + characterID);
    }

    @Step("Получить Response-объект, путем отправки GET запроса на endpoint \"{endpoint}\"")
    public static Response getResponseFromGetRequest(String endpoint) {
        return requestSpecification.when().get(endpoint);
    }
    @Step("Получить Response-объект эпизода с ID={episodeID}")
    public static Response getEpisodeResponse(String episodeID) {
        return getResponseFromGetRequest("episode/" + episodeID);
    }

}