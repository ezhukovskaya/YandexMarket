package Browser;

import Utils.PropertiesRead;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.ArrayList;

public class BrowserDriver {
    static PropertiesRead propertiesRead;
    private BrowserFactory browserFactory;
    private static WebDriver driver;
    private static BrowserDriver instanceOfSingletonBrowserClass = null;

    private BrowserDriver() throws IOException {
        propertiesRead = new PropertiesRead();
        browserFactory = new BrowserFactory();
        driver = browserFactory.getBrowser(propertiesRead.readBrowserFromPropertiesFile());
    }

    public static WebDriver browserDriver() throws IOException {
        return driver;
    }

    public static BrowserDriver getInstanceOfSingletonBrowserClass() throws IOException {
        if(instanceOfSingletonBrowserClass == null){
            instanceOfSingletonBrowserClass = new BrowserDriver();
        }
        return instanceOfSingletonBrowserClass;
    }
    public static void goToUrl() throws IOException {
        BrowserDriver.browserDriver().get(propertiesRead.readPageNameFromPropertiesFile());
    }

    public static void maximize() throws IOException {
        BrowserDriver.browserDriver().manage().window().maximize();
    }

    public static void switchTo(int tabNumber, ArrayList<String> tabs) throws IOException {
        BrowserDriver.browserDriver().switchTo().window(tabs.get(tabNumber));
    }
}
