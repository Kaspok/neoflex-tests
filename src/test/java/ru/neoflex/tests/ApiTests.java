package ru.neoflex.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.neoflex.helpers.ReadTxtFiles;
import ru.neoflex.tests.base.TestBaseApi;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("API тесты")
public class ApiTests extends TestBaseApi {

    private ReadTxtFiles readTxtFile = new ReadTxtFiles();

    @Test
    void getProjectsItemTest() {
        step("Проверка информации о проектах во вкладке `Проекты`", () -> {
            String s = TestBaseApi.requestTypeText
                    .when()
                    .body("offset=1&count=10&lang=ru")
                    .get("/main/projects")
                    .then()
                    .statusCode(200)
                    .extract().response().body().asString();
            assertThat(s).contains(readTxtFile.read("src/test/resources/ProjectsItemRawJson.txt"));
        });
    }

    @Test
    void getExpertiseItemTest() {
        step("Проверка информации о проектах во вкладке `Экспертиза`", () -> {
            String s = TestBaseApi.requestTypeText
                    .when()
                    .queryParam("offset", "1")
                    .queryParam("count", "14")
                    .queryParam("lang", "ru")
                    .get("/expertises")
                    .then()
                    .statusCode(200)
                    .extract().response().body().asString();
            assertThat(s).contains(readTxtFile.read("src/test/resources/ExpertiseItemRawJson.txt"));
        });
    }
}
