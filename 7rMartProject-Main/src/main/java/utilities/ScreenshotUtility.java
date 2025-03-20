package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

	// Method to capture the screenshot & store it as a file if any testcases fails
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {

		// Casting WebDriver to TakesScreenshot interface
		TakesScreenshot scrShot = (TakesScreenshot) driver;

		// Get screenshot as a file
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);

		// Create a timestamp to differentiate screenshots for different failures
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());

		// Define the output directory where screenshots will be saved
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");

		// Check if the directory exists; if not, create it
		if (!f1.exists()) {
			// Create the directory if it doesn’t exist
			f1.mkdirs();
		}

		// Define the full path for the screenshot file, including timestamp and test
		// case name
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
				+ ".png";

		// Create a new File object pointing to the final destination of the screenshot
		File finalDestination = new File(destination);

		// Copy the screenshot file to the specified destination
		FileHandler.copy(screenShot, finalDestination);

	}

}
