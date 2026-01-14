package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class DeleteAllBooksModal {

    public final SelenideElement deleteBookTitle = $("#example-modal-sizes-title-sm");
    public final SelenideElement okDeleteButton = $("#closeSmallModal-ok");

    @Step("Удалить книгу")
    public void deleteBook() {
        deleteBookTitle.shouldHave(text("Delete All Books"));
        okDeleteButton.shouldBe(visible).click();
        refresh();
    }

}
