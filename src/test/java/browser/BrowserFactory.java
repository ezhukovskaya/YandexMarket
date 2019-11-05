package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    private static BrowserFactory browserFactoryInstance = null;

    /**
     * выбор драйвера для браузера, указанного в config
     *
     * @param browserName имя браузера
     * @return driver
     */
    public WebDriver getBrowser(String browserName) {
        browserName = browserName.toLowerCase();
        WebDriver driver = null;
        if (browserName.equals("chrome")) {
            driver = getChromeInstance();
        }
        if (browserName.equals("firefox")) {
            driver = getFirefoxInstance();
        } else {
            System.out.println("Браузер указан неверно");
        }

        return driver;
    }

    /**
     * инициализация Singleton
     *
     * @return
     */
    public static BrowserFactory getInstance() {
        if (browserFactoryInstance == null) {
            browserFactoryInstance = new BrowserFactory();
        }
        return browserFactoryInstance;
    }

    /**
     * установка драйвера для Chrome
     *
     * @return
     */
    private ChromeDriver getChromeInstance() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    /**
     * установка драйвра для Firefox
     *
     * @return
     */
    private FirefoxDriver getFirefoxInstance() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
