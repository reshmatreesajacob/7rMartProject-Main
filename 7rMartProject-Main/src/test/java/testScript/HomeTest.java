package testScript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	@Test(description = "Verification of whether the user is able to use the Logout functionality after LogIn", retryAnalyzer = retry.ReTry.class)
	public void verifySuccessfullUserLogoutFromHomePageAfterLogin() throws IOException {

		HomePage home;

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();

		home = login.clickOnSignInButton();
		home.clickOnAdminButton();
		login = home.clickOnTheLogoutButton();

		boolean isBackToLoginPage = home.isBackToLoginPage();
		Assert.assertTrue(isBackToLoginPage, Messages.LOGOUTERROR);

	}
}
