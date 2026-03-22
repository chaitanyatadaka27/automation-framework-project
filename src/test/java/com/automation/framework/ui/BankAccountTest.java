package com.automation.framework.ui;

import com.automation.framework.listeners.RetryAnalyzer;
import com.automation.framework.listeners.TestListener;
import com.automation.framework.ui.base.BaseTest;
import com.automation.framework.ui.pages.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class BankAccountTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void shouldViewBankAccountDetails() {

        login();               // reused
        goToBankAccount();     // reused

        BankAccountPage page = new BankAccountPage();
        page.waitForPageToLoad();
        page.clickView();

        Assert.assertTrue(
                new BankAccountDetailsPage().isDetailsPageDisplayed(),
                "Details page not displayed"
        );
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void shouldDeleteBankAccount() {

        login();
        goToBankAccount();

        BankAccountPage page = new BankAccountPage();
        page.waitForPageToLoad();

        page.clickDelete();
        page.confirmDelete();

        String msg = page.getSuccessMessage();

        Assert.assertTrue(
                msg.toLowerCase().contains("deleted"),
                "Delete failed"
        );
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void shouldCreateBankAccount() {

        login();
        goToBankAccount();

        BankAccountPage bankPage = new BankAccountPage();
        bankPage.clickCreateBankAccount();

        CreateBankAccountPage createPage = new CreateBankAccountPage();
        createPage.createAccount("TestAccount", "5000");

        String msg = createPage.getSuccessMessage();

        Assert.assertTrue(
                msg.toLowerCase().contains("created"),
                "Creation failed"
        );
    }
}