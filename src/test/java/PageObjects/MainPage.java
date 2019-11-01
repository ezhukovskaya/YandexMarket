package PageObjects;

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
    private LogOutForm logOutForm;
    private By pathCategories = By.cssSelector(".n-w-tabs__horizontal-tabs>*");
    private By accountIcon = By.xpath("/html/body/div[1]/div/div[1]/noindex/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[1]/div[1]/a/span[1]");
    private WebDriver driver;
    ArrayList<WebElement> categories;
    ArrayList<WebElement> allCat;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public ArrayList<String> getCategories() throws IOException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        categories = (ArrayList<WebElement>) driver.findElements(pathCategories);
        categories.trimToSize();
        ArrayList<String> listOfCategories = new ArrayList<String>();
        FileWriter writer = new FileWriter("topCategories");
        int j = 2;
        for (int i = 0; i < categories.size(); i++, j++) {
            if (categories.get(i).getText().length() < 2) {
                i=categories.size();
            } else {
                listOfCategories.add(categories.get(j).getText());
                writer.write(listOfCategories.get(i) + "\n");
            }
        }
        listOfCategories.trimToSize();
        writer.flush();
        return listOfCategories;
    }

    public void goToRandomCategory() throws IOException {
        categories.get(new Random().ints(2,(categories.size()+1)).findFirst().getAsInt());
        //categories.get(new Random().nextInt(((categories.size()-2)+1)+2)).click();
    }

    public void backToMainPage() {
        driver.findElement(goToMainPage).click();
    }

    public void goToAllCategories(){
        driver.findElement(allCategoriesButton).click();
    }

    public ArrayList<String> copyAllCategories() throws IOException {
        allCat = (ArrayList<WebElement>) driver.findElements(allCategories);
        ArrayList<String> allCatString = new ArrayList<String>();
        FileWriter writer = new FileWriter("file.csv");
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        for(int i=0;i<allCat.size();i++){
            allCatString.add(allCat.get(i).getText());
            csvPrinter.printRecord(allCatString.get(i));
        }
        csvPrinter.flush();
        return allCatString;
    }

    public void logOutFunction() {
        driver.findElement(accountIcon).click();
        logOutForm = new LogOutForm(driver);
    }

}
