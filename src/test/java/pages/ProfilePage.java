package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class ProfilePage {
    public final SelenideElement titleUserName = $("#userName-value");
    public final SelenideElement userNameLabel = $(".col-md-5 > #userName-label");
    public final SelenideElement booksLink = $(".mr-2 > a");
    public final SelenideElement deleteBooks = $(".di > #submit");
    private ElementsCollection bookRows = $$(".rt-tbody .rt-tr-group");


    @Step("Открыть страницу профайла")
    public ProfilePage openPage() {
        open("/profile");
        $(".loading").should(disappear);
        userNameLabel.shouldBe(visible);
        return this;
    }

    @Step("Проверить урл страницы")
    public ProfilePage checkUrl() {
        webdriver().shouldHave(urlContaining("profile"));
        return this;
    }

    @Step("Проверить User Name")
    public ProfilePage checkUserNameAfterLogin(String userName) {
        titleUserName.shouldBe(visible).shouldHave(text(userName));
        return this;

    }

    @Step("Проверить наличие книгм")
    public ProfilePage checkBookAvailable() {
        booksLink.shouldBe(visible).shouldHave(text("You Don't Know JS"));
        return this;
    }

    @Step("Удалить книгу")
    public ProfilePage deleteBookClick() {
        deleteBooks.shouldBe(visible).click();
        return this;
    }

    @Step("Проверить, что нет книг в спиcке")
    public ProfilePage checkEmptyBooksList() {
        bookRows.shouldHave(size(0));
        return this;
    }

}
