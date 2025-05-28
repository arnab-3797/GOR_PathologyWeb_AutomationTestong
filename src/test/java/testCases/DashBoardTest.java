package testCases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class DashBoardTest extends BaseTest {
	
	@Test
	public void login(String username, String password, String browserName ) {
		
		setup(browserName);
		log.info(browserName+"Browser is opening....");
		LoginPage login =new LoginPage(driver);
		login.doLogin(username, password);
	}
	
	
	

}
