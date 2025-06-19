package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.TestPage;
import utilities.DataUtil;

public class TestPageTestCase extends BaseTest {
	
	SoftAssert softAssert = new SoftAssert();
	TestPage testpage = new TestPage(driver);
	LoginPage loginPage = new LoginPage(driver);
	
	@Test(dataProviderClass = DataUtil.class, dataProvider= "dp")
	public void verifyPageTitle(String username, String password, String browserName, String expectedTitle) {
		
		setup(browserName);
		loginPage = new LoginPage(driver);
		String actualTitle = loginPage.doLogin(username, password).getPageTitle();
		log.info("Logged in to GOR.." + actualTitle);
		System.out.println(actualTitle);
		softAssert.assertEquals(actualTitle, expectedTitle,"Test page title match");
	}

	@Test(dataProviderClass = DataUtil.class, dataProvider= "dp")
	public void verifyManageTestFunctionality(String username, String password, String browserName,String expectedTitle) {
		setup(browserName);
		loginPage.doLogin(username, password).getPageTitle();

		testpage.goToTestTab();
		String actualTitle = testpage.manageTest().getPageTitle();
		softAssert.assertEquals(actualTitle, expectedTitle,"Test page title match");
	}

	@Test(dataProviderClass = DataUtil.class, dataProvider= "dp")
	public void verifyTheSearchResultMatching(String username, String password, String browserName,String patientName,String expectedResult){

		setup(browserName);
		loginPage.doLogin(username, password).getPageTitle();

		String actualResult = testpage.searchFunctionality(patientName);
		log.info("search is completed...");
		softAssert.assertEquals(actualResult,expectedResult,"Title is not matching");

		softAssert.assertAll("Verification failed");
	}

}
