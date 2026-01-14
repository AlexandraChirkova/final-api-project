package api;

import extension.AuthData;
import io.restassured.response.Response;
import models.AddBooksRequest;
import models.Isbn;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static specs.Specs.requestSpecAuth;
import static specs.Specs.responseSpec;

public class BookApi {

    public static void deleteAllBooks() {
        given()
                .spec(requestSpecAuth(AuthData.token))
                .delete("/BookStore/v1/Books?UserId=" + AuthData.userId)
                .then()
                .statusCode(204);
    }

    public static Response addBook(String isbn) {
        AddBooksRequest body = new AddBooksRequest();
        body.setUserId(AuthData.userId);

        Isbn one = new Isbn();
        one.setIsbn(isbn);

        body.setCollectionOfIsbns(Collections.singletonList(one));

        return given(requestSpecAuth(AuthData.token))
                .body(body)
                .post("/BookStore/v1/Books")
                .then()
                .spec(responseSpec(201))
                .extract().response();
    }

    public static void deleteBook(String isbn) {
        given()
                .spec(requestSpecAuth(AuthData.token))
                .body(
                        java.util.Map.of(
                                "userId", AuthData.userId,
                                "isbn", isbn
                        )
                )
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .statusCode(204);
    }
}
