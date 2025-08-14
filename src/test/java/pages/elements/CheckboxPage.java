package pages.elements;

import org.openqa.selenium.By;
import utils.CommonActions;

import static utils.CommonActions.visit;

public class CheckboxPage {
    public void open() {
        visit("https://demoqa.com/checkbox");
    }

    public void expand(String folderName) {
        CommonActions.click(
                By.xpath("//span[@class='rct-title' and text()='" + folderName + "']/ancestor::span[@class='rct-text']//button[@class='rct-collapse rct-collapse-btn']")
        );

    }

    public void check(String checkboxName) {
        CommonActions.check(By.xpath("//span[.='" + checkboxName + "']/preceding-sibling::span[1]::[@class=['rct-checkbox']"));
    }

    public boolean isChecked(String checkboxName) {
        return CommonActions
                .isSelected(By.xpath("//span[@class='rct-title' and text()='" + checkboxName + "']/parent::label"));
    }


}
