package com.automation.framework.ui.utils;

import com.automation.framework.core.exceptions.ElementNotFoundException;
import com.automation.framework.ui.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtils {

    public static WebElement waitForElement(By locator) {

        WebDriverWait wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(10)
        );

        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            throw new ElementNotFoundException(locator, e);
        }
    }
}