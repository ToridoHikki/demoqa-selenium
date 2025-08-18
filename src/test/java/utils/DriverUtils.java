package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class DriverUtils {


    private final WebDriver driver;
    private final WebDriverWait wait;


    public DriverUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    public void waitForElementVisible(By by, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
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
        driver.findElement(by).sendKeys(text);
    }

    public void getText(By by) {
        wait
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








}
