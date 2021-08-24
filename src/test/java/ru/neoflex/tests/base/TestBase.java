package ru.neoflex.tests.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import ru.neoflex.config.App;
import ru.neoflex.helpers.DriverSettings;

public class TestBase {

    @BeforeAll
    static void setUp() {
        DriverSettings.configure();
        RestAssured.baseURI = App.appConfig.apiUrl();
    }
}
