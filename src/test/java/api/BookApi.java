package api;

import extension.AuthData;
import io.restassured.response.Response;
import models.AddBooksRequest;
import models.Isbn;

import java.util.Collections;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static specs.Specs.requestSpecAuth;
import static specs.Specs.responseSpec;

public class BookApi {

    private static final String BOOKS_PATH = "/BookStore/v1/Books";
    private static final String BOOK_PATH = "/BookStore/v1/Book";
    private static final String USER_ID_PARAM = "UserId";

    public static void deleteAllBooks(String userId) {
        given()
                .spec(requestSpecAuth(AuthData.token))
                .queryParam(USER_ID_PARAM, userId)
                .when()
                .delete(BOOKS_PATH)
                .then()
                .statusCode(204);
    }

    public static Response addBook(String userId, String isbn) {
        AddBooksRequest body = new AddBooksRequest();
        body.setUserId(userId);

        Isbn one = new Isbn();
        one.setIsbn(isbn);

        body.setCollectionOfIsbns(Collections.singletonList(one));

        return given()
                .spec(requestSpecAuth(AuthData.token))
                .body(body)
                .when()
                .post(BOOKS_PATH)
                .then()
                .spec(responseSpec(201))
                .extract()
                .response();
    }

    public static void deleteBook(String userId, String isbn) {
        given()
                .spec(requestSpecAuth(AuthData.token))
                .body(Map.of(
                        "userId", userId,
                        "isbn", isbn
                ))
                .when()
                .delete(BOOK_PATH)
                .then()
                .statusCode(204);
    }
}

