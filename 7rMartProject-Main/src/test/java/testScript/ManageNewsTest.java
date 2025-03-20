package testScript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(description = "Verify whether the user can add new news in the News list using New Button")
	public void verifyWhetherUserIsAbleToAddNewNewsInManageNews() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		// chainning of methods
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();

		HomePage home;
		home = login.clickOnSignInButton();

		ManageNewsPage manage;
		manage = home.clickOnManageNewsButton();

//		ManageNewsPage manage = new ManageNewsPage(driver);
//		manage.clickOnManageNewsButton();

		String news = ExcelUtility.readStringData(1, 0, "ManageNewsPage");

		manage.clickOnNewButtonOfManageNewsPage().enterNewNewsOnNewsField(news).clickOnSaveButtonOfNewNewsCreationpage();

		String expectedResult = "Alert!";
		String actualResult = manage.getTextFromAlert();
		Assert.assertEquals(actualResult, expectedResult, Messages.MANAGENEWSCREATIONERROR);
	}

	@Test(description = "Verify whether the user can search a news in the News list using Search Button")
	public void verifyWhetherUserIsAbleTosearchNewsInManageNews() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		// chainning of methods
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();

		HomePage home;
		home = login.clickOnSignInButton();

		ManageNewsPage manage;
		manage = home.clickOnManageNewsButton();

		String news = ExcelUtility.readStringData(1, 2, "ManageNewsPage");

		manage.clickOnSearchButtonOfManageNewsPage().enterSearchNewsOnSearchNewsField(news)
				.clickOnSearchButtonOfSearchNewsPage();

		boolean issearchDisplayed = manage.isSearchNewsIsDisplayed();
		Assert.assertTrue(issearchDisplayed, Messages.MANAGENEWSSEARCHPAGEERROR);

	}

	@Test(description = "Verify whether the user can refresh the News list using Reset Button")
	public void verifyWhetherUserIsAbleToRefreshNewsPageUsingTheResetButton() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		// chainning of methods
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();

		HomePage home;
		home = login.clickOnSignInButton();

		ManageNewsPage manage;
		manage = home.clickOnManageNewsButton();
		manage.clickOnResetButtonOfManageNewsPage();

		String expectedResult = "Manage News";
		String actualResult = manage.getTextFromRefreshNewsDisplayed();
		Assert.assertEquals(actualResult, expectedResult, Messages.MANAGENEWSREFRESHPAGEERROR);

	}

}
