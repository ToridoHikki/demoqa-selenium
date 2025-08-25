package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsTest extends BaseTest {

    ContactUsPage contactUsPage;


    @BeforeMethod
    public void setUp() {
        contactUsPage = new ContactUsPage(driver);
        contactUsPage.navigateToContactUsPage();
    }

    @Test
    public void verifyContactUsFormFilledSuccess() {
        contactUsPage.fillContactUsForm("Huynh Nhu", "nhuhuynh@gmail.com", "Subject test" ,
                "This is message for test");
        contactUsPage.uploadFile("/Users/torido/Projects/plamn/Lich_trinh_hoc_Selenium_Java_TestNG.xlsx");
        String fileName = contactUsPage.getFileUploadName();
        String expectedText = "Lich_trinh_hoc_Selenium_Java_TestNG.xlsx";
        Assert.assertEquals(fileName, expectedText);
        contactUsPage.clickSubmitButton();
        String successMessage = contactUsPage.getSuccessMessage();
        Assert.assertEquals(successMessage, "Success! Your details have been submitted successfully.");
        contactUsPage.clickHomeButton();
    }

}
