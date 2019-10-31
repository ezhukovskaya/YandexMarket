package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage {
    private LogOutForm logOutForm;
    private By pathCategories = By.cssSelector(".n-w-tabs__horizontal-tabs>*");
    private By accountIcon = By.xpath("/html/body/div[1]/div/div[1]/noindex/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[1]/div[1]/a/span[1]");
    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public ArrayList<String> getCategories() throws IOException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //WebElement dynamicElement = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(pathCategories));
        List<WebElement> categories = driver.findElements(pathCategories);
        ArrayList<String> listOfCategories = new ArrayList<String>();
        for(int i=2;i<categories.size();i++){
            if(categories.get(i).getText().length()<2){
                i=categories.size();
            }else {
                listOfCategories.add(categories.get(i).getText());
            }
        }
        return listOfCategories;
    }

    public void logOutFunction(){
        driver.findElement(accountIcon).click();
        logOutForm = new LogOutForm(driver);
    }
}
