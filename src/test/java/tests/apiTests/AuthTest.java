package tests.apiTests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AuthTest {
    @BeforeAll
    static void setup() {
        RestAssured.filters(new AllureRestAssured());
        RestAssured.baseURI = "http://test-api.d6.dev.devcaz.com";
    }

    @Test
    void getGuestTokenAssured() {
        given()
                .contentType("application/json")
                .auth().preemptive().basic("front_2d6b0a8391742f5d789d7d915755e09e", "")
                .when()
                .body("{\n" +
                        "  \"grant_type\":\"client_credentials\",\n" +
                        "  \"scope\":\"guest:default\"\n" +
                        "}")
                .post("/v2/oauth2/token")
                .then()
                .log().body()
                .statusCode(200);
    }
}