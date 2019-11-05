package tests;

import browser.Browser;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.GuestMainPage;
import pageObjects.LogForm;
import pageObjects.MainPage;
import pageObjects.PasswordForm;
import utils.PropertiesRead;
import utils.WebElementWait;

import java.util.ArrayList;

public class YandexTest {
    private GuestMainPage guestMainPage;
    private LogForm logForm;
    private PasswordForm passwordForm;
    private MainPage mainPage;
    private String password;
    private String logIn;

    @BeforeTest
    public void init() {
        Browser.getInstance();
        guestMainPage = new GuestMainPage();
        logForm = new LogForm();
        passwordForm = new PasswordForm();
        mainPage = new MainPage();
        Browser.implicitlyWait();
        Browser.goToUrl();
        Browser.maximize();
        password = PropertiesRead.readFromPropertiesFile("password");
        logIn = PropertiesRead.readFromPropertiesFile("login");
    }

    /**
     * тестиует сайт market.yandex.ru
     * @throws InterruptedException
     */
    @Test
    public void yandexMarketPageOpen() throws InterruptedException {
        WebElementWait.waiterForWebElement(mainPage.getTestBannerLocator());
        WebElement testBanner = WebElementWait.getWebElement(mainPage.getTestBannerLocator());
        Assert.assertTrue(testBanner.isDisplayed(),"Не удалось открыть страницу");
        guestMainPage.clickLogInButton();
        ArrayList<String> tabs = new ArrayList<String>(Browser.getDriver().getWindowHandles());
        Browser.switchTo(tabs.size() - 1, tabs);
        Thread.sleep(5000);
        logForm.enterLogIn(logIn);
        Thread.sleep(5000);
        passwordForm.enterPassword(password);
        Browser.switchTo(0, tabs);
        WebElementWait.waiterForWebElement(mainPage.accountIcon);
        WebElement testAuthorizedIcon = WebElementWait.getWebElement(mainPage.accountIcon);
        Thread.sleep(5000);
        Assert.assertTrue(testAuthorizedIcon.isDisplayed(), "Не удалось авторизоваться");
        ArrayList<String> topCategories = mainPage.getTopCategories();
        mainPage.goToRandomCategory();
        WebElementWait.waiterForWebElement(mainPage.getTestRandomPageLocator());
        WebElement testRandom = WebElementWait.getWebElement(mainPage.getTestRandomPageLocator());
        Assert.assertTrue(testRandom.isDisplayed(),"Выбранная категория не загрузилась");
        mainPage.backToMainPage();
        mainPage.goToAllCategories();
        ArrayList<String> allCategories = mainPage.copyAllCategories();
        allCategories.retainAll(topCategories);
        Assert.assertEquals(allCategories, topCategories,"Список всех категорий не включает значения топ-категорий");
        mainPage.logOutFunction();
        WebElementWait.waiterForWebElement(guestMainPage.logIn);
        WebElement testLogInAgainButton = WebElementWait.getWebElement(guestMainPage.logIn);
        Assert.assertTrue(testLogInAgainButton.isDisplayed(),"Не удалось выйти");
    }

    /**
     * закрытие браузера
     */
    @AfterTest
    public void browserClose() {
        Browser.close();
    }
}
