package api;

import config.ConfigHelper;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Auth {
    public Map<String, String> login() {
        return
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .formParam("Email", ConfigHelper.getUsername())
                        .formParam("Password", ConfigHelper.getPassword())
                        .when()
                        .post("/login")
                        .then()
                        .statusCode(302)
                        .log().body()
                        .extract().cookies();
    }
}