package api.regres.hooks;

import api.regres.config.Properties;
import api.regres.steps.APISteps;
import io.cucumber.java.Before;

public class Setup {
    private static Properties properties = Properties.properties;

    @Before
    public static void setBaseUri() {
        APISteps.setRequestSpecificationBaseUri(properties.baseURL());
    }
}
