package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LoginPage extends BasePage{

	
	
	 
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@name='email']")
	public WebElement userName;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;
	
	@FindBy(xpath = "//span[text()='Login']")
	public WebElement loginBtn;
	
public void enterUserrname() {
	userName.sendKeys("test@kennect.io");
		
		
	}
	
	public void enterPassword() {
		
		password.sendKeys("Qwerty@1234");
		
	}
	
	public HomePage clickOnLoginBtn() {
		
		loginBtn.click();
		return new HomePage(driver);
		
	}


}
