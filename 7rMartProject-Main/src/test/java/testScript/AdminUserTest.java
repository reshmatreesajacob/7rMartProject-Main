package testScript;

import java.beans.Transient;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	@Test
	public void verifyWhetherUserIsAbleToAddNewUserToTheUsersList() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		// chainning of methods
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();

		HomePage home;
		home = login.clickOnSignInButton();

		AdminUserPage admin;
		admin = home.clickOnAdminUsersButton();

//		String newUsername = ExcelUtility.readStringData(2, 0, "AdminUserPage");
//		String newPassword = ExcelUtility.readStringData(2, 1, "AdminUserPage");

		FakerUtility faker = new FakerUtility();
		String newUsername = faker.createRandomUsername();
		String newPassword = faker.createRandomPassword();
		String newUserType = ExcelUtility.readStringData(2, 2, "AdminUserPage");
		admin.clickOnManageUsersButton().clickOnNewButton().enterNewUsernameOnUsernameField(newUsername)
				.enterNewPasswordOnPasswordField(newPassword).selectNewUserTypeOnUserTypeField(newUserType)
				.clickOnSaveButton();

		String expectedResult = "Alert!";
		String actualResult = admin.getTextFromAlert();
		Assert.assertEquals(actualResult, expectedResult, Messages.USERCREATIONERROR);
	}

	@Test
	public void verifyUserIsAbleToRefreshNewlyAddedUserPageUsingTheResetButton() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		// chainning of methods
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();

		HomePage home;
		home = login.clickOnSignInButton();

		AdminUserPage admin;
		admin = home.clickOnAdminUsersButton();
		admin.clickOnManageUsersButton().clickOnResetButton();

		String expectedResult = "Admin Users";
		String actualResult = admin.getTextFromRefreshUserDisplayed();
		Assert.assertEquals(actualResult, expectedResult, Messages.USERREFRESHPAGEERROR);
	}

	@Test
	public void verifyUserIsAbleToSearchNewlyAddedUsersInTheNewlyAddedUsersList() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		// chainning of methods
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();

		HomePage home;
		home = login.clickOnSignInButton();

		AdminUserPage admin;
		admin = home.clickOnAdminUsersButton();

		String searchUsername = ExcelUtility.readStringData(2, 4, "AdminUserPage");
		String searchUserType = ExcelUtility.readStringData(2, 5, "AdminUserPage");
		admin.clickOnManageUsersButton().clickOnSearchButton().enterUsernameOnUsernameFieldOfSearchPage(searchUsername)
				.selectUserTypeOnUserTypeFieldOfSearchPage(searchUserType).clickOnSearchButtonInSearchPage();

		boolean issearchDisplayed = admin.isSearchAUserIsDisplayed();
		Assert.assertTrue(issearchDisplayed, Messages.USERSEARCHPAGEERROR);

	}
}
