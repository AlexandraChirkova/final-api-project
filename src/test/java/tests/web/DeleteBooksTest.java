package tests.web;

import api.BookApi;
import extension.WithLogin;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DeleteAllBooksModal;
import pages.ProfilePage;


@WithLogin
public class DeleteBooksTest extends BaseTest {

    ProfilePage profilePage = new ProfilePage();
    DeleteAllBooksModal deleteAllBooksModal = new DeleteAllBooksModal();

    @Test
    @Description("Удаляем книги из списка")
    @DisplayName("Удалить книги")
    void deleteBooksSuccessTest() {

        BookApi.deleteAllBooks();
        BookApi.addBook("9781491904244");

        profilePage.openPage()
                .checkUrl()
                .checkUserNameAfterLogin("admin")
                .checkBookAvailable()
                .deleteBookClick();
        deleteAllBooksModal.deleteBook();
        profilePage.checkEmptyBooksList();

    }
}
