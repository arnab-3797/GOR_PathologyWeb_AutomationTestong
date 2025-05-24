package testCases;




import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import utilities.DataUtil;



public class LoginTest extends BaseTest {
	
	
	

	@Test(dataProviderClass = DataUtil.class, dataProvider= "dp")
	public void doLogin(String browserName, String username, String password) {
	
		setup(browserName);
		LoginPage loginPage = new LoginPage(driver);
		String actualTitle = loginPage.doLogin(username, password).getPageTitle();
		System.out.println(actualTitle);
		String expectedTitle ="Dashboard";
		Assert.assertEquals(actualTitle, expectedTitle,"Dashboard title match");
	}
	

}
