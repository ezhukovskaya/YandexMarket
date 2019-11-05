package PageObjects;

import Browser.Browser;
import Utils.CSVFileWrite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainPage {
    private By goToMainPage = By.xpath("//a[@class='logo logo_type_link logo_part_market']");
    private By allCategoriesButton = By.cssSelector("div.n-w-tab__control");
    private By allCategories = By.cssSelector(".n-w-tabs__vertical-tabs>*");
    private By pathCategories = By.cssSelector(".n-w-tabs__horizontal-tabs>*");
    public By accountIcon = By.xpath("/html/body/div[1]/div/div[1]/noindex/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[1]/div[1]/a/span[1]");
    private ArrayList<WebElement> categories;

    /**
     * Инициализация WebDriver в конструкторе
     * @throws IOException
     */
    public MainPage() throws IOException {
        Browser.getInstanceOfSingletonBrowserClass();
    }

    /**
     * метод считывания топ-категорий и возвращение списка эти категорий
     * @return
     * @throws IOException
     */
    public ArrayList<String> getCategories() throws IOException {
        Browser.browserDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        categories = (ArrayList<WebElement>) Browser.browserDriver().findElements(pathCategories);
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
     * @throws IOException
     */
    public void goToRandomCategory() throws IOException {
        categories.get(new Random().nextInt((((categories.size()-3)-2)+1)+2)).click();
    }

    /**
     * метод возвращения на главную страницу
     * @throws IOException
     */
    public void backToMainPage() throws IOException {
        Browser.browserDriver().findElement(goToMainPage).click();
    }

    /**
     * метод нажатия на вкладку "Все категории"
     * @throws IOException
     */
    public void goToAllCategories() throws IOException {
        Browser.browserDriver().findElement(allCategoriesButton).click();
    }

    /**
     * метод записи в файл всех категорий маркета
     * @return список всех категорий
     * @throws IOException
     */
    public ArrayList<String> copyAllCategories() throws IOException {
        ArrayList<WebElement> allCat = (ArrayList<WebElement>) Browser.browserDriver().findElements(allCategories);
        ArrayList<String> allCatString = new ArrayList<String>();
        for (WebElement webElement : allCat) {
            allCatString.add(webElement.getText());
        }
        CSVFileWrite csvFileWrite = new CSVFileWrite();
        csvFileWrite.fileWrite(allCatString);
        return allCatString;
    }

    /**
     * метод нажатия на иконку аккаунта
     * @throws IOException
     */
    public void logOutFunction() throws IOException {
        Browser.browserDriver().findElement(accountIcon).click();
        LogOutForm logOutForm = new LogOutForm(Browser.browserDriver());
    }

}
