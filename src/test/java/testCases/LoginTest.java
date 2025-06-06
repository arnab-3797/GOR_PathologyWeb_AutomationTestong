package testCases;



import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.LoginPage;
import utilities.DataUtil;



public class LoginTest extends BaseTest {
	
	
	SoftAssert softAssert = new SoftAssert();

	@Test(dataProviderClass = DataUtil.class, dataProvider= "dp")
	public void doLogin(String username, String password, String browserName, String expectedTitle) {
	
		setup(browserName);
		log.info("browser is opening");
		LoginPage loginPage = new LoginPage(driver);
		String actualTitle = loginPage.doLogin(username, password).getPageTitle();
		log.info("Logde in to GOR.." + actualTitle);
		System.out.println(actualTitle);
		//String expectedTitle ="Dashboard";
		softAssert.assertEquals(actualTitle, expectedTitle,"Dashboard title match");
		
	}
	

}
