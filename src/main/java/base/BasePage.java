package base;

import java.util.List;

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
		
		return getValueFromText(pagetitle);
	}
	
	public void click(WebElement element) {
		
		element.click();
	}
	public void writeText(WebElement element,String text) {
		element.sendKeys(text);
	}
	
	public void selectlementFromDropdown(List<WebElement> dropdownpotions, String optionname) {
		for(WebElement dropdownoption : dropdownpotions) {
			if(dropdownoption.getText().trim().equalsIgnoreCase(optionname)) {
				click(dropdownoption);
			}
		}
	}
	
	public String getValueFromText(WebElement element) {
		String text = element.getText();
		return text;
	}
}
