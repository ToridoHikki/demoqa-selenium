package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.elements.CheckboxPage;

import static utils.Browsers.openBrowser;

public class CheckboxTest {
    CheckboxPage checkboxPage;

    @BeforeClass
    public void setUp() {
        openBrowser("chrome");
        checkboxPage = new CheckboxPage();
        checkboxPage.open();
    }

    @Test
    public void verifyOneCheckboxWorking() {
        checkboxPage.expand("Home");
        checkboxPage.check("Desktop");
        Assert.assertTrue(checkboxPage.isChecked("Desktop"));
    }

    @Test
    public void verifyMultipleCheckboxesWorking() {
        checkboxPage.expand("Home");
        checkboxPage.check("Documents");
        Assert.assertTrue(checkboxPage.isChecked("Documents"));

        checkboxPage.expand("Home");
        checkboxPage.check("Downloads");
        Assert.assertTrue(checkboxPage.isChecked("Downloads"));

        checkboxPage.expand("Home");
        checkboxPage.check("Office");
        Assert.assertTrue(checkboxPage.isChecked("Office"));
    }


}
