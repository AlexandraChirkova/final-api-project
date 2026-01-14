package tests.api;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import models.BookDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static specs.Specs.requestSpec;
import static specs.Specs.responseSpec;


public class GetBookByIsbnApiTest extends BaseApiTest {

    private static final String ISBN = "9781449325862";

    @Test
    @Description("Получение информации о книге по ISBN")
    @DisplayName("Получить книгу по ISBN")
    void getBookByIsbnTest() {

        BookDto response = Allure.step(
                "Отправляем GET запрос на получение книги по ISBN",
                () -> given()
                        .spec(requestSpec)
                        .queryParam("ISBN", ISBN)
                        .when()
                        .get("/BookStore/v1/Book")
                        .then()
                        .spec(responseSpec(200))
                        .extract().as(BookDto.class)
        );

        Allure.step("Проверяем данные книги", () -> {
            assertEquals(ISBN, response.getIsbn(), "ISBN не совпадает");
            assertNotNull(response.getTitle(), "Title отсутствует");
            assertNotNull(response.getAuthor(), "Author отсутствует");
        });

    }

}
