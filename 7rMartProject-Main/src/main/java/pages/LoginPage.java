package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordField;
	@FindBy(xpath = "//label[@for='remember']")
	private WebElement rememberMeCheckbox;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signIn;

	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement title;

	public LoginPage enterUsernameOnUsernameField(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public LoginPage clickOnCheckbox() {
		PageUtility page=new PageUtility();
		page.clickOnCheckbox(rememberMeCheckbox);
		return this;
	}

	public HomePage clickOnSignInButton() {
		signIn.click();
		return new HomePage(driver);
	}

	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}

	public boolean isTitleDisplayed() {
		return title.isDisplayed();
	}
}
