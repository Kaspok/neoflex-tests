package ru.neoflex.tests;

import org.junit.jupiter.api.Test;
import ru.neoflex.pages.GeneralsBlocks;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class HomePageTests extends TestBase {

    private final GeneralsBlocks generalsBlocks = new GeneralsBlocks();

    @Test
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
    void checkFooterContacts() {
        open("");
        generalsBlocks
                .checkFooterContacts()
                .buttonContactUsClickAndCheck();
    }

    @Test
    void checkPopUpListOfSolutionsButton() {
        open("");
        generalsBlocks
                .solutionsButtonPopUpList()
                .expertiseButtonPopUpList()
                .aboutCompanyButtonPopUpList();
    }
}
