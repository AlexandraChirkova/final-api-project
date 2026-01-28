package tests.web;

import api.BookApi;
import extension.AuthData;
import extension.WithLogin;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.DeleteAllBooksModal;
import pages.ProfilePage;


@Tag("web")
@WithLogin
public class DeleteBooksTest extends BaseTest {

    ProfilePage profilePage = new ProfilePage();
    DeleteAllBooksModal deleteAllBooksModal = new DeleteAllBooksModal();

    @Test
    @Description("Удаляем книги из списка")
    @DisplayName("Удалить книги")
    void deleteBooksSuccessTest() {

        BookApi.deleteAllBooks(AuthData.userId);
        BookApi.addBook(AuthData.userId,"9781491904244");

        profilePage.openPage()
                .checkUrl()
                .checkUserNameAfterLogin("admin")
                .checkBookAvailable()
                .deleteBookClick();
        deleteAllBooksModal.deleteBook();
        profilePage.checkEmptyBooksList();

    }
}
