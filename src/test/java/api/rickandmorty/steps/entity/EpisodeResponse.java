package api.rickandmorty.steps.entity;

import io.restassured.response.Response;
import org.json.JSONObject;

import static api.rickandmorty.steps.APISteps.*;
import static api.rickandmorty.steps.ParseJSONSteps.getLastCharIDFromEpisode;

public class EpisodeResponse {
    private JSONObject jsonObject;
    private Response response;

    public EpisodeResponse(String id) {
        response = getEpisodeResponse(id);
        jsonObject = getJSONFromResponse(response);
    }

    public PersonageResponse getLastPersonage() {
        return new PersonageResponse(getLastCharIDFromEpisode(jsonObject));
    }
}
