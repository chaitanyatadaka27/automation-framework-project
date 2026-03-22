package com.automation.framework.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import com.automation.framework.core.config.ConfigReader;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private final int maxRetry = Integer.parseInt(ConfigReader.get("retry.count"));

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxRetry) {
            count++;
            System.out.println("🔁 Retrying: " + result.getName() + " | Attempt: " + count);
            return true;
        }

        return false;
    }
}