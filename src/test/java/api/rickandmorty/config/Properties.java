package api.rickandmorty.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

@Config.Sources(value = {"file:src/test/resources/rick_and_morty/properties/application.properties"})
public interface Properties extends Reloadable {
    Properties properties = ConfigFactory.create(Properties.class);

    @Key("baseURI")
    String baseURI();
}