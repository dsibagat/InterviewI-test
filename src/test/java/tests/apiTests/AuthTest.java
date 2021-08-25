package tests.apiTests;

import config.ConfigHelper;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class AuthTest {

    @Test
    void pushXMLToTrialMax2() {
        String divisionId = "852",
                deviceProvider = "Transactional Signant-Health public",
                activityName = "TrialMax";

        given()
                .contentType(ContentType.XML)
                .header("Authorization", ConfigHelper.getToken())
                .body()
                .when()
                .post("?lifecycle=Development&divisionId=" + divisionId +
                        "&Area=Landing%20US&deviceprovider=" + deviceProvider + "&activityName=" + activityName)
                .then()
                .log().body()
                .statusCode(200)
                .body("status", is(notNullValue()));
    }
}

}
