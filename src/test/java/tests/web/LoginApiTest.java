package tests.web;

import extension.WithLogin;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ProfilePage;


@Tag("web")
@WithLogin
public class LoginApiTest extends BaseTest {

    ProfilePage profilePage = new ProfilePage();

    @Test
    @Description("Отправляет POST запрос для логина")
    @DisplayName("Логин пользователя")
    void registerUserSuccessTest() {

        profilePage.openPage()
                .checkUrl()
                .checkUserNameAfterLogin("admin");

    }

}
