package Tests;

import Browser.BrowserDriver;
import PageObjects.GuestMainPage;
import PageObjects.LogForm;
import PageObjects.MainPage;
import PageObjects.PasswordForm;
import Utils.PropertiesRead;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class YandexTest {
    private GuestMainPage guestMainPage;
    LogForm logForm;
    PasswordForm passwordForm;
    MainPage mainPage;

    @BeforeTest
    public void init() throws IOException {
        BrowserDriver.getInstanceOfSingletonBrowserClass();
        guestMainPage = new GuestMainPage();
        logForm = new LogForm();
        passwordForm = new PasswordForm();
        mainPage = new MainPage();
    }

    @Test
    public void yandexMarketPageOpen() throws IOException, InterruptedException {
        BrowserDriver.goToUrl();
        BrowserDriver.maximize();
        guestMainPage.clickLogInButton();
        ArrayList<String> tabs = new ArrayList<String>(BrowserDriver.browserDriver().getWindowHandles());
        BrowserDriver.switchTo(tabs.size() - 1, tabs);
        logForm.logFormTyping();
        passwordForm.logFormTyping();
        BrowserDriver.switchTo(0, tabs);
        ArrayList<String> topCategories = mainPage.getCategories();
        mainPage.goToRandomCategory();
        mainPage.backToMainPage();
        mainPage.goToAllCategories();
        ArrayList<String> allCategories = mainPage.copyAllCategories();
        allCategories.retainAll(topCategories);
        Assert.assertEquals(allCategories, topCategories);
        mainPage.logOutFunction();
    }
}
