package extension;

import com.codeborne.selenide.WebDriverRunner;
import models.LoginResponse;
import models.UserCredentials;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static specs.Specs.requestSpec;
import static specs.Specs.responseSpec;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {

        UserCredentials creds = new UserCredentials();
        creds.setUserName("admin");
        creds.setPassword("5qA!H6mY8C@ck7x");

        LoginResponse loginResponse =
                given(requestSpec)
                        .body(creds)
                        .post("/Account/v1/Login")
                        .then()
                        .spec(responseSpec(200))
                        .extract().as(LoginResponse.class);

        AuthData.userId = loginResponse.getUserId();
        AuthData.token = loginResponse.getToken();

        open("/login");

        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("userID", loginResponse.getUserId()));
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("username", loginResponse.getUsername()));
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("token", loginResponse.getToken()));
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("expires", loginResponse.getExpires()));
    }
}
