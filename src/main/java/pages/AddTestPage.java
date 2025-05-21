package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class AddTestPage extends BasePage{

	public AddTestPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//input[@name='name']")
	public static WebElement testnamefield;
	public void testIdentification(String name) {
		
		testnamefield.sendKeys(name);
	}


}
