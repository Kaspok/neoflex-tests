package ru.neoflex.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.neoflex.data.MenuItem;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
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

    private SelenideElement allFooterContacts = $(".footer");
    private SelenideElement leftFooterContacts = allFooterContacts.$(".footer__contacts-wrapper");
    private SelenideElement centerFooterContacts = allFooterContacts.$(".footer__center");
    private SelenideElement rightFooterContacts = allFooterContacts.$(".footer__ppd");


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

    @Step("Проверяем контакты в нижней части страницы")
    public void checkFooterContacts() {
        leftFooterContacts.$(".footer__support").scrollTo()
                .shouldHave(exactTextCaseSensitive("Служба технической поддержки"));
        leftFooterContacts.$(".support-phone")
                .shouldHave(exactTextCaseSensitive("+7 (800) 100 77 28"));
        leftFooterContacts.$(".support-time")
                .shouldHave(exactTextCaseSensitive("круглосуточно"));
        leftFooterContacts.$(".copyright")
                .shouldHave(exactTextCaseSensitive("© 2021 Neoflex. Все права защищены"));

        centerFooterContacts.$(".base-button")
                .shouldHave(exactTextCaseSensitive("Связаться с нами"));
        centerFooterContacts.$(".footer__phone")
                .shouldHave(exactTextCaseSensitive("+7 (495) 984 25 13"));
        centerFooterContacts.$(".footer__email")
                .shouldHave(exactTextCaseSensitive("info@neoflex.ru"));
        centerFooterContacts.$(".social-link").shouldBe(visible);

        rightFooterContacts.$(".address-title")
                .shouldHave(exactTextCaseSensitive("Адрес"));
        rightFooterContacts.$(".footer__address")
                .shouldHave(exactTextCaseSensitive("127015, Москва, ул. Вятская, д. 35, стр. 4, 1 подъезд, 2 этаж"));
        rightFooterContacts.$(".policy-ppd")
                .shouldHave(exactTextCaseSensitive("Политика обработки персональных данных"));
        rightFooterContacts.$(".consent-ppd")
                .shouldHave(exactTextCaseSensitive("Согласие на обработку персональных данных"));
    }

}
