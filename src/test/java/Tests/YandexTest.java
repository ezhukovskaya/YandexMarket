package Tests;

import Browser.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class YandexTest {
    private WebDriver driver;
    @BeforeTest
    public void init() throws IOException {
        BrowserDriver initBrowser = new BrowserDriver();
        driver = initBrowser.BrowserDriver();
    }
    @Test
    public void yandexMarketPageOpen() {
        driver.get("https://market.yandex.ru/");
    }
}
