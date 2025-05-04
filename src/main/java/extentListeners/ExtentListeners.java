package extentListeners;

import java.util.Date;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListeners implements ITestListener, ISuiteListener{
	
	static Date date = new Date();

	static String fileName = "Extent"+ date.toString().replace(":","_").replace(" ", "_")+".jpg";
	private static ExtentReports extentreport = ExtentReportManager.createInstance(".target\\Reports\\HTML\\" + fileName);

	
	public static ExtentTest testreport;
	
	
	
	
	
	public void onTestStart(ITestResult result) {
	    
		testreport = extentreport.createTest(result.getTestClass().getName() + "  @TestCase : " + result.getMethod().getMethodName());
	  }
	
	
	public void onTestSuccess(ITestResult result) {
	    
		
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + "Passed" +"</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testreport.pass(markup);
	  }
	
	public void onTestFailure(ITestResult result) {
		
		TestUtils.takeScreenShots();
		
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + "Failed" + "</b>";
		
		testreport.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",MediaEntityBuilder.createScreenCaptureFromPath(fileName)
				.build());
	
		
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		testreport.log(Status.FAIL, m);
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
		testreport.fail(markup);
		
	}
	
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + "Skipped" + "</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testreport.skip(markup);
	  }
	
	public void onFinish(ITestContext context) {
		if(extentreport != null) {
			extentreport.flush();
		}
	  }
	

}
 