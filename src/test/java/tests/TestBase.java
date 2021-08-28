package tests;

import com.codeborne.selenide.Configuration;
import config.ConfigHelper;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        Configuration.baseUrl = ConfigHelper.getWebUrl();
        RestAssured.baseURI = ConfigHelper.getWebUri();
        Configuration.startMaximized = true;
    }
}
