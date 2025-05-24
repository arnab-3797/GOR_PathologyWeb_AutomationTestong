package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public static WebDriver driver;
	
	
	public BasePage(WebDriver driver) {
		
		BasePage.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='title']")
	public static WebElement pagetitle;
	
	public String getPageTitle() {
		
		return pagetitle.getText();
	}
}
