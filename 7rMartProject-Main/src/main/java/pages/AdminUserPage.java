package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import utilities.PageUtility;

public class AdminUserPage {
	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage Users']")
	private WebElement manageUsers;
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newUser;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement newUsername;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement newPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userType;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[text()=' Reset']")
	private WebElement resetButton;
	@FindBy(xpath = "//a[text()=' Search']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchUsername;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement searchUserType;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchButtonInSearchPage;
	@FindBy(xpath = "//h5 [text()=' Alert!']")
	private WebElement newUserAlert;
	@FindBy(xpath = "//h4[text()='Admin Users']")
	private WebElement refreshUsersIsDisplayed;
	@FindBy(xpath = "//td[text()='movieuser']")
	private WebElement searchUserListIsDisplayed;

	public AdminUserPage clickOnManageUsersButton() {
		manageUsers.click();
		return this;
	}

	public AdminUserPage clickOnNewButton() {
		newUser.click();
		return this;
	}

	public AdminUserPage enterNewUsernameOnUsernameField(String username) {
		newUsername.sendKeys(username);
		return this;
	}

	public AdminUserPage enterNewPasswordOnPasswordField(String password) {
		newPassword.sendKeys(password);
		return this;
	}

	public AdminUserPage selectNewUserTypeOnUserTypeField(String userType) {
		//userType=Constants.ADMINUSERDROPDOWNVALE;
		PageUtility page=new PageUtility();
		page.selectDropdownWithVisibleText(this.userType, userType);
//		Select user = new Select(this.userType);
//		user.selectByContainsVisibleText(userType);
		return this;
	}

	public AdminUserPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	public AdminUserPage clickOnResetButton() {
		resetButton.click();
		return this;
	}

	public AdminUserPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}

	public AdminUserPage enterUsernameOnUsernameFieldOfSearchPage(String username) {
		searchUsername.sendKeys(username);
		return this;
	}

	public AdminUserPage selectUserTypeOnUserTypeFieldOfSearchPage(String userType) {
		PageUtility page=new PageUtility();
		page.selectDropdownWithVisibleText(this.searchUserType, userType);
//		Select user = new Select(this.searchUserType);
//		user.selectByContainsVisibleText(userType);
		return this;
	}

	public AdminUserPage clickOnSearchButtonInSearchPage() {
		searchButtonInSearchPage.click();
		return this;
	}

	public String getTextFromAlert() {
		return newUserAlert.getText();
	}

	public String getTextFromRefreshUserDisplayed() {
		return refreshUsersIsDisplayed.getText();
	}

	public boolean isSearchAUserIsDisplayed() {
		return searchUserListIsDisplayed.isDisplayed();
	}
}
