package PageObjects;

import Browser.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GuestMainPage {
    private By logIn = By.cssSelector(".header2-nav__user > div:nth-child(1) > a:nth-child(1)");
    private WebDriver driver;

    public GuestMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLogInButton() throws IOException {
        driver.findElement(logIn).click();
    }
}
