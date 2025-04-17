package testCases;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import extentListeners.ExtentListeners;
import pages.LoginPage;



public class LoginTest extends BaseTest {
	

	@Test
	public void doLogin() {
	
		setup("chrome");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserrname();
		ExtentListeners.testreport.log(Status.INFO, "Entering user name");
		loginPage.enterPassword();
		ExtentListeners.testreport.log(Status.INFO, "Entering password");
		loginPage.clickOnLoginBtn();
		ExtentListeners.testreport.log(Status.INFO, "C");
		
	}
	

}
