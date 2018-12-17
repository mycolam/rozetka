package pages.home;
import com.codeborne.selenide.SelenideElement;
import config.Values;
import io.qameta.allure.Step;
import pages.Page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by mycola on 17.12.2018.
 */
public class Authorization extends Page {

    @Step("Click personal area button")
    public void personalAreaButtonClick() {
        SelenideElement link = $(byXpath("//a[@href='https://my.rozetka.com.ua/signin/']"));
        link.click();
        Sleep(2);
    }

    @Step("Enter login")
    public void setLogin() {
        if ($("#auth_email").exists()) {
            $("#auth_email").setValue(Values.login);
        } else {
            $(byXpath("//input[@name='login']")).setValue(Values.login);
        }
    }

    @Step("Enter password")
    public void setPassword() {
        if ($("#auth_pass").exists()) {
            $("#auth_pass").setValue(Values.password);
        } else {
            $(byXpath("//input[@name='password']")).setValue(Values.password);
        }
    }

    @Step("Click Enter button")
    public void enterButtonClick() {
        SelenideElement button = $(byXpath("//button[@class='button button_color_navy auth-modal__login-button']"));
        if (!button.exists()) button = $(byXpath("//button[@name='auth_submit']"));
        button.click();
    }

    @Step("Check user name")
    public void checkUserName() {
        SelenideElement button = $(byXpath("//button[@class='modal__close js-modal-close']"));
        button.shouldNotBe(visible);
        Sleep(4);
        button = $(byXpath("//a[@href='https://my.rozetka.com.ua/']"));
        assertTrue("Имя пользователя не корректно"+
                   "\nОжидалось : " + Values.user +
                   "\nФактически: " + button.getText(),
                   Values.user.equals(button.getText()));
    }

}
