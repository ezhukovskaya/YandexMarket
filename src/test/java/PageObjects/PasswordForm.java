package PageObjects;

import Browser.BrowserDriver;
import Utils.PropertiesRead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class PasswordForm {
    public By passwordField = By.xpath("//*[@id=\"passp-field-passwd\"]");
    public By logInButton = By.xpath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div/div/form/div[2]/button[1]");
    PropertiesRead propertiesRead = new PropertiesRead();

    /**
     * Инициализация WebDriver в конструкторе
     * @throws IOException
     */
    public PasswordForm() throws IOException {
        BrowserDriver.getInstanceOfSingletonBrowserClass();
    }

    /**
     * метод заполнения поля пароля
     * @throws InterruptedException
     * @throws IOException
     */
    public void logFormTyping() throws InterruptedException, IOException {
        WebElement dynamicElement = (new WebDriverWait(BrowserDriver.browserDriver(), 10)).until(ExpectedConditions.presenceOfElementLocated(passwordField));
        BrowserDriver.browserDriver().findElement(passwordField).sendKeys(propertiesRead.readPasswordFromPropertiesFile());
        BrowserDriver.browserDriver().findElement(logInButton).click();
    }
}
