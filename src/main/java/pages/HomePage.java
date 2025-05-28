package pages;

import org.openqa.selenium.WebDriver;
import java.util.*;
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
	
	@FindBy(xpath= "//input[@id='patient-test']//parent ::div")
	public static WebElement addTest;
	
	@FindBy(xpath="//div[contains(@class,'MuiSelect-root MuiSelect-select')]")
	public static WebElement addDiscount;
	
	@FindBy(xpath= "//li[contains(@id,'patient-test-option')]")
	public static WebElement testName;
	
	@FindBy(xpath="//div[@id='patient-test-popup']//ul//li")
	public static List<WebElement> testdropdownpotions;
	
	
	public void testCostCalculator(String testName) {
		
		for(WebElement dropdownoption : testdropdownpotions) {
			if(dropdownoption.getText().trim().equalsIgnoreCase(testName)) {
				dropdownoption.click();
			}
		}
		
		
	}
	


}
