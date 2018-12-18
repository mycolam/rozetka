import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.ProductPage;
import pages.home.Authorization;
import pages.home.Search;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static config.Values.host;
import listeners.AllureOnEventListener;


/**
 * Created by mycola on 17.12.2018.
 */

@Listeners({AllureOnEventListener.class})  //"слушатель" для Allure-отчета

public class RozetkaTest {

    @BeforeClass
    public void prepare() {
        String chrome = System.getenv("ChromeWebDriver");
        String firefox = System.getenv("GeckoWebDriver");
        String ie = System.getenv("IEWebDriver");
        if (chrome != null) System.setProperty("webdriver.chrome.driver", chrome + "\\chromedriver.exe");
    }

    @BeforeMethod
    public void start() {
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
        //myWebDriver.manage().window().setSize(new Dimension(1024, 662));
    }


    @AfterMethod
    public void stop() {
        getWebDriver().quit();
    }

    @Test(priority = 1, description = "Authorization Test", enabled = true)
    public void authorizationTest() {
        System.out.println("======= authorizationTest ========");
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
        System.out.println("======= searchTest ========");
        open(host);
        Search search = new Search();
        search.setSearchField();
        search.clickSearchButton();
        search.checkSearchResult();
    }

    @Test(priority = 3, description = "Purchase Test")
    public void purchaseTest() {
        System.out.println("======= purchaseTest ========");
        open(host);
        ProductPage productPg = new ProductPage();
        productPg.clickPurchaseButton();
        productPg.checkCartAppeared();
    }

}
