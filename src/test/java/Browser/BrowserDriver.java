package Browser;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BrowserDriver {
    public WebDriver BrowserDriver() throws IOException {
        String browserName = readPropertiesFile();
        BrowserFactory browserFactory = new BrowserFactory();
        return browserFactory.getBrowser(browserName);
    }
    private static String readPropertiesFile() throws IOException {
        Properties prop = new Properties();
        InputStream input = new FileInputStream("config.properties");
        prop.load(input);
        return prop.getProperty("browser");
    }
}
