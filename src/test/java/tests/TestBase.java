package tests;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://test-api.d6.dev.devcaz.com";
        Configuration.baseUrl = "http://test-app.d6.dev.devcaz.com";
    }
}