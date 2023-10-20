package api.rickandmorty.hooks;

import api.rickandmorty.config.Properties;
import api.rickandmorty.steps.APISteps;
import io.cucumber.java.Before;

public class Setup {
    private static Properties properties = Properties.properties;

    @Before()
    public static void setBaseUri() {
        APISteps.setRequestSpecificationBaseUri(properties.baseURI());
    }
}
