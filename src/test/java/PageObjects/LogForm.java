package PageObjects;

import Browser.Browser;
import Utils.PropertiesRead;
import org.openqa.selenium.By;

import java.io.IOException;

public class LogForm {
    public By usernameField = By.cssSelector("#passp-field-login");
    public By logInButton = By.cssSelector("button.button2_theme_action:nth-child(1)");
    PropertiesRead propertiesRead = new PropertiesRead();

    /**
     * Инициализация WebDriver в конструкторе
     * @throws IOException
     */
    public LogForm() throws IOException {
        Browser.getInstanceOfSingletonBrowserClass();
    }

    /**
     * метод заполнения поля логин
     * @throws IOException
     */
    public void logFormTyping() throws IOException {
        Browser.browserDriver().findElement(usernameField).sendKeys(propertiesRead.readLogFromPropertiesFile());
        Browser.browserDriver().findElement(logInButton).click();
    }
}
