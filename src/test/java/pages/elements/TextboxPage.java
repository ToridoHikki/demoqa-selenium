package pages.elements;

import org.openqa.selenium.By;

import static utils.CommonActions.*;

public class TextboxPage {

    public void open() {
        visit("https://demoqa.com/text-box");
    }

    public void fillForm(String fullName, String email, String currentAddress, String permanentAddress) {
        fill(By.cssSelector("input[placeholder='Full Name']"), fullName);
        fill(By.xpath("//input[@placeholder='name@example.com']"), email);
        fill(By.cssSelector("#currentAddress"), currentAddress);
        fill(By.cssSelector("#permanentAddress"), permanentAddress);
    }

    public void clickSubmit() {
        click(By.cssSelector("#submit"));
    }
    public String getFullName() {
         return getText(By.cssSelector("#name"));
    }
    public void getEmail() {
         getText(By.cssSelector("#email"));
    }
    public void getCurrentAddress() {
        getText(By.cssSelector("#currentAddress"));
    }
    public void getPermanentAddress() {
        getText(By.cssSelector("#permanentAddress"));
    }





}
