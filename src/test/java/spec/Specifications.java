package spec;


import api.Auth;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Specifications {

    public static RequestSpecification request(String body) {
        Map<String, String> cookies = new Auth().login();
        return given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookies(cookies)
                .body(body);
    }
}