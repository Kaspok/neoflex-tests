package ru.neoflex.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.neoflex.data.MenuItem;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GeneralsBlocks {


    private SelenideElement allMenuItems = $(".navbar-wrapper");
    private SelenideElement widgets = allMenuItems.$(".navbar__list");

    private SelenideElement solutionsWidget = widgets.$(By.linkText(MenuItem.SOLUTIONS.getDisplayName()));
    private SelenideElement projectsWidget = widgets.$(By.linkText(MenuItem.PROJECTS.getDisplayName()));
    private SelenideElement expertiseWidget = widgets.$(By.linkText(MenuItem.EXPERTISE.getDisplayName()));
    private SelenideElement aboutCompanyWidget = widgets.$(By.linkText(MenuItem.ABOUT_COMPANY.getDisplayName()));
    private SelenideElement careerWidget = widgets.$(By.linkText(MenuItem.CAREER.getDisplayName()));
    private SelenideElement pressCenterWidget = widgets.$(By.linkText(MenuItem.PRESS_CENTER.getDisplayName()));
    private SelenideElement contactsWidget = widgets.$(By.linkText(MenuItem.CONTACTS.getDisplayName()));
    private SelenideElement languageWidget = allMenuItems.$(By.linkText(MenuItem.EN.getDisplayName()));
    private SelenideElement searchWidget = allMenuItems.$(".search");

    @Step("Проверяем, что все виджеты на верхней панели отображаются")
    public void checkThatWidgetsDisplayed() {
        solutionsWidget.shouldBe(visible);
        projectsWidget.shouldBe(visible);
        expertiseWidget.shouldBe(visible);
        aboutCompanyWidget.shouldBe(visible);
        careerWidget.shouldBe(visible);
        pressCenterWidget.shouldBe(visible);
        contactsWidget.shouldBe(visible);
        languageWidget.shouldBe(visible);
        searchWidget.shouldBe(visible);
    }


}
