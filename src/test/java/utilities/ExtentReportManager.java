package utilities;


import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	private static ExtentReports extentreport;
	private static ExtentSparkReporter htmlrepoter;
	private static ExtentTest testreport;
	
	public static void setReport() {
		htmlrepoter = new ExtentSparkReporter("./Reports/HTML/extent.html");
		htmlrepoter.config().setEncoding("utf-8");
		htmlrepoter.config().setDocumentTitle("GOR Pathology and Diagonistic Project Report");
		htmlrepoter.config().setReportName("Automation Test Report");
		htmlrepoter.config().setTheme(Theme.DARK);
		
		extentreport = new ExtentReports();
		extentreport.attachReporter(htmlrepoter);
		
		extentreport.setSystemInfo("Automation tester", "Arnab");
		extentreport.setSystemInfo("Build NO: ","12344");
		extentreport.setSystemInfo("Organization","hag");
		
		
	} 
	
	public static void updateResult(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			Markup markup = MarkupHelper.createLabel("Test case failed", ExtentColor.RED);
			testreport.fail(markup);
		}else if (result.getStatus()==ITestResult.SUCCESS) {
			
			
			
		}else if(result.getStatus()==ITestResult.SKIP){
			
		}
	}
	
	public static void endRepoter() {
		extentreport.flush();
	}

}
