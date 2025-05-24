package pages;

import java.util.List;

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
	
	
	@FindBy(xpath="//input[@placeholder='Search']")
	public static WebElement searchfield;
	@FindBy(xpath="//table[@class='MuiTable-root']//tr")
	public static List<WebElement> searchresults;
	
	public void searchFunctionality(String searchtext) {
		
		searchfield.clear();
		searchfield.sendKeys(searchtext);
		
		for(WebElement result : searchresults){
			
			if(result.getText().toLowerCase().contains(searchtext.toLowerCase())) {
				result.click();
			}
		}
		
	}

}
