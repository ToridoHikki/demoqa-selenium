package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.elements.TextboxPage;
import utils.CommonActions;

import static utils.Browsers.openBrowser;
import static utils.CommonActions.driver;

public class TextboxTest {

    //1. Mở https://demoqa.com/text-box
    //2. Nhập Full Name, Email, Address
    //3. Nhấn Submit
    TextboxPage textboxPage;

    @BeforeMethod
    public void setup() {
        openBrowser("chrome");
        textboxPage = new TextboxPage();
        textboxPage.open();


    }

    @DataProvider(name = "TC01-Validate Information")
    public Object [][] fullData() {
        return new Object[][]{
                {"Tran Thuy Vy", "thuyvy@gmail.com", "123 Le Loi, HCM", "456 Le Loi, HCM"},
                {"Truong Van Dom", "truongdom@gmail.com", "789 Le Loi, HCM", "101112 Le Loi, HCM"}
        };
    }

    @DataProvider(name = "TC02-Invalid Information", parallel = true)

    @Test (dataProvider = "TC01-Validate Information")
    public void verifyInformationSubmission(String fullName, String email, String currentAddress, String permanentAddress) {
        textboxPage.fillForm(fullName, email, currentAddress, permanentAddress);
        textboxPage.clickSubmit();
        Assert.assertEquals(textboxPage.getFullName(), "Name:" + fullName, "Full Name does not match");
    }
}
