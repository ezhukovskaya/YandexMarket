package Tests;

import Browser.Browser;
import PageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class YandexTest {
    private GuestMainPage guestMainPage;
    private LogForm logForm;
    private PasswordForm passwordForm;
    private MainPage mainPage;
    private By testRandomPageLocator = By.xpath("/html/body/div[1]/div[2]/div[6]/div/div/div/div/div/h1");
    private By testBannerLocator = By.xpath("/html/body/div[1]/noindex/div/div/div/a/img");
    private WebElementWait waiter;

    @BeforeTest
    public void init() throws IOException {
        Browser.getInstanceOfSingletonBrowserClass();
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
        Browser.browserDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Browser.goToUrl();
        Browser.maximize();
        WebElement testBanner = waiter.waiterForWebElement(testBannerLocator);
        Assert.assertTrue(testBanner.isDisplayed());
        guestMainPage.clickLogInButton();
        ArrayList<String> tabs = new ArrayList<String>(Browser.browserDriver().getWindowHandles());
        Browser.switchTo(tabs.size() - 1, tabs);
        Thread.sleep(5000);
        logForm.logFormTyping();
        Thread.sleep(5000);
        passwordForm.logFormTyping();
        Browser.switchTo(0, tabs);
        WebElement testAuthorizedIcon = waiter.waiterForWebElement(mainPage.accountIcon);
        Thread.sleep(5000);
        Assert.assertTrue(testAuthorizedIcon.isDisplayed());
        ArrayList<String> topCategories = mainPage.getCategories();
        mainPage.goToRandomCategory();
        WebElement testRandom = waiter.waiterForWebElement(testRandomPageLocator);
        Assert.assertTrue(testRandom.isDisplayed());
        mainPage.backToMainPage();
        mainPage.goToAllCategories();
        ArrayList<String> allCategories = mainPage.copyAllCategories();
        allCategories.retainAll(topCategories);
        Assert.assertEquals(allCategories, topCategories);
        mainPage.logOutFunction();
        WebElement testLogInAgainButton = waiter.waiterForWebElement(guestMainPage.logIn);
        Assert.assertTrue(testLogInAgainButton.isDisplayed());
    }

    /**
     * закрытие браузера
     * @throws IOException
     */
    @AfterTest
    public void browserClose() throws IOException {
        Browser.close();
    }
}
