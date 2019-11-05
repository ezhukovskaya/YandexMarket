package pageObjects;

import browser.Browser;
import org.openqa.selenium.By;

public class GuestMainPage {
    public By logIn = By.cssSelector(".header2-nav__user .user__login");

    /**
     * нажатие на кнопку войти в неавторизованном режиме
     */
    public void clickLogInButton() {
        Browser.getDriver().findElement(logIn).click();
    }
}
