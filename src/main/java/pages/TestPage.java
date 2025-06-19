package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class TestPage extends BasePage {

	public TestPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@href='/tests']/div")
	public static WebElement testtab;

	public void goToTestTab(){

		clickToElemennt(testtab);
	}

	@FindBy(xpath = "//*[text()='Manage Tests']")
	private static WebElement manageTest;

	@FindBy(xpath = "//a[contains(@href,'/patients/add')]")
	private static WebElement addtests;


	public ManageTestsPage manageTest() {

		manageTest.click();
		return new ManageTestsPage(driver);
	}

	public AddPatient addNewPatientTest() {

		addtests.click();
		return new AddPatient(driver);
	}

	@FindBy(xpath = "//input[@placeholder='Search']")
	public static WebElement searchinputfield;

	@FindBy(xpath = "//table[@class='MuiTable-root']//tbody//tr/td[2]")
	public static List<WebElement> namecelldata;

	public String searchFunctionality(String patientName) {

		searchinputfield.clear();
		//logger.info("clear the search field");
		writeText(searchinputfield, patientName);
		//logger.info("Write Patient name to the ");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String patient = null;
		for (WebElement result : namecelldata) {

			if (result.getText().toLowerCase().contains(patientName.toLowerCase())) {

				patient = result.getText();
				//logger.info("patient name found: "+patient);
				break;
			}
		}
		return patient;

	}

}
