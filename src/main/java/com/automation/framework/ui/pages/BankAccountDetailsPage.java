package com.automation.framework.ui.pages;

import com.automation.framework.ui.utils.WaitUtils;
import org.openqa.selenium.By;

public class BankAccountDetailsPage {

    private By heading = By.xpath("//h2[@data-cy='bankAccountDetailsHeading']");
    private By backBtn = By.xpath("//button[@data-cy='entityDetailsBackButton']");

    public boolean isDetailsPageDisplayed() {
        return WaitUtils.waitForElement(heading).isDisplayed();
    }

    public void clickBack() {
        WaitUtils.waitForElement(backBtn).click();
    }
}