package Browser;

import Utils.PropertiesRead;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;

public class Browser {
    static PropertiesRead propertiesRead;
    private BrowserFactory browserFactory;
    private static WebDriver driver;
    private static Browser instanceOfSingletonBrowserClass = null;

    private Browser() throws IOException {
        propertiesRead = new PropertiesRead();
        browserFactory = new BrowserFactory();
        driver = browserFactory.getBrowser(propertiesRead.readBrowserFromPropertiesFile());
    }

    public static WebDriver browserDriver() throws IOException {
        return driver;
    }

    public static Browser getInstanceOfSingletonBrowserClass() throws IOException {
        if (instanceOfSingletonBrowserClass == null) {
            instanceOfSingletonBrowserClass = new Browser();
        }
        return instanceOfSingletonBrowserClass;
    }

    public static void goToUrl() throws IOException {
        Browser.browserDriver().get(propertiesRead.readPageNameFromPropertiesFile());
    }

    public static void maximize() throws IOException {
        Browser.browserDriver().manage().window().maximize();
    }

    public static void switchTo(int tabNumber, ArrayList<String> tabs) throws IOException {
        Browser.browserDriver().switchTo().window(tabs.get(tabNumber));
    }

    public static void close() throws IOException {
        Browser.browserDriver().close();
    }
}
