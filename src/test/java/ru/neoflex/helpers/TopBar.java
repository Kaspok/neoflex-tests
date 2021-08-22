package ru.neoflex.helpers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.neoflex.data.MenuItem;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TopBar {

    private SelenideElement topBar = $(".navbar-wrapper").$(".navbar__list");

    @Step("Переходим на вкладку `{menuItem}`")
    public void navigateTo(MenuItem menuItem) {
        topBar.$(byText(menuItem.getDisplayName())).click();
    }
}
