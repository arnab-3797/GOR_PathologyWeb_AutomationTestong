package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	Actions action = new Actions(driver);

	@FindBy(xpath = "//div[@class='title'][text()='Dashboard']")
	public static WebElement dashBoardTitle;
	
	
/*	public String findDashBoardPageTitle() {
		
		String boardtitle = dashBoardTitle.getTagName();
		return boardtitle;
	} */
	
	@FindBy(xpath= "//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root')]//input[@id='patient-test']")
	public static WebElement addTest;
	
	@FindBy(xpath="//div[contains(@class,'MuiSelect-root MuiSelect-select')]")
	public static WebElement addDiscount;
	
	@FindBy(xpath= "//li[contains(@id,'patient-test-option')]")
	public static WebElement testName;
	
	
	
	public void testCostCalculator(String testName) {
		
		addTest.sendKeys(testName);
		action.moveToElement(addTest).perform();
		
		
	}
	


}
