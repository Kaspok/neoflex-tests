package ru.neoflex.tests;

import org.junit.jupiter.api.*;
import ru.neoflex.data.MenuItem;
import ru.neoflex.helpers.TopBar;
import ru.neoflex.pages.GeneralsBlocks;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("UI тесты")
public class PageTests extends TestBase {

    private final GeneralsBlocks generalsBlocks = new GeneralsBlocks();
    private final TopBar topBar = new TopBar();

    @Test
    @Order(1)
    @DisplayName("Проверка заголовка начальной страницы, проверка наличия панели навигации")
    void homePageShouldContains9Widgets() {
        final String homeGreeting = "Помогаем бизнесу получать устойчивые конкурентные преимущества в цифровую эпоху";
        open("");
        step("Проверяем, что верхнее описание содержит текст: Помогаем бизнесу получать устойчивые " +
                "конкурентные преимущества в цифровую эпоху", () -> {
            $(".home-greeting").$(".home-greeting__title").shouldHave(exactTextCaseSensitive(homeGreeting));
        });
        generalsBlocks.checkThatWidgetsDisplayed();
    }

    @Test
    @Order(2)
    @DisplayName("Проверка контактов в конце страницы, проверка формы 'Связаться с нами'")
    void checkFooterContacts() {
        open("");
        generalsBlocks
                .checkFooterContacts()
                .buttonContactUsClickAndCheck();
    }

    @Test
    @Order(3)
    @DisplayName("Проверка всплывающих окон у пунктов 'Решения','Экспертиза''О компании'")
    void checkPopUpListOfSolutionsButton() {
        open("");
        generalsBlocks
                .solutionsButtonPopUpList()
                .expertiseButtonPopUpList()
                .aboutCompanyButtonPopUpList();
    }

    @Test
    @Order(4)
    @DisplayName("Переход в пункт 'Решения'. Проверка заголовка страницы")
    void checkTitleOfTheSolutionItem() {
        open("");
        topBar.navigateTo(MenuItem.SOLUTIONS);
        step("Проверяем, что заголовок страницы имеет наименование 'Решения'", () -> {
            $(".base-typography_headline")
                    .shouldHave(exactTextCaseSensitive(MenuItem.SOLUTIONS.getDisplayName()));
        });
    }

    @Test
    @Order(5)
    @DisplayName("Переход в пункт 'Проекты'. Проверка заголовка страницы")
    void checkTitleOfTheProjectsItem() {
        open("");
        topBar.navigateTo(MenuItem.PROJECTS);
        step("Проверяем, что заголовок страницы имеет наименование 'Проекты'", () -> {
            $(".base-typography_headline")
                    .shouldHave(exactTextCaseSensitive(MenuItem.PROJECTS.getDisplayName()));
        });
    }

    @Test
    @Order(6)
    @DisplayName("Переход в пункт 'Экспертиза'. Проверка заголовка страницы")
    void checkTitleOfTheExpertiseItem() {
        open("");
        topBar.navigateTo(MenuItem.EXPERTISE);
        step("Проверяем, что заголовок страницы имеет наименование 'Экспертиза'", () -> {
            $(".base-typography_headline")
                    .shouldHave(exactTextCaseSensitive(MenuItem.EXPERTISE.getDisplayName()));
        });
    }

    @Test
    @Order(6)
    @DisplayName("Переход в пункт 'О компании'. Проверка заголовка страницы")
    void checkTitleOfTheAboutCompanyItem() {
        open("");
        topBar.navigateTo(MenuItem.ABOUT_COMPANY);
        step("Проверяем, что заголовок страницы имеет наименование 'Экспертиза'", () -> {
            $(".base-typography_headline")
                    .shouldHave(exactTextCaseSensitive(MenuItem.ABOUT_COMPANY.getDisplayName()));
        });
    }
}
