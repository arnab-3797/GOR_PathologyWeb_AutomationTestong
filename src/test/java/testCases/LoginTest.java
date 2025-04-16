package testCases;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.LoginPage;
import utilities.ExtentListeners;



public class LoginTest {
	

	@Test
	public void doLogin() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://gor-pathology.web.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserrname();
		ExtentListeners.testreport.log(Status.INFO, "Entering user name");
		loginPage.enterPassword();
		ExtentListeners.testreport.log(Status.INFO, "Entering password");
		loginPage.clickOnLoginBtn();
		ExtentListeners.testreport.log(Status.INFO, "C");
		
	}
	

}
