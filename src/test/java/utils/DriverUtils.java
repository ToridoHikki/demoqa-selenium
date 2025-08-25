package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.time.Duration;


public class DriverUtils {

    private final WebDriver driver;
    public static WebDriverWait wait;


    public DriverUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForElementVisible(By by, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement find(By locator) {
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(locator))
                .findElement(locator);
//                driver.findElement(locator);
    }



    public void click(By by) {
        wait
                .until(ExpectedConditions.elementToBeClickable(by))
                .click();

    }

    public void takeScreenshot(String filePath) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    public void fill(By by, String text) {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    public String getElementText(By by) {
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(by))
                .getText();

    }


    public void check(By by) {
        if (!isSelected(by)) {
            click(by);
        }
    }

    public void uncheck(By by) {
        if (isSelected(by)) {
            click(by);
        }
    }

    public boolean isSelected(By by) {
        return driver.findElement(by).isSelected();
    }

    public boolean isVisible(By by) {
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(by))
                .isDisplayed();
    }

    public Select getSelect(By by) {
        return new Select(driver.findElement(by));
    }

    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator); // Tìm phần tử theo locator
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element); // Cuộn đến phần tử
    }

    public String getCurrentURL () {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void uploadFile(By by, String filePath) {

        File file = new File(filePath);
        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(by)).findElement(by);
        fileInput.sendKeys(file.getAbsolutePath());
    }

    public String getText(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
    }
}

