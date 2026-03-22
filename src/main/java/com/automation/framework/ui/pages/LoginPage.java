package com.automation.framework.ui.pages;

import com.automation.framework.ui.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.xpath("//button[normalize-space()='Sign in']");
    private By loginError = By.xpath("//strong[contains(text(),'Failed to sign in')]");

    public void login(String user, String pass) {

        WebElement userField = WaitUtils.waitForElement(username);
        userField.clear();
        userField.sendKeys(user);

        WebElement passField = WaitUtils.waitForElement(password);
        passField.clear();
        passField.sendKeys(pass);

        WaitUtils.waitForElement(loginBtn).click();
    }

    public String getErrorMessage() {
        try {
            return WaitUtils.waitForElement(loginError).getText();
        } catch (Exception e) {
            return "";
        }
    }
}