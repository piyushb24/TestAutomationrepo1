package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseClass;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();

        WebDriver driver = null;

        // Safely get driver if test extends BaseClass (thread-safe)
        if (testClass instanceof BaseClass) {
            driver = ((BaseClass) testClass).getDriver();
        }

        String testName = result.getMethod().getMethodName();

        // Debug logs to check driver state
        System.out.println("Attempting to take screenshot for: " + testName);
        System.out.println("Driver null? " + (driver == null));
        if (driver != null) {
            try {
                System.out.println("Current URL: " + driver.getCurrentUrl());
            } catch (Exception e) {
                System.out.println("Unable to get current URL: " + e.getMessage());
            }
        }

        // Include exception type in filename for clarity
        String exceptionName = result.getThrowable() != null
                ? result.getThrowable().getClass().getSimpleName()
                : "Error";

        // Capture screenshot
        ScreenshotUtil.takeScreenshot(driver, testName + "_" + exceptionName);
        System.out.println("Screenshot captured for failed test: " + testName);
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
