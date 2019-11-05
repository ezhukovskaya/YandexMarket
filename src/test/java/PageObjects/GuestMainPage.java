package PageObjects;

import Browser.Browser;
import org.openqa.selenium.By;

import java.io.IOException;

public class GuestMainPage {
    public By logIn = By.cssSelector(".header2-nav__user > div:nth-child(1) > a:nth-child(1)");

    /**
     * Инициализация WebDriver в конструкторе
     * @throws IOException
     */
    public GuestMainPage() throws IOException {
        Browser.getInstanceOfSingletonBrowserClass();
    }

    /**
     * нажатие на кнопку войти в неавторизованном режиме
     * @throws IOException
     */
    public void clickLogInButton() throws IOException {
        Browser.browserDriver().findElement(logIn).click();
    }
}
