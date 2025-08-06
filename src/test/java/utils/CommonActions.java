package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CommonActions extends Browsers {

    public static WebDriver getDriver() {
        return driver;
    }

    public static void visit(String url) {
        driver.get(url);
    }
    public static void click(By by) {
        wait
                .until(ExpectedConditions.elementToBeClickable(by))
                .click();
    }

    public static void fill(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static String getText(By by) {
       return wait
                .until(ExpectedConditions.visibilityOfElementLocated(by))
                .getText();
    };


}

