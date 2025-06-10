package testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class DashBoardTest extends BaseTest {
	SoftAssert softAssert = new SoftAssert();
	HomePage home = new HomePage(driver);
	
	@Test
	public void logedinToDashboard(String username, String password, String browserName, String expectedTitle ) {
		
		setup(browserName);
		log.info(browserName+"Browser is opening....");
		LoginPage login =new LoginPage(driver);
		login.doLogin(username, password);
		log.info("user loged in to dashboard");
		String actualTitle = home.getPageTitle();
		softAssert.assertEquals(actualTitle, expectedTitle,"Dashboard does not title match");
	}
	
	
	@Test
	public void addTestFromDropDown(String testName, String discount ) {
		
		home.testCostCalculator(testName, discount);
		log.info("test and Discount selected");
		
		softAssert.assertEquals(false, testName);
		
		
		
	}
	
	

}
