package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverUtils;

import java.util.Objects;

public class SignUpPage {

    private final DriverUtils driverUtils;

    public SignUpPage(WebDriver driver) {
        this.driverUtils = new DriverUtils(driver); // khởi tạo DriverUtils
    }

    //    public void openSignUpPage() {
//        driver.get("https://automationexercise.com/login");
//    }
    public void navigateToSignUpPage() {
        driverUtils.click(By.cssSelector("a[href='/login']"));
    }

    public boolean isVisible(String text) {
        return driverUtils.isVisible(By.xpath(String.format("//*[.='%s']", text)));
    }

    ;

    public void fillSignUpForm(String name, String email) {
        driverUtils.fill(By.cssSelector("input[data-qa='signup-name']"), name);
        driverUtils.fill(By.cssSelector("input[data-qa='signup-email']"), email);
    }

    public void selectGender(String gender) {
        if (Objects.equals(gender, "Mrs.")) {
            driverUtils.click(By.id("uniform-id_gender2"));
        } else {
            driverUtils.click(By.id("uniform-id_gender1"));
        }
    }

    public void selectDay(String day) {
        driverUtils.getSelect(By.cssSelector("[data-qa='days']"))
                .selectByVisibleText(day);
    }

    public void selectMonth(String month) {
        driverUtils.getSelect(By.cssSelector("[data-qa='months']"))
                .selectByVisibleText(month);
    }

    public void selectYear(String year) {
        driverUtils.getSelect(By.cssSelector("[data-qa='years']"))
                .selectByVisibleText(year);
    }



    public void clickSignUpButton() {
        driverUtils.click(By.cssSelector("[data-qa='signup-button']"));
    }

    public void enterAccountInformation(String gender, String name, String password, String day, String month, String year
            , boolean newsletter, boolean offers) {
        selectGender(gender);

        driverUtils.fill(By.cssSelector("input[data-qa='name']"), name);
        driverUtils.fill(By.cssSelector("input[data-qa='password']"), password);
        selectDay(day);
        selectMonth(month);
        selectYear(year);
        scrollToSignUpCheckbox();
        if (newsletter) {
            driverUtils.check(By.id("newsletter"));
        }
        if (offers) {
            driverUtils.check(By.cssSelector("optin"));
        }

    }

    public void enterAddressInformation(String firstName, String lastName, String company, String address, String address2,
                                        String country, String state, String city, String zipcode, String phoneNumber){

        driverUtils.fill(By.cssSelector("input[data-qa='first_name']"), firstName);
        driverUtils.fill(By.cssSelector("input[data-qa='last_name']"), lastName);
        driverUtils.fill(By.cssSelector("input[data-qa='company']"), company);
        driverUtils.fill(By.cssSelector("input[data-qa='address']"), address);
        driverUtils.fill(By.cssSelector("input[data-qa='address2']"), address2);
        driverUtils.getSelect(By.cssSelector("select[data-qa='country']"))
                .selectByVisibleText(country);
        driverUtils.fill(By.cssSelector("input[data-qa='state']"), state);
        driverUtils.fill(By.cssSelector("input[data-qa='city']"), city);
        driverUtils.fill(By.cssSelector("input[data-qa='zipcode']"), zipcode);
        driverUtils.fill(By.cssSelector("input[data-qa='mobile_number']"), phoneNumber);

    };

    public void clickCreateAccountButton() {
        driverUtils.click(By.cssSelector("[data-qa='create-account']"));
    }

    public void clickContinueButton() {
        driverUtils.click(By.cssSelector("[data-qa='continue-button']"));
    }

    public void clickDeleteAccountButton() {
        driverUtils.click(By.cssSelector("a[href='/delete_account']"));
    }

    public String getUserNameLoggedIn () {
         return driverUtils.getElementText(By.xpath("//a[i[@class='fa fa-user']]"));
    };

    public String getErrorMessage() {
        return driverUtils.getElementText(By.xpath("//p[.='Email Address already exist!']"));
    }

    public void scrollToCreateButton() {
        driverUtils.scrollToElement(By.cssSelector("[data-qa='create-account']"));

    }

    public void scrollToSignUpCheckbox() {
        driverUtils.scrollToElement(By.id("newsletter"));
    }









}
