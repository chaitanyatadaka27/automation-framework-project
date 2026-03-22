package com.automation.framework.listeners;

import com.automation.framework.ui.driver.DriverManager;
import com.aventstack.extentreports.*;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.*;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private String takeScreenshot(String testName) {

        File src = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.FILE);

        String path = "reports/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
        try {
            FileHandler.copy(src, new File(path));
        } catch (IOException e) {
            System.out.println("Screenshot failed");
        }

        return path;
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String path = takeScreenshot(result.getName());

        test.get().fail(result.getThrowable());

        test.get().addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}