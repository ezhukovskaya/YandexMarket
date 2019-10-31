package Browser;

import ConfigRead.UtilsRead;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class BrowserDriver {
    private static BrowserDriver instanceOfSingletonBrowserClass = null;
    public WebDriver browserDriver() throws IOException {
        UtilsRead utilsRead = new UtilsRead();
        String browserName = utilsRead.readBrowserFromPropertiesFile();
        BrowserFactory browserFactory = new BrowserFactory();
        return browserFactory.getBrowser(browserName);
    }
    public static BrowserDriver getInstanceOfSingletonBrowserClass(){
        if(instanceOfSingletonBrowserClass == null){
            instanceOfSingletonBrowserClass = new BrowserDriver();
        }
        return instanceOfSingletonBrowserClass;
    }
}
