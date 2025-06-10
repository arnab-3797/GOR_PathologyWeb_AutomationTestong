package pages;

import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath = "//div[@class='title'][text()='Dashboard']")
	public static WebElement dashBoardTitle;
	
	
/*	public String findDashBoardPageTitle() {
		
		String boardtitle = dashBoardTitle.getTagName();
		return boardtitle;
	} */
	
	@FindBy(xpath= "//input[@id='patient-test']//parent ::div")
	public static WebElement addTest;
	
	@FindBy(xpath="//div[contains(@class,'MuiSelect-root MuiSelect-select')]")
	public static WebElement addDiscount;
	
	@FindBy(xpath= "//li[contains(@id,'patient-test-option')]")
	public static WebElement testName;
	
	@FindBy(xpath="//div[@id='patient-test-popup']//ul//li")
	public static List<WebElement> testdropdownpotions;
	@FindBy(xpath="//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li")
	public static List<WebElement> discountdropdownoptions;
	
	@FindBy(css = "div[class='MuiBox-root jss75']")
	public static WebElement subtotalvalue;
	
	@FindBy(css = "div[class='MuiBox-root jss78']")
	public static WebElement totalvalue;
	
	
	
	public void testCostCalculator(String testName, String discountpercentage) {
		
		
		selectlementFromDropdown(testdropdownpotions, testName);
		selectlementFromDropdown(discountdropdownoptions,discountpercentage);
	}
	public String getSubTotalValue() {
		
		return getValueFromText(subtotalvalue);
		
	}
	
	public String getTotalValue() {
		
		return getValueFromText(totalvalue);
		
	}

	@FindBy(xpath="//span[@class='MuiChip-label']")
	public static List<WebElement> selectedTest;
	public int getPriceForTest() {
		int sumofprice = getSumOfNumberFromString(selectedTest);
		return sumofprice;
		}

}
