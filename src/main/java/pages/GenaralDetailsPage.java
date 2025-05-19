package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class GenaralDetailsPage extends BasePage {
	
	public GenaralDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//input[@name='height']")
	public static WebElement heightbox;
	
	@FindBy(xpath="//input[@name='weight']")
	public static WebElement weightbox;
	
	@FindBy(xpath="//div[contains(@id,'mui-component-select-gender')]")
	public static WebElement genderbox;
	
	@FindBy(xpath="//input[@name='age']")
	public static WebElement agebox;
	
	@FindBy(xpath="//input[@name='systolic']")
	public static WebElement systolicbox;
	
	@FindBy(xpath="//input[@name='diastolic']")
	public static WebElement diastolicbox;
	
	@FindBy(xpath="//span[text()='back']/ancestor ::button")
	public static WebElement backbtn;
	
	@FindBy(xpath="//span[text()='Add Tests']/ancestor ::button")
	public static WebElement addtestbtn;
	
	
	public void secondaryDetailsFields(String height, String weight, String age) {
		
		heightbox.sendKeys(height);
	}
	
	
	
	
	
	
	
	
}
