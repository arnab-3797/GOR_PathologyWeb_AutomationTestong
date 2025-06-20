package testCases;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AddPatient;
import pages.LoginPage;
import pages.TestPage;
import utilities.DataUtil;

public class AddPatientTestCases extends BaseTest {


    AddPatient patient;
    LoginPage login;
    TestPage testpage;
    AddPatient addPatient;


    @Test(dataProviderClass = DataUtil.class, dataProvider= "dp")
    public void verifyAddPatientPageTitle(String username, String password, String browserName, String expectedTitle){

        setup(browserName);
        login = new LoginPage(driver);
        patient = new AddPatient(driver);
        testpage= new TestPage(driver);
        SoftAssert softAssert = new SoftAssert();

        login.doLogin(username, password);
        String actualTitle = testpage.goToTestTab().addNewPatientTest().getPageTitle();
        log.info("Logged in to GOR.." + actualTitle);

        softAssert.assertEquals(actualTitle, expectedTitle,"Test page title match");
        softAssert.assertAll();
    }
    public void verifyPatientContactDetails_PositiveTestCase(String username, String password, String browserName,String name, String email, String phonenumber){

        setup(browserName);
        login = new LoginPage(driver);
        patient = new AddPatient(driver);
        testpage = new TestPage(driver);
        addPatient = new AddPatient(driver);
        SoftAssert softAssert = new SoftAssert();

        login.doLogin(username, password);
        testpage.goToTestTab().addNewPatientTest();

        addPatient.addPatientContactDetails(name,email,phonenumber);
    }


}
