package PageObjects;

import Browser.Browser;

import java.io.IOException;

public class LogInPage extends GuestMainPage {
    /**
     * Инициализация WebDriver в конструкторе
     * @throws IOException
     */
    public LogInPage() throws IOException {
        Browser.getInstanceOfSingletonBrowserClass();
    }

}
