package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public WebDriver getBrowser(String browserName){
        browserName = browserName.toLowerCase();
        WebDriver driver = null;
        if(browserName.equals("chrome"))
            driver = getChromeInstance();
        if(browserName.equals("firefox"))
            driver = getFirefoxInstance();
        return driver;
    }

    private ChromeDriver getChromeInstance() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    private FirefoxDriver getFirefoxInstance(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
