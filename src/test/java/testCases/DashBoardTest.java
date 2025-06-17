package testCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utilities.DataUtil;

public class DashBoardTest extends BaseTest {
	
	SoftAssert softAssert = new SoftAssert();
	HomePage home = new HomePage(driver);
	
	@Test(dataProviderClass = DataUtil.class, dataProvider= "dp",enabled= false)
	public void logedinToDashboard(String username, String password, String browserName, String expectedTitle ) {
		
		setup(browserName);
		log.info(browserName+"Browser is opening....");
		LoginPage login =new LoginPage(driver);
		login.doLogin(username, password);
		log.info("user loged in to dashboard");
		String actualTitle = home.getPageTitle();
		softAssert.assertEquals(actualTitle, expectedTitle,"Dashboard does not title match");
		softAssert.assertAll();
	}
	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider= "dp",enabled =true)
	public void addTestFromDropDown(String username,String password ,String browserName, String testName, String discount ) {
		
		setup(browserName);
		log.info(browserName+"Browser is opening....");
		LoginPage login =new LoginPage(driver);
		login.doLogin(username, password);
		
		home.testCostCalculator(testName, discount);
		log.info("test and Discount selected");
		int actualPrice = home.getToataPriceFromDropdownTest();
		
		int expectedPrice = Integer.parseInt(home.getSubTotalValue());
		softAssert.assertEquals(actualPrice, expectedPrice,"Sum Of Price not matching with Total vlue");
		
		
		
		softAssert.assertAll();
	}
	
	

}
