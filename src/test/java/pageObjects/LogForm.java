package pageObjects;

import browser.Browser;
import org.openqa.selenium.By;
import utils.WebElementWait;

public class LogForm {
    private By usernameField = By.cssSelector("#passp-field-login");
    private By logInButton = By.cssSelector("button.button2_theme_action:nth-child(1)");

    /**
     * метод заполнения поля логин
     */
    public void enterLogIn(String logIn) {
        WebElementWait.waiterForWebElement(usernameField);
        Browser.getDriver().findElement(usernameField).sendKeys(logIn);
        Browser.getDriver().findElement(logInButton).click();
    }
}
