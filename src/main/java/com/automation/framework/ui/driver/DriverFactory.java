package com.automation.framework.ui.driver;

import com.automation.framework.core.exceptions.FrameworkException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver initDriver(String browser) {

        WebDriver driver;

        switch (browser.toLowerCase()) {

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--incognito");

                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");

                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;

            default:
                throw new FrameworkException("Invalid browser: " + browser);        }

        return driver;
    }
}