package ru.neoflex.tests.base;

import io.restassured.specification.RequestSpecification;
import ru.neoflex.config.App;
import ru.neoflex.helpers.AllureRestAssuredFilter;

import static io.restassured.RestAssured.given;

public class TestBaseApi {

    private AllureRestAssuredFilter allureRestAssuredFilter = new AllureRestAssuredFilter();

    public RequestSpecification requestTypeText = given()
            .filter(allureRestAssuredFilter.withCustomTemplates())
            .baseUri(App.appConfig.apiUrl())
            .basePath("/api/v1")
            .contentType("text/plain");

}
