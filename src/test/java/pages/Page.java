package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by mycola on 17.12.2018.
 */
public class Page {

    public static void Sleep(int time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static byte[] makeScreenshot() {
        byte[] result;
        result = ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.BYTES);
        return result;
    }

}
