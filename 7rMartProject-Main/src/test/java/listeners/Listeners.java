package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import automationCore.Base;
import utilities.ExtentReportUtility;

//Implements TestNG's ITestListener to generate detailed ExtentReports for test cases.
public class Listeners extends Base implements ITestListener {

	ExtentTest test; // Stores individual test instances for reporting
	ExtentReports extent = ExtentReportUtility.createExtentReports(); // Gets the ExtentReports instance
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // ThreadLocal ensures thread safety for
																		// parallel execution

	// Triggered when a test starts
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		// Creates a new test entry in the report
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); // Stores the test instance for the current thread
	}

	// This method is called when a test case executes successfully.
	public void onTestSuccess(ITestResult result) {

		// Calls the default implementation from ITestListener.
		ITestListener.super.onTestSuccess(result);
		// Logs the test status as "PASS" in the Extent Report.
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	// This method is called when a test case fails.
	public void onTestFailure(ITestResult result) { // Called when a test method fails.

		// Calls the default implementation from ITestListener.
		ITestListener.super.onTestFailure(result);
		// Logs the test status as "FAIL" in the Extent Report
		extentTest.get().log(Status.FAIL, "Test Failed");
		// Captures and logs the exception/error message that caused the test to fail.
		extentTest.get().fail(result.getThrowable());
		// Declaring WebDriver instance to capture the current browser state if needed.
		WebDriver driver = null;
		// Retrieves the name of the failed test method.

		String testMethodName = result.getMethod().getMethodName();
		try {
			// Using reflection to get the WebDriver instance from the test class.
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {
			e.printStackTrace(); // Prints exception details if there is an issue accessing the WebDriver.
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		try {
			// Re-attempting to get the WebDriver instance (This block is redundant and can
			// be removed).
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			// This catch block is empty, meaning exceptions will be ignored.
			// Ideally, it should at least log the exception or handle it properly.
		}
	}

	// This method is called when a test case is skipped (not executed).

	public void onTestSkipped(ITestResult result) {
		// Calls the default implementation from ITestListener.
		ITestListener.super.onTestSkipped(result);
		// Logs the test status as "SKIP" in the Extent Report.
		extentTest.get().log(Status.SKIP, "Test Skipped");
		// Retrieves the name of the skipped test method.
		String testMethodName = result.getMethod().getMethodName();
	}

	// Triggered when a test case fails but is within the allowed success percentage
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		// Calls the default implementation of this method from ITestListener (usually
		// does nothing unless overridden).
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	// This method is triggered when a test case fails due to a timeout (exceeds the
	// maximum execution time limit).
	public void onTestFailedWithTimeout(ITestResult result) {

		// Calls the default implementation of this method from ITestListener.
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	// This method is triggered before any test methods are executed within a test
	// suite.
	public void onStart(ITestContext context) {

		// Calls the default implementation of this method from ITestListener.
		// This can be used to set up configurations or initialize resources before
		// tests start.
		ITestListener.super.onStart(context);
	}

	// Triggered when all test cases in the suite have finished execution.
	public void onFinish(ITestContext context) {

		// Calls the default implementation of the ITestListener interface.
		// This is optional and usually does nothing unless the parent class has a
		// specific implementation.
		ITestListener.super.onFinish(context);

		// Writes all the test logs, results, and statuses to the Extent Report file.
		// Without this, the report will not be saved, and test results won’t appear in
		// the HTML report.
		extent.flush();

	}

}
