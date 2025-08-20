package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverUtils;

public class LoginPage {

    private final DriverUtils driverUtils;


    public LoginPage(WebDriver driver) {
        this.driverUtils = new DriverUtils(driver);
    }

    public void navigateToLoginPage() {
        driverUtils.click(By.cssSelector("a[href='/login']"));
    }

    public boolean isVisible(String text) {
        return driverUtils.isVisible(By.xpath(String.format("//*[.='%s']", text)));
    }

    public void fillLoginForm(String email, String password){
        driverUtils.fill(By.cssSelector("input[data-qa='login-email']"), email);
        driverUtils.fill(By.cssSelector("input[data-qa='login-password']"), password);

    }

    public void clickLoginButton() {
        driverUtils.click(By.cssSelector("button[data-qa='login-button']"));
    }

    public String getUserNameLoggedIn() {
       return driverUtils.getElementText(By.xpath("//a[i[@class='fa fa-user']]"));
    }

    public String getTextErrorMessage() {
        return driverUtils.getElementText(By.xpath("//p[.='Your email or password is incorrect!']"));
    }

    public void clickLogoutButton() {
        driverUtils.click(By.cssSelector("a[href='/logout']"));
    }

    public String getLoginPageTitle(){
        return driverUtils.getPageTitle();
    }


}
