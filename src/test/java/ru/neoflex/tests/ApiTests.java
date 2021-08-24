package ru.neoflex.tests;

import org.junit.jupiter.api.*;
import ru.neoflex.helpers.ReadTxtFiles;
import ru.neoflex.tests.base.TestBaseApi;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("API тесты")
public class ApiTests extends TestBaseApi {

    private ReadTxtFiles readTxtFile = new ReadTxtFiles();
    private TestBaseApi testBaseApi = new TestBaseApi();


    @Test
    @Order(1)
    @DisplayName("Проверка информации о проектах во вкладке `Проекты`")
    void getProjectsItemTest() {
        String s = testBaseApi.requestTypeText
                .when()
                .body("offset=1&count=10&lang=ru")
                .get("/main/projects")
                .then()
                .statusCode(200)
                .extract().response().body().asString();

        assertThat(s).contains(readTxtFile.read("ProjectsItemRawJson.txt"));
    }

    @Test
    @Order(2)
    @DisplayName("Проверка информации об экспертизе во вкладке `Экспертиза`")
    void getExpertiseItemTest() {
        String s = testBaseApi.requestTypeText
                .when()
                .queryParam("offset", "1")
                .queryParam("count", "14")
                .queryParam("lang", "ru")
                .get("/expertises")
                .then()
                .statusCode(200)
                .extract().response().body().asString();

        assertThat(s).contains(readTxtFile.read("ExpertiseItemRawJson.txt"));
    }
}
