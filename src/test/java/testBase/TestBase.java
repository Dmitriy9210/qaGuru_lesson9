package testBase;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelper.configureSelenide;
import static helpers.DriverHelper.getConsoleLogs;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
    public class TestBase {
        @BeforeAll
        public static void beforeAll() { // работаем с DriverHelper
            configureSelenide();
            SelenideLogger.addListener("allure", new AllureSelenide()
                    .savePageSource(true)
                    .screenshots(true));
        }

        @AfterEach
        public void afterEach() { // работаем с AttachmentHelper
            attachScreenshot("Last screenshot");
            attachPageSource();
            attachAsText("Browser console logs", getConsoleLogs());
            closeWebDriver();
        }

}

