package pageObjects;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CSVFileWrite;
import utils.WebElementWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainPage {
    private By testRandomPageLocator = By.cssSelector("._39qdPorEKz");
    private By testBannerLocator = By.cssSelector("._1TFGF7RAta");
    private String filePath = "src/test/java/resource/file.csv";
    private By goToMainPage = By.xpath("//a[@class='logo logo_type_link logo_part_market']");
    private By allCategoriesButton = By.cssSelector("div.n-w-tab__control");
    private By allCategories = By.cssSelector(".n-w-tabs__vertical-tabs>*");
    private By pathCategories = By.cssSelector(".n-w-tabs__horizontal-tabs>*");
    private By logOutButton = By.cssSelector(".user__logout");
    public By accountIcon = By.cssSelector(".header2-nav__user > a:nth-child(1)");
    private ArrayList<WebElement> categories;

    /**
     * возвращает значение локатора для случайной страницы
     *
     * @return
     */
    public By getTestRandomPageLocator() {
        return testRandomPageLocator;
    }

    /**
     * возвращае значение локатора для баннера
     *
     * @return
     */
    public By getTestBannerLocator() {
        return testBannerLocator;
    }

    /**
     * метод считывания топ-категорий и возвращение списка эти категорий
     *
     * @return
     */
    public ArrayList<String> getTopCategories() {
        WebElementWait.waiterForWebElement(pathCategories);
        categories = (ArrayList<WebElement>) Browser.getDriver().findElements(pathCategories);
        categories.trimToSize();
        ArrayList<String> listOfCategories = new ArrayList<String>();
        int j = 2;
        for (int i = 0; i < categories.size(); i++, j++) {
            if (categories.get(i).getText().length() < 2) {
                i = categories.size();
            } else {
                listOfCategories.add(categories.get(j).getText());
            }
        }
        listOfCategories.removeAll(Arrays.asList("", null));
        return listOfCategories;
    }

    /**
     * метод выбора и нажатия на рандомную категорию
     */
    public void goToRandomCategory() {
        categories.get(new Random().nextInt(((categories.size() - 2) + 1) + 2)).click();
    }

    /**
     * метод возвращения на главную страницу
     */
    public void backToMainPage() {
        Browser.getDriver().findElement(goToMainPage).click();
    }

    /**
     * метод нажатия на вкладку "Все категории"
     */
    public void goToAllCategories() {
        Browser.getDriver().findElement(allCategoriesButton).click();
    }

    /**
     * метод записи в файл всех категорий маркета
     *
     * @return список всех категорий
     */
    public ArrayList<String> copyAllCategories() {
        ArrayList<WebElement> allCat = (ArrayList<WebElement>) Browser.getDriver().findElements(allCategories);
        ArrayList<String> allCatString = new ArrayList<String>();
        for (WebElement webElement : allCat) {
            allCatString.add(webElement.getText());
        }
        CSVFileWrite csvFileWrite = new CSVFileWrite();
        csvFileWrite.fileWrite(allCatString, filePath);
        return allCatString;
    }

    /**
     * выход из аккаунта
     */
    public void logOutFunction() {
        Browser.getDriver().findElement(accountIcon).click();
        Browser.getDriver().findElement(logOutButton).click();
    }

}
