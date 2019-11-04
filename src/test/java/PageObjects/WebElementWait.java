package PageObjects;

import Browser.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class WebElementWait {
    /**
     * Инициализация WebDriver в конструкторе
     * @throws IOException
     */
    public WebElementWait() throws IOException {
        BrowserDriver.getInstanceOfSingletonBrowserClass();
    }

    /**
     * метод для определения ожидания появления элемента и возвращение его значения
     * @param by локатор для веб-элемента
     * @return
     * @throws IOException
     */
    public WebElement waiterForWebElement(By by) throws IOException {
        WebElement dynamicElement = (new WebDriverWait(BrowserDriver.browserDriver(), 30)).until(ExpectedConditions.presenceOfElementLocated(by));
        return BrowserDriver.browserDriver().findElement(by);
    }
}
