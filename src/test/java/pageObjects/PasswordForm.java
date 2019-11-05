package pageObjects;

import browser.Browser;
import org.openqa.selenium.By;
import utils.WebElementWait;

public class PasswordForm {
    private By passwordField = By.xpath("//*[@id=\"passp-field-passwd\"]");
    private By logInButton = By.cssSelector("button.control:nth-child(1)");
    /**
     * метод заполнения поля пароля
     */
    public void enterPassword(String password) {
        WebElementWait.waiterForWebElement(passwordField);
        Browser.getDriver().findElement(passwordField).sendKeys(password);
        Browser.getDriver().findElement(logInButton).click();
    }
}
