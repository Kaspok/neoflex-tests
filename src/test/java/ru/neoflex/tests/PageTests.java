package ru.neoflex.tests;

import org.junit.jupiter.api.*;
import ru.neoflex.config.App;
import ru.neoflex.data.MenuItem;
import ru.neoflex.helpers.TopBar;
import ru.neoflex.pages.GeneralsBlocks;
import ru.neoflex.tests.base.TestBaseUi;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("UI тесты")
public class PageTests extends TestBaseUi {

    private final GeneralsBlocks generalsBlocks = new GeneralsBlocks();
    private final TopBar topBar = new TopBar();

    @Test
    @Order(1)
    @DisplayName("Проверка заголовка начальной страницы, проверка наличия панели навигации")
    void homePageShouldContains9Widgets() {
        final String homeGreeting = "Помогаем бизнесу получать устойчивые конкурентные преимущества в цифровую эпоху";
        generalsBlocks
                .openPage(App.appConfig.webUrl())
                .checkThatWidgetsDisplayed();
        step("Проверяем, что верхнее описание содержит текст: Помогаем бизнесу получать устойчивые " +
                "конкурентные преимущества в цифровую эпоху", () -> {
            $(".home-greeting").$(".home-greeting__title").shouldHave(exactTextCaseSensitive(homeGreeting));
        });
    }

    @Test
    @Order(2)
    @DisplayName("Проверка контактов в конце страницы, проверка формы 'Связаться с нами'")
    void checkFooterContacts() {
        generalsBlocks
                .openPage(App.appConfig.webUrl())
                .checkFooterContacts()
                .buttonContactUsClickAndCheck();
    }

    @Test
    @Order(3)
    @DisplayName("Проверка всплывающих окон у пунктов 'Решения','Экспертиза''О компании'")
    void checkPopUpListOfSolutionsButton() {
        generalsBlocks
                .openPage(App.appConfig.webUrl())
                .solutionsButtonPopUpList()
                .expertiseButtonPopUpList()
                .aboutCompanyButtonPopUpList();
    }

    @Test
    @Order(4)
    @DisplayName("Переход в пункт 'Решения'. Проверка заголовка страницы")
    void checkTitleOfTheSolutionItem() {
        generalsBlocks.openPage(App.appConfig.webUrl());
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
        generalsBlocks.openPage(App.appConfig.webUrl());
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
        generalsBlocks.openPage(App.appConfig.webUrl());
        topBar.navigateTo(MenuItem.EXPERTISE);
        step("Проверяем, что заголовок страницы имеет наименование 'Экспертиза'", () -> {
            $(".base-typography_headline")
                    .shouldHave(exactTextCaseSensitive(MenuItem.EXPERTISE.getDisplayName()));
        });
    }

    @Test
    @Order(7)
    @DisplayName("Переход в пункт 'О компании'. Проверка заголовка страницы")
    void checkTitleOfTheAboutCompanyItem() {
        generalsBlocks.openPage(App.appConfig.webUrl());
        topBar.navigateTo(MenuItem.ABOUT_COMPANY);
        step("Проверяем, что заголовок страницы имеет наименование 'Экспертиза'", () -> {
            $(".base-typography_headline")
                    .shouldHave(exactTextCaseSensitive(MenuItem.ABOUT_COMPANY.getDisplayName()));
        });
    }
}
