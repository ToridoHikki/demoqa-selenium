package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.DriverUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {

    protected WebDriver driver;
    protected DriverUtils driverUtils;


    @BeforeClass
    public void setUp(String browser) {
        // Disable Selenium logs
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
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

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        driverUtils = new DriverUtils(driver);

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
