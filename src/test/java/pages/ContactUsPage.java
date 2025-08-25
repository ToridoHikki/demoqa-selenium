package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;

public class ContactUsPage {

    private final DriverUtils driverUtils;
    private final By fileInput = By.xpath("//*[@name='upload_file']");

    public ContactUsPage(WebDriver driver) {
        this.driverUtils = new DriverUtils(driver); // khởi tạo DriverUtils
    }

    public void navigateToContactUsPage() {
        driverUtils.click(By.cssSelector("a[href='/contact_us']"));
    }

    public void fillContactUsForm(String name, String email, String subject, String message) {
        driverUtils.fill(By.xpath("//form[@id='contact-us-form']//input[@data-qa='name']"), name);
        driverUtils.fill(By.xpath("//form[@id='contact-us-form']//input[@data-qa='email']"), email);
        driverUtils.fill(By.xpath("//form[@id='contact-us-form']//input[@data-qa='subject']"), subject);
        driverUtils.fill(By.xpath("//form[@id='contact-us-form']//textarea[@data-qa='message']"), message);
    }

    public void uploadFile(String filePath) {
        driverUtils.uploadFile(fileInput, filePath);
    }

    public String getFileUploadName() {
        WebElement fileElement = driverUtils.find(fileInput);
        String fullPath = fileElement.getDomProperty("value");

        if (fullPath == null || fullPath.isEmpty()) {
            return "";
        }
        return fullPath.substring(fullPath.lastIndexOf("\\") + 1);

    }

    public String getTextFromContactUsPage() {
        return driverUtils.getElementText(By.xpath("//div[@class='contact-form']/h2"));
    }

    public String getSuccessMessage() {
        return driverUtils.getText(By.xpath("//div[@class='status alert alert-success']"));
    }

    public void clickSubmitButton() {
        driverUtils.click(By.xpath("//input[@data-qa='submit-button']"));
    }





}
