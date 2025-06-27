package testCases;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AddPatient;
import pages.GeneralDetailsPage;
import pages.LoginPage;
import pages.TestPage;
import utilities.DataUtil;

public class GeneralDetails_TestCases extends BaseTest {



    AddPatient patient;
    LoginPage login;
    TestPage testpage;
    AddPatient addPatient;
    GeneralDetailsPage generalDetails;

    @Test(dataProviderClass = DataUtil.class, dataProvider= "dp")
    public void verifySecondaryDetails_positive(String username, String password, String browserName,String name, String email, String phonenumber, String height,String weight,String age,String gender,String sys_pressure,String dia_pressure,String expectedResult){

        setup(browserName);
        log.info(browserName +" Browser is initialized");
        login = new LoginPage(driver);
        patient = new AddPatient(driver);
        testpage = new TestPage(driver);
        addPatient = new AddPatient(driver);
        generalDetails = new GeneralDetailsPage(driver);
        SoftAssert softAssert = new SoftAssert();

        login.doLogin(username, password);
        log.info("logged in with: "+ username+" "+password);
        testpage.goToTestTab().addNewPatientTest().addPatientContactDetails(name,email,phonenumber)
                .addGeneralDetailsOfPatient();
        log.info("Navigate to the General Details Page...");
        generalDetails.secondaryDetailsFields(height,weight,age,gender).bloodPressure(sys_pressure,dia_pressure);
        log.info("Value assigned to Height, Weight, age , Gender, blood pressure page.");
        String actualResult = generalDetails.addTestToPatient().getAddPatientProgressBarText();
        log.info("Actual Title is: "+actualResult);
        softAssert.assertEquals(actualResult,expectedResult,"Text are not matching.");
        softAssert.assertAll();


    }

}
