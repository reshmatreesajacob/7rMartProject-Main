package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	// Creating a single instance of ExtentReports that can be used throughout the
	// project
	public static final ExtentReports extentReports = new ExtentReports();

	// Synchronized method to ensure thread safety and avoid overlapping issues
	public synchronized static ExtentReports createExtentReports() {

		// Creating an ExtentSparkReporter instance & specifying the location of the
		// report file
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");

		reporter.config().setReportName("7rMartProject"); // Setting the name of the report
		extentReports.attachReporter(reporter); // Attaching the reporter to ExtentReports instance
		extentReports.setSystemInfo("Organization", "Obsqura"); // Adding system information to the report
		extentReports.setSystemInfo("Name", " Reshma ");

		return extentReports; // Returning the ExtentReports instance

	}

}
