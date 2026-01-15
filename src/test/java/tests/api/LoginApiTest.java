package tests.api;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import models.LoginResponse;
import models.UserCredentials;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static specs.Specs.requestSpec;
import static specs.Specs.responseSpec;

public class LoginApiTest extends BaseApiTest{

    @Test
    @Description("Отправляем POST запрос на логин")
    @DisplayName("Успешный логин пользователя")
    void loginTest() {

        UserCredentials creds = new UserCredentials();
        creds.setUserName("admin");
        creds.setPassword("5qA!H6mY8C@ck7x");
        LoginResponse response = Allure.step(
                "Отправляем POST запрос на логин",
                () -> given()
                        .spec(requestSpec)
                        .body(creds)
                        .when()
                        .post("/Account/v1/Login")
                        .then()
                        .spec(responseSpec(200))
                        .extract().as(LoginResponse.class)
        );

        Allure.step("Проверяем данные авторизации", () -> {
            assertNotNull(response.getToken(), "Token null");
            assertNotNull(response.getUserId(), "UserId null");
            assertEquals("admin", response.getUsername(), "Username не совпадает");
        });
    }
}
