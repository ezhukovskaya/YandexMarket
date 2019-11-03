package PageObjects;

import Browser.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LogInPage extends GuestMainPage {
    public LogInPage() throws IOException {
        BrowserDriver.getInstanceOfSingletonBrowserClass();
    }

}
