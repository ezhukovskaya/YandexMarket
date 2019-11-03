package PageObjects;

import Browser.BrowserDriver;
import Utils.PropertiesRead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LogForm {
    public By usernameField = By.cssSelector("#passp-field-login");
    public By logInButton = By.cssSelector("button.button2_theme_action:nth-child(1)");
    PropertiesRead propertiesRead = new PropertiesRead();

    public LogForm() throws IOException {
        BrowserDriver.getInstanceOfSingletonBrowserClass();
    }

    public void logFormTyping() throws IOException {
        BrowserDriver.browserDriver().findElement(usernameField).sendKeys(propertiesRead.readLogFromPropertiesFile());
        BrowserDriver.browserDriver().findElement(logInButton).click();
    }
}
