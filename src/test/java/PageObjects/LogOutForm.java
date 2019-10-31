package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutForm {
    private By logOutButton = By.xpath("/html/body/div[1]/div/div[1]/noindex/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div/ul[2]/li[6]/a");
    private WebDriver driver;

    public LogOutForm(WebDriver driver) {
        this.driver = driver;
        this.driver.findElement(logOutButton).click();
    }
}
