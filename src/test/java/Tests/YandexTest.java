package Tests;

import Browser.BrowserDriver;
import PageObjects.*;
import Utils.PropertiesRead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class YandexTest {
    private GuestMainPage guestMainPage;
    private LogForm logForm;
    private PasswordForm passwordForm;
    private MainPage mainPage;
    private WebElement testBanner;
    WebElement testAuthorizedIcon;
    WebElement testRandom;
    WebElement testLogInAgainButton;
    By testRandomPageLocator = By.xpath("/html/body/div[1]/div[2]/div[6]/div/div/div/div/div/h1");
    By testBannerLocator = By.xpath("/html/body/div[1]/noindex/div/div/div/a/img");
    WebElementWait waiter;

    @BeforeTest
    public void init() throws IOException {
        BrowserDriver.getInstanceOfSingletonBrowserClass();
        guestMainPage = new GuestMainPage();
        logForm = new LogForm();
        passwordForm = new PasswordForm();
        mainPage = new MainPage();
        waiter = new WebElementWait();
    }

    /**
     * тестиует сайт market.yandex.ru
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void yandexMarketPageOpen() throws IOException, InterruptedException {
        BrowserDriver.goToUrl();
        BrowserDriver.maximize();
        testBanner = waiter.waiterForWebElement(testBannerLocator);
        Assert.assertTrue(testBanner.isDisplayed());
        guestMainPage.clickLogInButton();
        ArrayList<String> tabs = new ArrayList<String>(BrowserDriver.browserDriver().getWindowHandles());
        BrowserDriver.switchTo(tabs.size() - 1, tabs);
        logForm.logFormTyping();
        passwordForm.logFormTyping();
        BrowserDriver.switchTo(0, tabs);
        testAuthorizedIcon = waiter.waiterForWebElement(mainPage.accountIcon);
        Assert.assertTrue(testAuthorizedIcon.isDisplayed());
        ArrayList<String> topCategories = mainPage.getCategories();
        mainPage.goToRandomCategory();
        testRandom = waiter.waiterForWebElement(testRandomPageLocator);
        Assert.assertTrue(testRandom.isDisplayed());
        mainPage.backToMainPage();
        mainPage.goToAllCategories();
        ArrayList<String> allCategories = mainPage.copyAllCategories();
        allCategories.retainAll(topCategories);
        Assert.assertEquals(allCategories, topCategories);
        mainPage.logOutFunction();
        testLogInAgainButton = waiter.waiterForWebElement(guestMainPage.logIn);
        Assert.assertTrue(testLogInAgainButton.isDisplayed());
    }
}
