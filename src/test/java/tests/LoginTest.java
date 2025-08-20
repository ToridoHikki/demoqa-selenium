package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    //username:huynhnhu
    //password:123456789

    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
    }

    @Test
    public void loginSuccess_with_ValidCredentials() {
        Assert.assertTrue(loginPage.isVisible("Login to your account"), "Login page is not visible");

        loginPage.fillLoginForm("nhuhuynh@gmail.com", "123456789");
        loginPage.clickLoginButton();
        String expectedText = loginPage.getUserNameLoggedIn();
        Assert.assertEquals(expectedText, "Logged in as huynhnhu", "User name is not displayed correctly after login");
    }

    @Test
    public void loginFail_with_InvalidCredentials() {
        Assert.assertTrue(loginPage.isVisible("Login to your account"), "Login page is not visible");

        loginPage.fillLoginForm("failemail@email.com", "wrongpassword");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getTextErrorMessage(), "Your email or password is incorrect!", "Error message is not displayed correctly");
        Assert.assertTrue(loginPage.isVisible(loginPage.getTextErrorMessage()));
    }

    @Test
    public void logOutSuccess() {
        Assert.assertTrue(loginPage.isVisible("Login to your account"), "Login page is not visible");

        loginPage.fillLoginForm("nhuhuynh@gmail.com", "123456789");
        loginPage.clickLoginButton();
        loginPage.clickLogoutButton();
        System.out.println(loginPage.getLoginPageTitle());
        Assert.assertEquals(loginPage.getLoginPageTitle(),"Automation Exercise - Signup / Login");

    }
}
