package tests.api;

import api.BookApi;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import models.BooksListResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("api")
@Epic("Book Store")
@Feature("Добавление книги")
public class AddBookApiTest extends BaseApiTest {

    @Test
    @Description("Добавление книги пользователю через API")
    @DisplayName("Добавить книгу пользователю")
    void addBookTest() {

        BooksListResponse response = Allure.step(
                "Отправляем POST запрос на добавление книги",
                () -> BookApi.addBook("9781449325862")
                        .as(BooksListResponse.class)
        );

        Allure.step("Проверяем, что книга добавлена", () -> {
            assertNotNull(response.getBooks(), "Список книг null");
            assertFalse(response.getBooks().isEmpty(), "Список книг пуст");
            assertEquals(
                    "9781449325862",
                    response.getBooks().get(0).getIsbn(),
                    "ISBN добавленной книги не совпадает"
            );
        });
    }


    @AfterEach
    void cleanUp() {
        Allure.step("Очистка данных: удаляем добавленную книгу", () -> {
            BookApi.deleteBook("9781449325862");
        });
    }

}
