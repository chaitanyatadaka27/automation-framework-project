package com.automation.framework.ui;

import com.automation.framework.core.config.ConfigReader;
import com.automation.framework.listeners.RetryAnalyzer;
import com.automation.framework.listeners.TestListener;
import com.automation.framework.ui.base.BaseTest;
import com.automation.framework.ui.utils.WaitUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void shouldLoginSuccessfully() {

        login(); // reused

        String text = WaitUtils.waitForElement(
                By.id("home-logged-message")
        ).getText();

        Assert.assertTrue(
                text.contains(ConfigReader.get("username")),
                "Login failed"
        );
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void shouldFailLogin() {

        loginInvalid(); // reused

        String error = loginPage.getErrorMessage();

        Assert.assertTrue(
                error.contains("Failed to sign in"),
                "Error not shown"
        );
    }
}