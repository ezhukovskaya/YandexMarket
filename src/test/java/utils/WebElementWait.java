package utils;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementWait {
    private static WebElementWait webElementWait;

    /**
     * метод для определения ожидания появления элемента
     *
     * @param by локатор для веб-элемента
     */
    public static void waiterForWebElement(By by) {
        WebElement dynamicElement = (new WebDriverWait(Browser.getDriver(), Integer.parseInt(PropertiesRead.readFromPropertiesFile("timeout")))).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * возвращение значения веб-элемента
     *
     * @param by локатор
     * @return
     */
    public static WebElement getWebElement(By by) {
        return Browser.getDriver().findElement(by);
    }

}
