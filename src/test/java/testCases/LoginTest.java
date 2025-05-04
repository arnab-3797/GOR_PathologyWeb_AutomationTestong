package testCases;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;



public class LoginTest extends BaseTest {
	
	
	

	@Test
	public void doLogin() {
	
		setup("chrome");
		LoginPage loginPage = new LoginPage(driver);
		String actualTitle = loginPage.doLogin("test@kennect.io", "Qwerty@1234").findDashBoardPageTitle();
		String expectedTitle ="Dashboardfg";
		assertEquals(actualTitle, expectedTitle);
	}
	

}
