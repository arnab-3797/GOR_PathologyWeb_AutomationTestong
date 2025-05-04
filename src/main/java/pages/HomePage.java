package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

	@FindBy(xpath = "//div[@class='title'][text()='Dashboard']")
	public static WebElement dashBoardTitle;
	
	
	public String findDashBoardPageTitle() {
		
		String boardtitle = dashBoardTitle.getTagName();
		return boardtitle;
	}
	


}
