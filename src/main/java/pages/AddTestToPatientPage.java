package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class AddTestToPatientPage extends BasePage {

	public AddTestToPatientPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='patient-test']/ancestor::div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root MuiAutocomplete-inputRoot')]")
	public static WebElement addtestforpatientdropdown;
	@FindBy(xpath = "//div[@id='patient-test-popup']//ul//li")
	public static List<WebElement> patienttestpopup;

	@FindBy(xpath = "//div[@class='MuiFormControl-root']//div[@role='button']")
	public static WebElement adddiscountforpatientdropdown;
	@FindBy(xpath = "//*[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]//li")
	public static List<WebElement> patientdiscountoptions;

	@FindBy(xpath = "//label[@id='mui-54880-label']/following-sibling::div")
	public static WebElement recomendeddoctornamedropdown;
	@FindBy(xpath = "//ul[@id='mui-11180-popup']/li")
	public static List<WebElement> doctorsnamedropdownoption;

	@FindBy(xpath = "//input[@id='patient-tests-labs']")
	public static WebElement recomendedlabnamedropdown;
	@FindBy(xpath = "//*[@id='patient-tests-labs-popup']//li")
	public static List<WebElement> testlaboptions;

	@FindBy(xpath = "//div[@id='mui-component-select-doctor_commission']")
	public static WebElement doctorscommitiondropdown;
	@FindBy(xpath = "//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]/li")
	public static List<WebElement> doctorsdiscountoption;

	@FindBy(xpath = "//span[text()='add_box']")
	public static WebElement addequipmentbtn;
	@FindBy(xpath = "//ul[contains(@class,'MuiList-root MuiMenu-list MuiList-padding')]/li")
	public static List<WebElement> equipmentoption;

	@FindBy(xpath = "//div[contains(@class,'MuiSelect-root MuiSelect-select MuiSelect-selectMenu')][@aria-label='Eqipment Name']")
	public static WebElement equipmentname;

	@FindBy(xpath = "//input[contains(@class,'MuiInputBase-input MuiInput-input')]")
	public static WebElement addequipmentrequirednumberbtn;

	@FindBy(xpath = "//span[text()='check']")
	public static WebElement saveequipmentbtn;

	@FindBy(xpath = "//span[text()='clear']")
	public static WebElement cancelquipmentbtn;

	@FindBy(xpath = "//span[text()='edit']")
	public static WebElement editeuipmentbtn;

	@FindBy(xpath = "//span[text()='delete_outline']")
	public static WebElement deleteeuipmentbtn;

	@FindBy(xpath = "//span[text()='back']")
	public static WebElement backbtn;

	@FindBy(xpath = "//span[text()='Add Patient']/ancestor:: button")
	public static WebElement addpatientbtn;

	public static void testCostCalculator(String name, String patientDiscount, String labname, String DoctorsName,
			String doctorsDiscount) {

		addtestforpatientdropdown.click();
		for (WebElement patientoption : patienttestpopup) {

			if (patientoption.getText().trim().equalsIgnoreCase(name)) {
				patientoption.click();
			}
		}

		adddiscountforpatientdropdown.click();
		for (WebElement patientdiscountoption : patientdiscountoptions) {

			if (patientdiscountoption.getText().trim().equalsIgnoreCase(patientDiscount)) {
				patientdiscountoption.click();
			}
		}
		
		recomendedlabnamedropdown.click();
		for (WebElement labnameoption : testlaboptions) {

			if (labnameoption.getText().trim().equalsIgnoreCase(labname)) {
				labnameoption.click();
			}
		}
		
		recomendeddoctornamedropdown.click();
		for (WebElement doctornameoption : doctorsnamedropdownoption) {

			if (doctornameoption.getText().trim().equalsIgnoreCase(DoctorsName)) {
				doctornameoption.click();
			}
		}
		
		doctorscommitiondropdown.click();
		for (WebElement doctorcommitionoption : doctorsdiscountoption) {

			if (doctorcommitionoption.getText().trim().equalsIgnoreCase(doctorsDiscount)) {
				doctorcommitionoption.click();
			}
		}
		
		
	}
	
	public void addEquipment(String name, String equipmentnumner) {
		
		addequipmentbtn.click();
		equipmentname.click();
		for (WebElement euuipmentoption : equipmentoption) {

			if (euuipmentoption.getText().trim().equalsIgnoreCase(name)) {
				euuipmentoption.click();
			}
		}
		
		addequipmentrequirednumberbtn.clear();
		addequipmentrequirednumberbtn.sendKeys(equipmentnumner);
		
		
	}
	
	public void saveEquipment() {
		
		saveequipmentbtn.click();
	}
	
	public void cancelEquipment() {
		cancelquipmentbtn.click();
	}
	public void editEquipment() {
		editeuipmentbtn.click();
	}
	public void deleteEquipment() {
		deleteeuipmentbtn.click();
	}
	
	public GenaralDetailsPage backBtnAction() {
		backbtn.click();
		return new GenaralDetailsPage(driver);
	}
	
	public TestPage addPatientAction() {
		
		addpatientbtn.click();
		return new TestPage(driver);
	}

}
