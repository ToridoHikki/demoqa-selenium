package pages.elements;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import utils.Browsers;

public class Base extends Browsers{

    @BeforeClass
    @Parameter(names = "headless")
    public void setUp(@Optional("false") String headless) {
        ChromeOptions options = new ChromeOptions();
        if (headless.equalsIgnoreCase("true")) {
            options.addArguments("--headless=new");
        }
        driver = new ChromeDriver(options);


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
