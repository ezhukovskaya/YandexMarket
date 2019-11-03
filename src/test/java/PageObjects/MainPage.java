package PageObjects;

import Browser.BrowserDriver;
import Utils.CSVFileWrite;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainPage {
    private By goToMainPage = By.xpath("//a[@class='logo logo_type_link logo_part_market']");
    private By allCategoriesButton = By.cssSelector("div.n-w-tab__control");
    private By allCategories = By.cssSelector(".n-w-tabs__vertical-tabs>*");
    private By pathCategories = By.cssSelector(".n-w-tabs__horizontal-tabs>*");
    private By accountIcon = By.xpath("/html/body/div[1]/div/div[1]/noindex/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[1]/div[1]/a/span[1]");
    private ArrayList<WebElement> categories;

    public MainPage() throws IOException {
        BrowserDriver.getInstanceOfSingletonBrowserClass();
    }

    public ArrayList<String> getCategories() throws IOException {
        BrowserDriver.browserDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        categories = (ArrayList<WebElement>) BrowserDriver.browserDriver().findElements(pathCategories);
        categories.trimToSize();
        ArrayList<String> listOfCategories = new ArrayList<String>();
        int j = 2;
        for (int i = 0; i < categories.size(); i++, j++) {
            if (categories.get(i).getText().length() < 2) {
                i=categories.size();
            } else {
                listOfCategories.add(categories.get(j).getText());
            }
        }
        listOfCategories.trimToSize();
        return listOfCategories;
    }

    public void goToRandomCategory() throws IOException {
        categories.get(new Random().ints(2,(categories.size()+1)).findFirst().getAsInt());
        //categories.get(new Random().nextInt(((categories.size()-2)+1)+2)).click();
    }

    public void backToMainPage() throws IOException {
        BrowserDriver.browserDriver().findElement(goToMainPage).click();
    }

    public void goToAllCategories() throws IOException {
        BrowserDriver.browserDriver().findElement(allCategoriesButton).click();
    }

    public ArrayList<String> copyAllCategories() throws IOException {
        ArrayList<WebElement> allCat = (ArrayList<WebElement>) BrowserDriver.browserDriver().findElements(allCategories);
        ArrayList<String> allCatString = new ArrayList<String>();
        for (WebElement webElement : allCat) {
            allCatString.add(webElement.getText());
        }
        CSVFileWrite csvFileWrite = new CSVFileWrite();
        csvFileWrite.fileWrite(allCatString);
        return allCatString;
    }

    public void logOutFunction() throws IOException {
        BrowserDriver.browserDriver().findElement(accountIcon).click();
        LogOutForm logOutForm = new LogOutForm(BrowserDriver.browserDriver());
    }

}
