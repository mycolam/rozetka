package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by mycola on 17.12.2018.
 */
public class ProductPage extends Page {

    @Step("Click Purchase button")
    public void clickPurchaseButton() {
        SelenideElement button = $(byXpath("//button[@name='topurchases']")).shouldBe(visible);
        //if (!button.exists()) button = $(byXpath("//button[@class='button button_color_green search__button']"));
        button.click();
    }

    @Step("Check cart is appeared")
    public void checkCartAppeared() {
        SelenideElement header = $(byXpath("//h2[@class='cart-title']")).shouldBe(visible);
    }

}
