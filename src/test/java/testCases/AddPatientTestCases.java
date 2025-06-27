package testCases;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @Test(dataProviderClass = DataUtil.class, dataProvider= "dp")
    public void verifyPatientContactDetails(String username, String password, String browserName,String name, String email, String phonenumber, String expectedTitle){

        setup(browserName);
        log.info(browserName +" Browser is initialized");
        login = new LoginPage(driver);
        patient = new AddPatient(driver);
        testpage = new TestPage(driver);
        addPatient = new AddPatient(driver);
        SoftAssert softAssert = new SoftAssert();

        login.doLogin(username, password);
        log.info("logged in with: "+ username+" "+password);
        testpage.goToTestTab().addNewPatientTest();
        log.info("Navigate to the Add New Patient's Page...");

        addPatient.addPatientContactDetails(name,email,phonenumber);
        log.info("Fill the add patient form with- "+name+","+email+","+phonenumber);

        String actualTitle = addPatient.addGeneralDetailsOfPatient().getPageTitle();
        softAssert.assertEquals(actualTitle, expectedTitle,"Tilted is not matching: "+ actualTitle);
        softAssert.assertAll();
    }


    @Test(dataProviderClass = DataUtil.class, dataProvider= "dp")
    public void verify_WithoutName_TestCase(String username, String password, String browserName,String name, String email, String phonenumber, String expectedMsg){


        setup(browserName);
        log.info(browserName +" Browser is initialized");
        login = new LoginPage(driver);
        patient = new AddPatient(driver);
        testpage = new TestPage(driver);
        addPatient = new AddPatient(driver);
        SoftAssert softAssert = new SoftAssert();

        login.doLogin(username, password);
        log.info("logged in with: "+ username+" "+password);
        testpage.goToTestTab().addNewPatientTest();
        log.info("Navigate to the Add New Patient's Page...");

        System.out.println(phonenumber);
        addPatient.addPatientContactDetails(name,email,phonenumber);
        log.info("Fill the add patient form with- "+name+","+email+","+phonenumber);
        addPatient.addGeneralDetailsOfPatient();
        log.info("clicking on General Details ofnpatient button..... ");
        String actualMsg = addPatient.getAlertMsg();
        softAssert.assertEquals(actualMsg, expectedMsg,"Tilted is not matching: "+ actualMsg);
        captureScreenShots();
        softAssert.assertAll();


    }

    @Test(dataProviderClass = DataUtil.class, dataProvider= "dp")
    public void verify_WithoutPhone_TestCase(String username, String password, String browserName,String name, String email, String phonenumber, String expectedMsg){


        setup(browserName);
        log.info(browserName +" Browser is initialized");
        login = new LoginPage(driver);
        patient = new AddPatient(driver);
        testpage = new TestPage(driver);
        addPatient = new AddPatient(driver);
        SoftAssert softAssert = new SoftAssert();

        login.doLogin(username, password);
        log.info("logged in with: "+ username+" "+password);
        testpage.goToTestTab().addNewPatientTest();
        log.info("Navigate to the Add New Patient's Page...");

        System.out.println(phonenumber);
        addPatient.addPatientContactDetails(name,email,phonenumber);
        log.info("Fill the add patient form with- "+name+","+email+","+phonenumber);
        addPatient.addGeneralDetailsOfPatient();
        log.info("clicking on General Details ofnpatient button..... ");
        String actualMsg = addPatient.getAlertText();
        softAssert.assertEquals(actualMsg, expectedMsg,"Tilted is not matching: "+ actualMsg);
        captureScreenShots();
        softAssert.assertAll();


    }
    @Test(dataProviderClass = DataUtil.class, dataProvider= "dp")
    public void verify_cancelBtn(String username, String password, String browserName,String expectedTitle){

        setup(browserName);
        log.info(browserName +" Browser is initialized");
        login = new LoginPage(driver);
        patient = new AddPatient(driver);
        testpage = new TestPage(driver);
        addPatient = new AddPatient(driver);
        SoftAssert softAssert = new SoftAssert();

        login.doLogin(username, password);
        log.info("logged in with: "+ username+" "+password);
        String actualTitle = testpage.goToTestTab().addNewPatientTest().cancelAddPatientContactDetails().getPageTitle();
        log.info("Navigate to the Add New Patient's Page...");
        softAssert.assertEquals(actualTitle,expectedTitle);

    }

}
