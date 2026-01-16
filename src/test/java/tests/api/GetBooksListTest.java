package tests.api;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import models.BooksListResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static specs.Specs.requestSpec;
import static specs.Specs.responseSpec;


@Tag("api")
@Epic("Book Store")
@Feature("Получение списка книг")
public class GetBooksListTest extends BaseApiTest{

    @Test
    @Description("Отправляет GET запрос и выводит список книг")
    @DisplayName("Получить список книг")
    void getListBooksTest(){

        BooksListResponse response = Allure.step(
                "Отправляем GET запрос на получение списка книг",
                () -> given()
                        .spec(requestSpec)
                        .when()
                        .get("/BookStore/v1/Books")
                        .then()
                        .spec(responseSpec(200))
                        .extract().as(BooksListResponse.class)
        );

        Allure.step("Проверяем ответ", () -> {
            assertNotNull(response.getBooks(), "Список книг null");
            assertFalse(response.getBooks().isEmpty(), "Список книг пуст");
            assertNotNull(response.getBooks().get(0).getIsbn(), "ISBN отсутствует");
            assertNotNull(response.getBooks().get(0).getTitle(), "Title отсутствует");
        });

    }
}
