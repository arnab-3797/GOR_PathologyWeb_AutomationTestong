package pages;

import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class GeneralDetailsPage extends BasePage {
	
	public GeneralDetailsPage(WebDriver driver) {
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

	public GeneralDetailsPage secondaryDetailsFields(String height, String weight, String age, String gender) {

		writeText(heightbox,height);
		writeText(weightbox,weight);
		clickToElement(genderdropdownbox);
		selectElementFromDropdown(genderdropdownoption,gender);
		writeText(agebox,age);

		return GeneralDetailsPage.this;
	}

	@FindBy(xpath="//input[@name='systolic']")
	public static WebElement systolicbox;

	@FindBy(xpath="//input[@name='diastolic']")
	public static WebElement diastolicbox;

	public GeneralDetailsPage bloodPressure(String systolicbloodpressure, String diastolocbloodpressure) {

		writeText(systolicbox,systolicbloodpressure);
		writeText(diastolicbox,diastolocbloodpressure);

		return GeneralDetailsPage.this;
	}

	@FindBy(xpath="//span[text()='back']/ancestor ::button")
	public static WebElement backbtn;

	public AddPatient backBtn() {
		
		backbtn.click();
		
		return new AddPatient(driver);
	}

	@FindBy(xpath="//span[text()='Add Tests']/ancestor ::button")
	public static WebElement addtestbtn;

	public AddTestToPatientPage addTestToPatient() {
		try {
			clickToElement(addtestbtn);
		} catch (ElementClickInterceptedException e) {
			// Use JavaScript click as fallback
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", addtestbtn);
		}
		return new AddTestToPatientPage(driver);
	}
	
	
	
	
	
	
}
