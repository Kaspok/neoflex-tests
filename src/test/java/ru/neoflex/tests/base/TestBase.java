package ru.neoflex.tests.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.neoflex.ru/";
        Configuration.startMaximized = true;
    }
}
