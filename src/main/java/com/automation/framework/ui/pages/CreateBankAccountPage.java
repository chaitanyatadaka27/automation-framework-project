package com.automation.framework.ui.pages;

import com.automation.framework.ui.utils.WaitUtils;
import org.openqa.selenium.By;

public class CreateBankAccountPage {

    private By nameField = By.id("field_name");
    private By balanceField = By.id("field_balance");
    private By saveBtn = By.id("save-entity");

    private By successMessage = By.xpath("//pre[contains(text(),'Bank Account')]");

    public void enterName(String name) {
        WaitUtils.waitForElement(nameField).clear();
        WaitUtils.waitForElement(nameField).sendKeys(name);
    }

    public void enterBalance(String balance) {
        WaitUtils.waitForElement(balanceField).clear();
        WaitUtils.waitForElement(balanceField).sendKeys(balance);
    }

    public void clickSave() {
        WaitUtils.waitForElement(saveBtn).click();
    }

    public String getSuccessMessage() {
        return WaitUtils.waitForElement(successMessage).getText();
    }

    public void createAccount(String name, String balance) {
        enterName(name);
        enterBalance(balance);
        clickSave();
    }
}