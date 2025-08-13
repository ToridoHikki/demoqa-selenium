package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.CommonActions.wait;

public class Browsers {

    public static WebDriver driver;
    public static WebDriverWait wait;


    public static WebDriver openBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                driver = new ChromeDriver();
                break;
            case "chrome-headless":
                ChromeOptions headlessOptions = new ChromeOptions();
                headlessOptions.addArguments("headless");
                driver = new ChromeDriver(headlessOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return driver;
    }


}
