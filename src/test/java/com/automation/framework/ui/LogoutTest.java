package com.automation.framework.ui;

import com.automation.framework.listeners.RetryAnalyzer;
import com.automation.framework.listeners.TestListener;
import com.automation.framework.ui.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LogoutTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void shouldLogoutSuccessfully() {

        login(); // reused

        logout(); // reused

        Assert.assertTrue(
                homePage.isLoginVisible(),
                "Logout failed"
        );
    }
}