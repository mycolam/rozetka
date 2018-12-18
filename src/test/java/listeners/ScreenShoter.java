package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by mycola on 07.06.2017.
 */
public class ScreenShoter {

    private ScreenShoter(){};

    public static byte[] makeScreenshot(String name) throws IOException {
        return ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
