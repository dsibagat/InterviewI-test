package spec;


import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Specifications {

    public static RequestSpecification request(String body) {
        return given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body(body);
    }
}