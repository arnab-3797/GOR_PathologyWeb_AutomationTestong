package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ManageTestsPage extends BasePage {

	public ManageTestsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@href='/tests/add']")
	public static WebElement addtestbtn;
	
	public AddTestPage addTestName() {
		
		addtestbtn.click();
		return new AddTestPage(driver);
	}

}
