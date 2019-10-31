package PageObjects;

import ConfigRead.UtilsRead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LogForm {
    public By usernameField = By.cssSelector("#passp-field-login");
    public By logInButton = By.cssSelector("button.button2_theme_action:nth-child(1)");
    UtilsRead utilsRead = new UtilsRead();
    private WebDriver driver;

    public LogForm(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    public void logFormTyping(){
        driver.findElement(usernameField).sendKeys(utilsRead.readLogFromPropertiesFile());
        driver.findElement(logInButton).click();
    }
}
