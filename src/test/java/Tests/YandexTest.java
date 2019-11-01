package Tests;

import Browser.BrowserDriver;
import ConfigRead.UtilsRead;
import PageObjects.GuestMainPage;
import PageObjects.LogForm;
import PageObjects.MainPage;
import PageObjects.PasswordForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class YandexTest {
    private GuestMainPage guestMainPage;
    private WebDriver driver;
    LogForm logForm;
    PasswordForm passwordForm;
    MainPage mainPage;
    BrowserDriver initBrowser;
    @BeforeTest
    public void init() throws IOException {
        initBrowser = new BrowserDriver();
        driver = initBrowser.browserDriver();
        guestMainPage = new GuestMainPage(driver);
        logForm = new LogForm(driver);
        passwordForm = new PasswordForm((driver));
        mainPage = new MainPage(driver);

    }
    @Test
    public void yandexMarketPageOpen() throws IOException, InterruptedException {
        driver.get("https://market.yandex.ru/");
        driver.manage().window().maximize();
        guestMainPage.clickLogInButton();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
        logForm.logFormTyping();
        passwordForm.logFormTyping();
        driver.switchTo().window(tabs.get(0));
        mainPage.getCategories();
        mainPage.goToRandomCategory();
        mainPage.backToMainPage();
        mainPage.goToAllCategories();
        mainPage.copyAllCategories();
       // mainPage.logOutFunction();
    }
}
