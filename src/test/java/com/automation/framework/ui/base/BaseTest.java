package com.automation.framework.ui.base;

import com.automation.framework.core.config.ConfigReader;
import com.automation.framework.ui.driver.DriverFactory;
import com.automation.framework.ui.driver.DriverManager;
import com.automation.framework.ui.pages.HomePage;
import com.automation.framework.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {

        WebDriver driver = DriverFactory.initDriver(
                ConfigReader.get("browser")
        );

        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(ConfigReader.get("ui.url"));

        // Initialize common pages
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    // COMMON LOGIN
    protected void login() {
        homePage.clickSignIn();
        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
    }

    // NEGATIVE LOGIN
    protected void loginInvalid() {
        homePage.clickSignIn();
        loginPage.login(
                ConfigReader.get("invalid.username"),
                ConfigReader.get("invalid.password")
        );
    }

    // COMMON NAVIGATION
    protected void goToBankAccount() {
        homePage.navigateToBankAccount();
    }

    protected void logout() {
        homePage.navigateToLogout();
    }

    @AfterMethod
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}