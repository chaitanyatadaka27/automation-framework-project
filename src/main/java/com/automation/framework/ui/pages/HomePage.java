package com.automation.framework.ui.pages;

import com.automation.framework.ui.driver.DriverManager;
import com.automation.framework.ui.utils.WaitUtils;
import org.openqa.selenium.By;

public class HomePage {

    private By signInLink = By.xpath("//a[normalize-space()='sign in']");
    private By accountMenu = By.xpath("//span[@jhitranslate='global.menu.account.main']");
    private By logoutOption = By.xpath("//span[@jhitranslate='global.menu.account.logout']");

    private By entitiesMenu = By.xpath("//span[text()='Entities']");
    private By bankAccountOption = By.xpath("//span[text()='Bank Account']");

    private By loginVisibleElement = By.xpath("//a[normalize-space()='sign in']");

    public void clickSignIn() {
        DriverManager.getDriver().findElement(signInLink).click();
    }

    public void openAccountMenu() {
        WaitUtils.waitForElement(accountMenu).click();
    }

    public void clickLogout() {
        WaitUtils.waitForElement(logoutOption).click();
    }

    public void navigateToLogout() {
        openAccountMenu();
        clickLogout();
    }

    public void openEntitiesMenu() {
        WaitUtils.waitForElement(entitiesMenu).click();
    }

    public void clickBankAccount() {
        WaitUtils.waitForElement(bankAccountOption).click();
    }

    public void navigateToBankAccount() {
        openEntitiesMenu();
        clickBankAccount();
    }

    public boolean isLoginVisible() {
        return WaitUtils.waitForElement(loginVisibleElement).isDisplayed();
    }
}