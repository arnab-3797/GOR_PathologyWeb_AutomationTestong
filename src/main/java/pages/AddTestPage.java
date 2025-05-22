package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class AddTestPage extends BasePage {

	public AddTestPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@name='name']")
	public static WebElement testnamefield;

	public void testIdentification(String name) {

		testnamefield.sendKeys(name);
	}

	@FindBy(id = "mui-component-select-sample_type")
	public static WebElement sampletypedropdown;
	@FindBy(xpath = "//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li")
	public static List<WebElement> sampletypeoptions;

	@FindBy(id = "mui-component-select-sample_volume")
	public static WebElement samplevolumedropdown;
	@FindBy(xpath = "//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li")
	public static List<WebElement> samplevoumeoptions;

	@FindBy(id = "mui-component-select-sample_mode")
	public static WebElement samplemodedropdown;
	@FindBy(xpath = "//ul[@class='MuiList-root MuiMenu-list MuiList-padding']/li")
	public static List<WebElement> samplemodeoptions;

	public void testDetails(String type, String volume, String mode) {

		sampletypedropdown.click();
		for (WebElement sampletypeoption : sampletypeoptions) {

			if (sampletypeoption.getText().trim().equalsIgnoreCase(type)) {
				sampletypeoption.click();
			}
		}

		for (WebElement samplevolumeoption : samplevoumeoptions) {

			if (samplevolumeoption.getText().trim().equalsIgnoreCase(volume)) {
				samplevolumeoption.click();
			}
		}

		for (WebElement samplemodeoption : samplemodeoptions) {

			if (samplemodeoption.getText().trim().equalsIgnoreCase(mode)) {
				samplemodeoption.click();
			}
		}
	}

	@FindBy(xpath = "//input[@name='amount']")
	public static WebElement testcostfield;

	public void testCharges(String amount) {

		testcostfield.sendKeys(amount);
	}
	
	
	@FindBy(xpath="//div[@class='MuiBox-root jss235']//button[contains(@class,'MuiButtonBase-root MuiButton-root jss216 jss219 MuiButton-outlined')]")
	public static WebElement cancelbtn;
	
	public ManageTestsPage cancelBtn() {
		cancelbtn.click();
		return new ManageTestsPage(driver);
	}
	
	
	@FindBy(xpath="//div[@class='MuiBox-root jss235']//button[@type='submit']")
	public static WebElement addtestbtn;
	
	public ManageTestsPage addTestName() {
		
		addtestbtn.click();
		return new ManageTestsPage(driver);
	}
	
	
	
	

}
