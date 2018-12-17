import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.home.Authorization;
import pages.home.Search;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static config.Values.host;

/**
 * Created by mycola on 17.12.2018.
 */
public class RozetkaTest {

    @BeforeClass/* Метод, выполняющийся перед началом тест-сьюта */
    public void begin() {
        com.codeborne.selenide.Configuration.browser = "chrome";      //браузер для тестов
        com.codeborne.selenide.Configuration.timeout = 20000;         //максимальный интервал ожидания вебэлементов в милисекундах
        com.codeborne.selenide.Configuration.savePageSource = false;  //не сохранять дополнительные настройки
        WebDriver myWebDriver = null;
        ChromeOptions options = new ChromeOptions();  //создать обьект для установки опций браузера хром
        options.addArguments("--disable-infobars");   //убрать в браузере полосу infobars
        options.addArguments("--disable-dev-tools");  //отключить в браузере dev-tools
        options.addArguments("--start-maximized");
        myWebDriver = new ChromeDriver(options);  //создать вебдрайвер с  указанными выше опциями
        WebDriverRunner.setWebDriver(myWebDriver); //запуск браузера
    }

    @AfterClass
    public void tearDown() {
        getWebDriver().quit();
    }

    @Test(priority = 1, description = "Authorization Test", enabled = true)
    public void authorizationTest() {
        open(host);
        Authorization auth = new Authorization();
        auth.personalAreaButtonClick();
        auth.setLogin();
        auth.setPassword();
        auth.enterButtonClick();
        auth.checkUserName();
    }

    @Test(priority = 2, description = "Search Test")
    public void searchTest() {
        open(host);
        Search search = new Search();
        search.setSearchField();
        search.clickSearchButton();
        search.checkSearchResult();
    }

    @Test(priority = 3, description = "Purchase Test")
    public void purchaseTest() {
        ProductPage productPg = new ProductPage();
        productPg.clickPurchaseButton();
        productPg.checkCartAppeared();
    }

}
