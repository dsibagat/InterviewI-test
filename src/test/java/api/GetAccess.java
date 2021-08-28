package api;

import tests.TestBase;

import static io.restassured.RestAssured.given;

public class GetAccess extends TestBase {

    public static String getGuestToken() {

        return given()
                .contentType("application/json; charset=UTF-8")
                .auth().preemptive().basic("front_2d6b0a8391742f5d789d7d915755e09e", "")
                .when()
                .body("{\n" +
                        "  \"grant_type\":\"client_credentials\",\n" +
                        "  \"scope\":\"guest:default\"\n" +
                        "}")
                .post("/v2/oauth2/token")
                .then()
                .log().body()
                .statusCode(200)
                .extract().path("access_token").toString();
    }

    public static String playerToken() {

        return given()
                .contentType("application/json; charset=UTF-8")
                .auth().preemptive().basic("front_2d6b0a8391742f5d789d7d915755e09e", "")
                .when()
                .log().all()
                .body("{\n" +
                        " \"grant_type\":\"password\",\n" +
                        " \"username\":\"ji.daniel1\",\n" +
                        " \"password\":\"H1rVr[-]=[-]=\"\n" +
                        "}")
                .post("/v2/oauth2/token")
                .then()
                .statusCode(200)
                .extract().path("access_token").toString();
    }
}

