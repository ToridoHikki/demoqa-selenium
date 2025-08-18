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
import java.util.HashMap;
import java.util.Map;

import static utils.CommonActions.wait;

public class Browsers {

    public static WebDriver driver;
    public static WebDriverWait wait;


    public static WebDriver openBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                // Chặn save password + password leak detection
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("profile.default_content_setting_values.notifications", 2); // Block notifications
                prefs.put("profile.default_content_setting_values.geolocation", 2);    // Block location
                prefs.put("autofill.profile_enabled", false); // Disable autofill

                chromeOptions.setExperimentalOption("prefs", prefs);

                // Chặn thông báo "Change your password"
                chromeOptions.addArguments("--disable-features=PasswordManagerEnabled");
                chromeOptions.addArguments("--disable-features=PasswordLeakDetection");
                chromeOptions.addArguments("--disable-features=PasswordCheck");

                // Chạy incognito để không dùng mật khẩu đã lưu
                chromeOptions.addArguments("--incognito");

                // Loại bỏ "Chrome is being controlled by automated software"
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                chromeOptions.setExperimentalOption("useAutomationExtension", false);
                chromeOptions.addArguments("headless");
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
