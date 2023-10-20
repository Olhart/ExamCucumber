package api.rickandmorty.steps;

import api.rickandmorty.steps.entity.PersonageResponse;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;

public class TestSteps {
    static PersonageResponse firstCharRes;
    static PersonageResponse lastCharFromLastEpisodeRes;

    @Когда("Отправили GET запрос и получили тело ответа с данными первого персонажа с ID {int}")
    public static void getCharacterByID(int id) {
        firstCharRes = new PersonageResponse("" + id);
    }

    @И("Отправили GET запрос и получили тело ответа с данными последнего персонажа из последнего эпизода с участием первого персонажа")
    public static void getLastCharFromLastEpisode() {
        lastCharFromLastEpisodeRes = new PersonageResponse(firstCharRes.getLastEpisode().getLastPersonage().getID());
    }

    @И("Сравнили расу и название текущих местоположений двух персонажей")
    public static void comparingCharactersLocations(){
        lastCharFromLastEpisodeRes.compareCurrLocationWith(firstCharRes);
        lastCharFromLastEpisodeRes.compareSpeciesWith(firstCharRes);
    }
}
