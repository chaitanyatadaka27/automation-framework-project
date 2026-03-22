package com.automation.framework.core.exceptions;

import org.openqa.selenium.By;

public class ElementNotFoundException extends FrameworkException {

    public ElementNotFoundException(By locator) {
        super("Element not found: " + locator.toString());
    }

    public ElementNotFoundException(By locator, Throwable cause) {
        super("Element not found: " + locator.toString(), cause);
    }
}