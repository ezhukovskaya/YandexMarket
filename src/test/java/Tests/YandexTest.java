package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YandexTest {
    private WebDriver driver;
    private WebElement logInButton;
    @BeforeTest
    public void init(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void yandexMarketPageOpen() {
        driver.get("https://market.yandex.ru/");
    }
}
