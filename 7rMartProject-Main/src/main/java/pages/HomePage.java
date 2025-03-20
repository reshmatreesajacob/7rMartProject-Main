package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@class='img-circle']")
	private WebElement adminDropDown;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logoutButton;
	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	private WebElement signInPage;
	@FindBy(xpath = "//p[contains(text(),' Admin')]")
	private WebElement adminUsers;
	@FindBy(xpath = "//p[text()='Sub Category']")
	private WebElement subCategory;
	@FindBy(xpath = "//p[text()='Manage News']")
	private WebElement manageNews;

	public HomePage clickOnAdminButton() {
		adminDropDown.click();
		return this;
	}

	public LoginPage clickOnTheLogoutButton() {
		logoutButton.click();
		return new LoginPage(driver);
	}

	public boolean isBackToLoginPage() {
		return signInPage.isDisplayed();
	}

	public AdminUserPage clickOnAdminUsersButton() {
		adminUsers.click();
		return new AdminUserPage(driver);
	}

	public SubCategoryPage clickOnSubCategoryButton() {
		subCategory.click();
		return new SubCategoryPage(driver);
	}

	public ManageNewsPage clickOnManageNewsButton() {
		manageNews.click();
		return new ManageNewsPage(driver);
	}

}
