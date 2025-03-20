package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(priority = 1, description = "Verification of user login with valid Credentials", groups = {
			"smoke" }, retryAnalyzer = retry.ReTry.class)
	public void verifyUserLoginWithValidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		// chainning of methods
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox()
				.clickOnSignInButton();

		boolean isDashboardDisplayed = login.isDashboardDisplayed();
		Assert.assertTrue(isDashboardDisplayed, Messages.VALIDCREDENTIALERROR);

	}

	@Test(priority = 2, description = "Verification of user login with valid username and invalid password", groups = {
			"smoke" })
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {

		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox()
				.clickOnSignInButton();

		boolean isTitleDisplayed = login.isTitleDisplayed();
		Assert.assertTrue(isTitleDisplayed, Messages.INVALIDPASSWORDERROR);

	}

	@Test(priority = 3, description = "Verification of user login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox()
				.clickOnSignInButton();

		boolean isTitleDisplayed = login.isTitleDisplayed();
		Assert.assertTrue(isTitleDisplayed, Messages.INVALIDUSERNAMEERROR);
	}

	@Test(priority = 4, description = "Verification of user login with invalid username and invalid password", dataProvider = "loginProvider")
	public void verifyUserLoginWithInvalidUsernameAndInvalidPassword(String username, String password)
			throws IOException {
//		String username = ExcelUtility.readStringData(4, 0, "LoginPage");
//		String password = ExcelUtility.readStringData(4, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);

		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox()
				.clickOnSignInButton();

		boolean isTitleDisplayed = login.isTitleDisplayed();
		Assert.assertTrue(isTitleDisplayed, Messages.INVALIDCREDENTIALERROR);
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {
		return new Object[][] { // new Object[] { "admin", "admin" },
				new Object[] { "admin", "Test" }, new Object[] { "Test", "admin" }, new Object[] { "Test", "Test" }
//			,new Object[] {ExcelUtility.readStringData(4, 0, "LoginPage"),
//					ExcelUtility.readStringData(4, 1, "LoginPage")}
		};
	}

}
