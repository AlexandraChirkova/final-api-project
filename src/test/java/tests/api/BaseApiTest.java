package tests.api;

import extension.AuthData;
import io.restassured.RestAssured;
import models.LoginResponse;
import models.UserCredentials;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;
import static specs.Specs.requestSpec;
import static specs.Specs.responseSpec;

public class BaseApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://demoqa.com";

        UserCredentials creds = new UserCredentials();
        creds.setUserName("admin");
        creds.setPassword("5qA!H6mY8C@ck7x");

        LoginResponse response =
                given()
                        .spec(requestSpec)
                        .body(creds)
                        .post("/Account/v1/Login")
                        .then()
                        .spec(responseSpec(200))
                        .extract().as(LoginResponse.class);

        AuthData.userId = response.getUserId();
        AuthData.token = response.getToken();
    }
}
