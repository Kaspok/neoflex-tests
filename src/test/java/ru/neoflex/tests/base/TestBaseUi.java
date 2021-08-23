package ru.neoflex.tests.base;

import org.junit.jupiter.api.AfterEach;
import ru.neoflex.helpers.Attach;

public class TestBaseUi extends TestBase {

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
