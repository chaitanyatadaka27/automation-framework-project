package com.automation.framework.ui.pages;

import com.automation.framework.ui.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automation.framework.ui.driver.DriverManager;

import java.time.Duration;

import static com.automation.framework.ui.utils.WaitUtils.waitForElement;

public class BankAccountPage {

    private By firstRow = By.xpath("//table//tbody/tr");

    private By viewBtn = By.xpath("(//table//tbody//a[contains(@class,'btn-info')])[1]");
    private By deleteBtn = By.xpath("(//table//tbody//button[contains(@class,'btn-danger')])[1]");
    private By confirmDeleteBtn = By.id("jhi-confirm-delete-bankAccount");

    private By successAlert = By.xpath("//ngb-alert");

    private By createBankAcc = By.xpath("//span[@jhitranslate='jhipsterSampleApplicationApp.bankAccount.home.createLabel']");

    public void waitForPageToLoad() {
        waitForElement(firstRow);
    }

    public void clickView() {
        waitForElement(viewBtn).click();
    }

    public void clickDelete() {
        waitForElement(deleteBtn).click();
    }

    public void confirmDelete() {
        waitForElement(confirmDeleteBtn).click();
    }

    public void clickCreateBankAccount() {
        waitForElement(createBankAcc).click();
    }

    public String getSuccessMessage() {

        WebElement alert = waitForElement(successAlert);

        return alert.getText();
    }
}