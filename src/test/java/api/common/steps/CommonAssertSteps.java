package api.common.steps;

import api.rickandmorty.steps.entity.PersonageResponse;
import io.qameta.allure.Step;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class CommonAssertSteps {

    protected static final Logger logger = LogManager.getLogger(PersonageResponse.class);
    @Step("Сравнить на равенство значения \"{expected}\" и \"{actual}\"")
    public static void assertThatEqualTo(String expected, String actual, String msg) {
        try {
            Assertions.assertEquals(expected, actual, msg);
        }
        catch (AssertionError e) {
            logger.log(Level.ERROR, e.getMessage());
            throw e;
        }
    }

    @Step("Сравнить на равенство значения \"{expected}\" и \"{actual}\"")
    public static void assertThatEqualTo(int expected, int actual, String msg) {
        try {
            Assertions.assertEquals(expected, actual, msg);
        }
        catch (AssertionError e) {
            logger.log(Level.ERROR, e.getMessage());
            throw e;
        }
    }
}
