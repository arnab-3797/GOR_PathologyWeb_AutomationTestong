package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class TestPage extends BasePage {
	
	
	public TestPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[text()='Manage Tests']")
	private static WebElement manageTest;
	
	@FindBy(xpath="//a[contains(@href,'/patients/add')]")
	private static WebElement addtests;
	
	public ManageTestsPage manageTest() {
		
		manageTest.clear();
		return new ManageTestsPage(driver);
	}
	
	public AddPatient addNewPatientTest() {
		
		addtests.click();
		return new AddPatient(driver);
	}
	
	

}
