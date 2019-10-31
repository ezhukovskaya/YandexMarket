package PageObjects;

import ConfigRead.UtilsRead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class PasswordForm {
    public By passwordField = By.xpath("//*[@id=\"passp-field-passwd\"]");
    public By logInButton = By.xpath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div/div/form/div[2]/button[1]");
    UtilsRead utilsRead = new UtilsRead();
    WebDriver driver;

    public PasswordForm(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    public void logFormTyping() throws InterruptedException {
        WebElement dynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(utilsRead.readPasswordFromPropertiesFile());
        driver.findElement(logInButton).click();
    }
}
