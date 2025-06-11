package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@name='email']")
	public WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement psw;

	@FindBy(xpath = "//span[text()='Login']")
	public WebElement loginBtn;

	
	public HomePage doLogin(String userName, String password) {
		writeText(email,userName);
		writeText(psw,password);
		clickToElemennt(loginBtn);
		return new HomePage(driver);
	}

}
