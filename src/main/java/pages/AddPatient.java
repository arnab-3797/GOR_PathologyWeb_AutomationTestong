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
	
	@FindBy(xpath="//input[@name=\"name\"]")
	private static WebElement namebox;
	@FindBy(xpath="")
	private static WebElement emailbox;
	@FindBy(xpath="")
	private static WebElement phonenumberbox;
	
	
	
	
	public void addPatientContactDetails(String name, String emailId, String phoneNumber) {

		writeText(namebox,name);
		writeText(emailbox,emailId);
		writeText(phonenumberbox,phoneNumber);
		
	}
	
	@FindBy(xpath="//span[text()='cancel'] /ancestor ::button")
	public static WebElement cancelBtn;
	
	public TestPage cancelAddPatientContactDetails() {
		
		cancelBtn.click();
		return new TestPage(driver);
	}
	
	@FindBy(xpath="//span[@class='MuiButton-label jss521' and text()='General Details']")
	public static WebElement genaraldetailsbtn;
	public GenaralDetailsPage addGenaralDetailsOfPatient() {
		genaraldetailsbtn.click();
		
		return new GenaralDetailsPage(driver);
	}

}
