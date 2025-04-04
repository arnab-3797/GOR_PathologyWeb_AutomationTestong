package testCases;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.LoginPage;



public class LoginTest {
	
	@Test
	public void setUp() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://gor-pathology.web.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserrname();
		loginPage.enterPassword();
		loginPage.clickOnLoginBtn();
		
		
		driver.close();
	}
	

}
