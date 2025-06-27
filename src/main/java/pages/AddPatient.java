package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class AddPatient extends BasePage {

	public AddPatient(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@name= 'name']")
	private static WebElement namebox;
	@FindBy(xpath="//input[@name= 'email']")
	private static WebElement emailbox;
	@FindBy(xpath="//input[@name= 'phone']")
	private static WebElement phonenumberbox;
	
	
	
	
	public AddPatient addPatientContactDetails(String name, String emailId, String phoneNumber) {

		writeText(namebox,name);
		writeText(emailbox,emailId);
		//writeText(phonenumberbox,phoneNumber);
		phonenumberbox.sendKeys(phoneNumber);
		return AddPatient.this;
	}
	
	@FindBy(xpath="//span[text()='cancel'] /ancestor ::button")
	public static WebElement cancelBtn;
	
	public TestPage cancelAddPatientContactDetails() {
		
		cancelBtn.click();
		return new TestPage(driver);
	}
	
	@FindBy(xpath="//span[contains(@class,'MuiButton-label') and text()='General Details']//parent::button")
	public static WebElement generaldetailsbtn;

	public GeneralDetailsPage addGeneralDetailsOfPatient() {

		//explicitWait(generaldetailsbtn);
		generaldetailsbtn.click();
		
		return new GeneralDetailsPage(driver);
	}

	@FindBy(xpath = "//div[@class='MuiAlert-message']")
	private static WebElement alert_msg;

	public String getAlertMsg(){

		return getValueFromText(alert_msg);
	}

	@FindBy(xpath = "//p[contains(@class,'MuiFormHelperText-root MuiFormHelperText-contained')]")
	private static WebElement alertText;
	public String getAlertText(){

		return  getValueFromText(alertText);
	}

}
