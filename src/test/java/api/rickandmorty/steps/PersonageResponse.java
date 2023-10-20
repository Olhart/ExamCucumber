package api.rickandmorty.steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

import static api.rickandmorty.steps.APISteps.*;
import static api.common.steps.CommonAssertSteps.assertThatEqualTo;
import static api.rickandmorty.steps.ParseJSONSteps.*;

public class PersonageResponse {
    private JSONObject jsonObject;
    private Response response;
    final private String ID;

    public PersonageResponse(String id) {
        ID = id;
        response = getCharacterResponse(id);
        jsonObject = getJSONFromResponse(response);
    }
    @Step("Получить текущее местоположение персонажа с ID={this.ID}")
    public String getCurrLocationName() {
        return getCharCurrLocationName(jsonObject);
    }

    @Step("Получить расу персонажа с ID={this.ID}")
    public String getSpecies() {
            return getCharSpecies(jsonObject);
    }

    public String getID() {
        return ID;
    }

    public EpisodeResponse getLastEpisode() {
        return new EpisodeResponse(getLastEpisodeIDWithCharacter(jsonObject));
    }


    @Step("Сравнить текущее местоположение персонажа с ID={this.ID} и персонажа с ID={AnotherChar.ID}")
    public void compareCurrLocationWith(PersonageResponse AnotherChar) {
        String currLocationThisChar = this.getCurrLocationName();
        String currLocationAnotherChar = AnotherChar.getCurrLocationName();

        String msg = String.format("Текущее местоположение персонажей не совпадают: " +
                "\nТекущее местоположение персонажа с ID=%s: %s" +
                "\nТекущее местоположение персонажа с ID=%s: %s",
                this.ID, currLocationThisChar, AnotherChar.ID, currLocationAnotherChar);

        assertThatEqualTo(currLocationThisChar, currLocationAnotherChar, msg);

    }

    @Step("Сравнить расу персонажа с ID={this.ID} и персонажа с ID={AnotherChar.ID}")
    public void compareSpeciesWith(PersonageResponse AnotherChar) {
        String speciesThisChar = this.getCurrLocationName();
        String speciesLocationAnotherChar = AnotherChar.getCurrLocationName();

        String msg = String.format("Расы персонажей не совпадают: " +
                        "\nРаса персонажа с ID=%s: %s" +
                        "\nРаса персонажа с ID=%s: %s",
                this.ID, speciesThisChar, AnotherChar.ID, speciesLocationAnotherChar);

        assertThatEqualTo(speciesThisChar, speciesLocationAnotherChar, msg);
    }
}
