package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignUpPage;

public class RegisterTest extends BaseTest {

    SignUpPage signUpPage;

    @BeforeMethod
    public void setUp() {
        signUpPage = new SignUpPage(driver);
        signUpPage.navigateToSignUpPage();
    }


    @Test
    public void verifyRegisterSuccess() {
        Assert.assertTrue(signUpPage.isVisible("New User Signup!"), "Sign up page is not visible");

        signUpPage.fillSignUpForm("Test User", "test2user100@yopmail.com");
        signUpPage.clickSignUpButton();
        Assert.assertTrue(signUpPage.isVisible("Enter Account Information"), "Account information page is not visible");

        signUpPage.enterAccountInformation("Mrs.", "Test", "123456789", "1", "January",
                "2021", true, false);
        signUpPage.enterAddressInformation("Nhu", "Huynh", "Start", "124 AN PHU DONG",
                "PHUCountry","Canada", "1234567890", "Vancouver", "Vancouver", "0931232");

        signUpPage.scrollToCreateButton();
        signUpPage.clickCreateAccountButton();
        Assert.assertTrue(signUpPage.isVisible("Account Created!"));

        signUpPage.clickContinueButton();
        String expectedInfo = signUpPage.getUserNameLoggedIn();
        Assert.assertEquals(expectedInfo, "Logged in as Test");

        signUpPage.clickDeleteAccountButton();
        Assert.assertTrue(signUpPage.isVisible("Account Deleted!"), "Account deleted message is not visible");
        signUpPage.clickContinueButton();
    }

    @Test
    public void verifyRegisterFail_withExistingEmail() {
        Assert.assertTrue(signUpPage.isVisible("New User Signup!"), "Sign up page is not visible");

        signUpPage.fillSignUpForm("huynhnhu", "nhuhuynh@gmail.com");
        signUpPage.clickSignUpButton();
        Assert.assertEquals(signUpPage.getErrorMessage(),"Email Address already exist!",
                "Error message is not displayed correctly");
        Assert.assertTrue(signUpPage.isVisible(signUpPage.getErrorMessage()));
    }






}
