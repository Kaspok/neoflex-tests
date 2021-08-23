package ru.neoflex.tests.base;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;

public class TestBaseApi {

    public static RequestSpecification requestTypeText = with()
            .baseUri("https://www.neoflex.ru")
            .basePath("/api/v1")
            .contentType("text/plain");
}
