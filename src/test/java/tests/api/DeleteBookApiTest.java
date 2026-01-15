package tests.api;

import api.BookApi;
import extension.AuthData;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static specs.Specs.requestSpecAuth;

@Tag("api")
public class DeleteBookApiTest extends BaseApiTest{

    @Test
    @Description("Удаление одной книги пользователя")
    @DisplayName("Удалить книгу")
    void deleteBookTest() {

        Allure.step("Предусловие: добавляем книгу", () -> {
            BookApi.addBook("9781449325862");
        });

        Allure.step("Отправляем DELETE запрос на удаление книги", () ->
                given()
                        .spec(requestSpecAuth(AuthData.token))
                        .body(Map.of(
                                "userId", AuthData.userId,
                                "isbn", "9781449325862"
                        ))
                        .when()
                        .delete("/BookStore/v1/Book")
                        .then()
                        .statusCode(204)
        );
    }
}
