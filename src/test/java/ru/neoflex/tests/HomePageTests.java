package ru.neoflex.tests;

import org.junit.jupiter.api.Test;
import ru.neoflex.pages.GeneralsBlocks;

import static com.codeborne.selenide.Selenide.open;

public class HomePageTests extends TestBase {

    private GeneralsBlocks generalsBlocks = new GeneralsBlocks();

    @Test
    void homePageShouldContains9Widgets() {
        open("");
        generalsBlocks.checkThatWidgetsDisplayed();

    }
}
