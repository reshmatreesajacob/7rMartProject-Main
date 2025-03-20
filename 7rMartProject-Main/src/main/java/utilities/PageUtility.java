package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	// to declare actions
	public WebDriver driver;

	public void javascriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}

	public void selectDropdownWithVisibleText(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByVisibleText(value);
	}
	
	public void selectDropdownWithVisibleText(WebElement element, int value) {
		Select object = new Select(element);
		object.selectByIndex(value);;
	}
	
	public void mouseHover(WebDriver driver ,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	public void rightClick(WebDriver driver ,WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	
	public void clickOnCheckbox(WebElement element)
	{
		element.click();
	}

}
