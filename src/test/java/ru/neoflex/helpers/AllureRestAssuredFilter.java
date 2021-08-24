package ru.neoflex.helpers;

import io.qameta.allure.restassured.AllureRestAssured;

public class AllureRestAssuredFilter {

    private final AllureRestAssured FILTER = new AllureRestAssured();

    public AllureRestAssured withCustomTemplates() {
        FILTER.setRequestTemplate("http-request.ftl");
        FILTER.setResponseTemplate("http-response.ftl");
        return FILTER;
    }
}
