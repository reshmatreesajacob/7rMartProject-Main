package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import utilities.PageUtility;

public class SubCategoryPage {

	public WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement categorySelection;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subCategoryText;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement imageUploadButton;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[text()=' Reset']")
	private WebElement resetButton;
	@FindBy(xpath = "//a[text()=' Search']")
	private WebElement searchButton;
	@FindBy(xpath = "//select[@id='un']")
	private WebElement searchCategory;
	@FindBy(xpath = "//input[@name='ut']")
	private WebElement searchSubcategory;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchButtonOnSearchPage;

	@FindBy(xpath = "//h5 [text()=' Alert!']")
	private WebElement newSubCategoryAlert;
	@FindBy(xpath = "//h4[text()='List Sub Categories']")
	private WebElement refreshSubCategoryDisplayed;
	@FindBy(xpath = "//td[text()='Sports Toy Car2']")
	private WebElement searchSubcategoryIsDisplayed;

	public SubCategoryPage clickOnNewButtonOfSubCategoryPage() {
		newButton.click();
		return this;
	}

	public SubCategoryPage selectCategoryFromSubCategoryCreationPage(String category1) {
		PageUtility page=new PageUtility();
		page.selectDropdownWithVisibleText(categorySelection, category1);
//		Select select = new Select(categorySelection);
//		select.selectByContainsVisibleText(category1);
		return this;
	}

	public SubCategoryPage enterSubCategoryOfSubCategoryCreationPage(String subCategory1) {
		subCategoryText.sendKeys(subCategory1);
		return this;
	}

	public SubCategoryPage selectImageOfSubCategoryCreationPage() {
		imageUploadButton.sendKeys(Constants.IMAGEFILE);
		return this;
	}

	public SubCategoryPage clickOnSaveButtonOfSubCategoryCreationPage() {
		saveButton.click();
		return this;
	}

	public SubCategoryPage clickOnResetButtonOfSubCategoryPage() {
		resetButton.click();
		return this;
	}

	public SubCategoryPage clickOnSearchButtonOfSubCategoryPage() {
		searchButton.click();
		return this;
	}

	public SubCategoryPage selectCategoryFromSubCategorySearchPage(String category1) {
		PageUtility page=new PageUtility();
		page.selectDropdownWithVisibleText(searchCategory, category1);
//		Select select = new Select(searchCategory);
//		select.selectByContainsVisibleText(category1);
		return this;
	}

	public SubCategoryPage enterSubCategoryOfSubCategorySearchPage(String subCategory1) {
		searchSubcategory.sendKeys(subCategory1);
		return this;
	}

	public SubCategoryPage clickOnSearchButtonOfSubCategorySearchPage() {
		searchButtonOnSearchPage.click();
		return this;
	}

	public String getTextFromAlert() {
		return newSubCategoryAlert.getText();
	}

	public String getTextFromRefreshNewsDisplayed() {
		return refreshSubCategoryDisplayed.getText();
	}

	public boolean isSearchSubcategoryIsDisplayed() {
		return searchSubcategoryIsDisplayed.isDisplayed();
	}
}
