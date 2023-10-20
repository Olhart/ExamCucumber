package api.regres.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

@Config.Sources(value = {"file:src/test/resources/regres/properties/application.properties"})
public interface Properties extends Reloadable {
    Properties properties = ConfigFactory.create(Properties.class);

    @Key("baseURL")
    String baseURL();

    @Key("jsonfile.name")
    String jsonFileName();
}