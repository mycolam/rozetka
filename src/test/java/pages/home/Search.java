package pages.home;

import com.codeborne.selenide.SelenideElement;
import config.Values;
import io.qameta.allure.Step;
import pages.Page;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by mycola on 17.12.2018.
 */
public class Search extends Page {

    private String searchText = "58A6501UW";
    private String resultText = "Hisense 58\" 4K Smart 58A6501UW";

    @Step("Enter search field")
    public void setSearchField() {
        SelenideElement input = $(byXpath("//input[@name='search']"));
        if (!input.exists()) input = $(byXpath("//input[@class='rz-header-search-input-text passive']"));
        input.setValue(searchText);
    }

    @Step("Click Search button")
    public void clickSearchButton() {
        SelenideElement button = $(byXpath("//button[@class='btn-link-i js-rz-search-button']"));
        if (!button.exists()) button = $(byXpath("//button[@class='button button_color_green search__button']"));
        button.click();
    }

    @Step("Check search result")
    public void checkSearchResult() {
        SelenideElement header = $(byXpath("//h1[@class='detail-title h1']")).shouldBe(visible);
        assertTrue("Результат поиска некорректен"+
                   "\nОжидалось :  содержит фрагмент «" +resultText + "»" +
                   "\nФактически: " + header.getText(),
                   header.getText().contains(resultText));
    }

}
