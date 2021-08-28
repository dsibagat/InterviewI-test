package tests.apiTests;

import api.GetAccess;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class PlayerApiTest extends TestBase {

    @Description("Получаем гостевой токен")
    @Test
    public void guestToken() {
        GetAccess.getGuestToken();
    }

    @Description("Регистрируем игрока")
    @Test
    public void playerRegistration() {
        String username = "ji.daniel7";
        String guestToken = GetAccess.getGuestToken();

        given()
                .contentType("application/json; charset=UTF-8")
                .auth().oauth2(guestToken)
                .when()
                .log().all()
                .body("{\n" +
                        " \"username\": \"" + username + "\",\n" +
                        " \"password_change\": \"H1rVr[-]=[-]=\",\n" +
                        " \"password_repeat\": \"H1rVr[-]=[-]=\",\n" +
                        " \"email\": \"" + username + "@example.com\",\n" +
                        " \"name\": \"Jandsfse\",\n" +
                        " \"surname\": \"Dsdfsdoe\",\n" +
                        " \"currency\": \"EUR\" \n" +
                        "}")
                .post("/v2/players")
                .then()
                .statusCode(201)
                .log().body()
                .body("id", is(notNullValue()));
    }

    @Description("Авторизуемся как игрок")
    @Test
    public void playerAuth() {
        GetAccess.playerToken();
    }

    @Description("Получаем информацию по текущему игроку")
    @Test
    public void getPlayerInfo() {
        String playerToken = GetAccess.playerToken();

        given()
                .contentType("application/json; charset=UTF-8")
                .auth().oauth2(playerToken)
                .when()
                .get("/v2/players/8540")
                .then()
                .log().body()
                .statusCode(200)
                .body("id", is(8540));
    }

    @Description("Получаем информацию по другому игроку")
    @Test
    public void getOtherPlayerInfo() {
        String playerToken = GetAccess.playerToken();

        given()
                .contentType("application/json; charset=UTF-8")
                .auth().oauth2(playerToken)
                .when()
                .get("/v2/players/8541")
                .then()
                .log().body()
                .statusCode(404);
    }
}
