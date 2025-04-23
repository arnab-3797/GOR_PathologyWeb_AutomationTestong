package testCases;


import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;



public class LoginTest extends BaseTest {
	

	@Test
	public void doLogin() {
	
		setup("edge");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin("test@kennect.io", "Qwerty@1234");
		
	}
	

}
