package ru.neoflex.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import ru.neoflex.data.AboutCompanyItem;
import ru.neoflex.data.ExpertiseItem;
import ru.neoflex.data.MenuItem;
import ru.neoflex.data.SolutionsItem;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GeneralsBlocks {


    private final SelenideElement allMenuItems = $(".navbar-wrapper");
    private final SelenideElement widgets = allMenuItems.$(".navbar__list");

    private final SelenideElement solutionsWidget = widgets.$(By.linkText(MenuItem.SOLUTIONS.getDisplayName()));
    private final SelenideElement projectsWidget = widgets.$(By.linkText(MenuItem.PROJECTS.getDisplayName()));
    private final SelenideElement expertiseWidget = widgets.$(By.linkText(MenuItem.EXPERTISE.getDisplayName()));
    private final SelenideElement aboutCompanyWidget = widgets.$(By.linkText(MenuItem.ABOUT_COMPANY.getDisplayName()));
    private final SelenideElement careerWidget = widgets.$(By.linkText(MenuItem.CAREER.getDisplayName()));
    private final SelenideElement pressCenterWidget = widgets.$(By.linkText(MenuItem.PRESS_CENTER.getDisplayName()));
    private final SelenideElement contactsWidget = widgets.$(By.linkText(MenuItem.CONTACTS.getDisplayName()));
    private final SelenideElement languageWidget = allMenuItems.$(By.linkText(MenuItem.EN.getDisplayName()));
    private final SelenideElement searchWidget = allMenuItems.$(".search");

    private final SelenideElement allFooterContacts = $(".footer");
    private final SelenideElement leftFooterContacts = allFooterContacts.$(".footer__contacts-wrapper");
    private final SelenideElement centerFooterContacts = allFooterContacts.$(".footer__center");
    private final SelenideElement rightFooterContacts = allFooterContacts.$(".footer__ppd");

    @Step("Открываем страницу - {page}")
    public GeneralsBlocks openPage(String page) {
        open(page);
        return this;
    }

    @Step("Проверяем, что все виджеты на верхней панели отображаются")
    public GeneralsBlocks checkThatWidgetsDisplayed() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        solutionsWidget.shouldBe(visible);
        projectsWidget.shouldBe(visible);
        expertiseWidget.shouldBe(visible);
        aboutCompanyWidget.shouldBe(visible);
        careerWidget.shouldBe(visible);
        pressCenterWidget.shouldBe(visible);
        contactsWidget.shouldBe(visible);
        languageWidget.shouldBe(visible);
        searchWidget.shouldBe(visible);
        return this;
    }

    @Step("Проверяем контакты в нижней части страницы")
    public GeneralsBlocks checkFooterContacts() {
        SelenideLogger.addListener("allure", new AllureSelenide());
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
        return this;
    }


    @Step("Проверка открывшегося окна, после нажатия кнопки 'Связаться с нами'")
    public GeneralsBlocks buttonContactUsClickAndCheck() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        SelenideElement contactUs = $(".feedback-modal__form");
        centerFooterContacts.$(".base-button").click();
        $(".feedback-modal__headline").shouldHave(exactTextCaseSensitive("Связаться с нами"));
        contactUs.$("[for=feedbackFIO]").shouldHave(exactTextCaseSensitive("ФИО"));
        contactUs.$("[for=feedbackTel]").shouldHave(exactTextCaseSensitive("Телефон"));
        contactUs.$("[for=feedbackEmail]").shouldHave(exactTextCaseSensitive("Email"));
        contactUs.$("[for=feedbackComment]").shouldHave(exactTextCaseSensitive("Комментарий"));
        contactUs.$("[for=feedbackCheck]")
                .shouldHave(exactTextCaseSensitive("Отправляя свои данные через эту форму, я принимаю условия " +
                        "соглашения об обработке персональных данных"));
        contactUs.$(".base-button").shouldHave(exactTextCaseSensitive("Отправить"));
        return this;
    }

    @Step("Проверяем содержимое всплывающего окна у пункта 'Решения'")
    public GeneralsBlocks solutionsButtonPopUpList() {
        SelenideElement solutionPopUp = $(".navbar__sub");
        SelenideLogger.addListener("allure", new AllureSelenide());
        solutionsWidget.hover();
        solutionPopUp.shouldHave(text(SolutionsItem.OPEN_API.getDisplayName()));
        solutionPopUp.shouldHave(text(SolutionsItem.ENTERPRISE_DATA_LAKE.getDisplayName()));
        solutionPopUp.shouldHave(text(SolutionsItem.REMOTE_BANKING_SERVICES.getDisplayName()));
        solutionPopUp.shouldHave(text(SolutionsItem.LOAN_ORIGINATION_AND_CREDIT_SCORING.getDisplayName()));
        solutionPopUp.shouldHave(text(SolutionsItem.REGULATORY_REPORTING.getDisplayName()));
        solutionPopUp.shouldHave(text(SolutionsItem.APPLICATION_INTEGRATION.getDisplayName()));
        solutionPopUp.shouldHave(text(SolutionsItem.ACTIVE_ARCHIVE.getDisplayName()));
        solutionPopUp.shouldHave(text(SolutionsItem.TRANSPORTATION_MANAGEMENT.getDisplayName()));
        solutionPopUp.shouldHave(text(SolutionsItem.KNOW_YOUR_CUSTOMER.getDisplayName()));
        solutionPopUp.shouldHave(text(SolutionsItem.TREASURY_AUTOMATION.getDisplayName()));
        solutionPopUp.shouldHave(text(SolutionsItem.RISK_MANAGEMENT.getDisplayName()));
        solutionPopUp.shouldHave(text(SolutionsItem.AUTOMATION_OF_IFRS9_REQUIREMENTS.getDisplayName()));
        solutionPopUp.shouldHave(text(SolutionsItem.SERVICING_AND_LENDING.getDisplayName()));
        solutionPopUp.shouldHave(text(SolutionsItem.SECURITY_OPERATIONS_CENTER.getDisplayName()));
        solutionPopUp.shouldHave(text(SolutionsItem.NEOFLEX_LOAN_BUREAU_VAS.getDisplayName()));
        return this;
    }

    @Step("Проверяем содержимое всплывающего окна у пункта 'Экспертиза'")
    public GeneralsBlocks expertiseButtonPopUpList() {
        SelenideElement expertisePopUp = $(".navbar__sub", 1);
        SelenideLogger.addListener("allure", new AllureSelenide());
        expertiseWidget.hover();
        expertisePopUp.shouldHave(text(ExpertiseItem.FAST_DATA.getDisplayName()));
        expertisePopUp.shouldHave(text(ExpertiseItem.MICROSERVICES.getDisplayName()));
        expertisePopUp.shouldHave(text(ExpertiseItem.DEVOPS.getDisplayName()));
        expertisePopUp.shouldHave(text(ExpertiseItem.DATA_SCIENCE.getDisplayName()));
        expertisePopUp.shouldHave(text(ExpertiseItem.MLOPS.getDisplayName()));
        expertisePopUp.shouldHave(text(ExpertiseItem.BIG_DATA.getDisplayName()));
        expertisePopUp.shouldHave(text(ExpertiseItem.UX_UI.getDisplayName()));
        expertisePopUp.shouldHave(text(ExpertiseItem.SUITECRM.getDisplayName()));
        expertisePopUp.shouldHave(text(ExpertiseItem.SITE_RELIABILITY_ENGINEERING.getDisplayName()));
        expertisePopUp.shouldHave(text(ExpertiseItem.CLOUD_SERVICES.getDisplayName()));
        expertisePopUp.shouldHave(text(ExpertiseItem.NEOFLEX_MSA_PLATFORM.getDisplayName()));
        expertisePopUp.shouldHave(text(ExpertiseItem.NEOFLEX_DATAGRAM.getDisplayName()));
        expertisePopUp.shouldHave(text(ExpertiseItem.CUSTOM_SOFTWARE_DEVELOPMENT.getDisplayName()));
        return this;
    }

    @Step("Проверяем содержимое всплывающего окна у пункта 'О компании'")
    public GeneralsBlocks aboutCompanyButtonPopUpList() {
        SelenideElement aboutCompanyPopUp = $(".navbar__sub", 2);
        SelenideLogger.addListener("allure", new AllureSelenide());
        aboutCompanyWidget.hover();
        aboutCompanyPopUp.shouldHave(text(AboutCompanyItem.ABOUT_COMPANY_ITEM.getDisplayName()));
        aboutCompanyPopUp.shouldHave(text(AboutCompanyItem.MANAGEMENT.getDisplayName()));
        aboutCompanyPopUp.shouldHave(text(AboutCompanyItem.HISTORY.getDisplayName()));
        aboutCompanyPopUp.shouldHave(text(AboutCompanyItem.PARTNERS.getDisplayName()));
        aboutCompanyPopUp.shouldHave(text(AboutCompanyItem.CLIENTS.getDisplayName()));
        return this;
    }
}
