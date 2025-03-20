package testScript;

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
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {

	@Test(description = "Verify whether the user can add new item in the Sub category list using New Button")
	public void verifyWhetherUserIsAbleToaddNewItemToSubCategoryList() throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		// chainning of methods
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();

		HomePage home;
		home = login.clickOnSignInButton();

		SubCategoryPage subcategory;
		subcategory = home.clickOnSubCategoryButton();

//		SubCategoryPage subcategory = new SubCategoryPage(driver);
//		subcategory.clickOnSubCategoryButton();

		String category = ExcelUtility.readStringData(1, 0, "SubCategoryPage");
		String subCategory = ExcelUtility.readStringData(1, 1, "SubCategoryPage");
		String image = ExcelUtility.readStringData(1, 2, "SubCategoryPage");

		subcategory.clickOnNewButtonOfSubCategoryPage().selectCategoryFromSubCategoryCreationPage(category)
				.enterSubCategoryOfSubCategoryCreationPage(subCategory).selectImageOfSubCategoryCreationPage()
				.clickOnSaveButtonOfSubCategoryCreationPage();

//		subcategory.selectImageOfSubCategoryCreationPage(image);

		String expectedResult = "Alert!";
		String actualResult = subcategory.getTextFromAlert();
		Assert.assertEquals(actualResult, expectedResult, Messages.SUBCATEGORYCREATIONERROR);
	}

	@Test(description = "Verify whether the user can refresh the Sub Category list using Reset Button")
	public void verifyWhetherUserIsAbleTorefreshPageUsingResetButton() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		// chainning of methods
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();

		HomePage home;
		home = login.clickOnSignInButton();

		SubCategoryPage subcategory;
		subcategory = home.clickOnSubCategoryButton();

		subcategory.clickOnResetButtonOfSubCategoryPage();

		String expectedResult = "List Sub Categories";
		String actualResult = subcategory.getTextFromRefreshNewsDisplayed();
		Assert.assertEquals(actualResult, expectedResult, Messages.SUBCATEGORYREFRESHPAGEERROR);
	}

	@Test(description = "Verify whether the user can search a item in the Sub Category list using Search Button")
	public void verifyWhetherUserIsAbleTosearchItemsInTheSubCategoryList() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		// chainning of methods
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();

		HomePage home;
		home = login.clickOnSignInButton();

		SubCategoryPage subcategory;
		subcategory = home.clickOnSubCategoryButton();

		String category = ExcelUtility.readStringData(1, 0, "SubCategoryPage");
		String subCategory = ExcelUtility.readStringData(1, 1, "SubCategoryPage");

		subcategory.clickOnSearchButtonOfSubCategoryPage().selectCategoryFromSubCategorySearchPage(category)
				.enterSubCategoryOfSubCategorySearchPage(subCategory).clickOnSearchButtonOfSubCategorySearchPage();

		boolean issearchDisplayed = subcategory.isSearchSubcategoryIsDisplayed();
		Assert.assertTrue(issearchDisplayed, Messages.SUBCATEGORYSEARCHPAGEERROR);
	}

}
