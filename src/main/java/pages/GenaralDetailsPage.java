package pages;

import java.util.List;

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
	public static WebElement genderdropdownbox;
	
	@FindBy(xpath="//*[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]//li")
	public static List<WebElement> genderdropdownoption;
	
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
	
	
	public void secondaryDetailsFields(String height, String weight, String age, String gender) {
		
		heightbox.sendKeys(height);
		weightbox.sendKeys(weight);
		genderdropdownbox.click();
		for(WebElement option : genderdropdownoption) {
			if(option.getText().trim().equalsIgnoreCase(gender)) {
				option.click();
			}
		}
		
		agebox.sendKeys(age);
	}
	
	public void bloodPressure(String systolicbloodpressure, String diastolocbloodpressure) {
		
		agebox.sendKeys(systolicbloodpressure);
		diastolicbox.sendKeys(diastolocbloodpressure);
		
	}
	
	public AddPatient backBtn() {
		
		backbtn.click();
		
		return new AddPatient(driver);
	}
	
	public AddTestToPatientPage addTestToPatient() {
		
		addtestbtn.click();
		return new AddTestToPatientPage(driver);
	}
	
	
	
	
	
	
}
