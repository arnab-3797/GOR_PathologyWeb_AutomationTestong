package extentListeners;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	private static ExtentReports extentreport;
	
	
	public static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter htmlrepoter = new ExtentSparkReporter(fileName);
		htmlrepoter.config().setEncoding("utf-8");
		htmlrepoter.config().setDocumentTitle("GOR Pathology and Diagonistic Project Report");
		htmlrepoter.config().setReportName("Automation Test Report");
		htmlrepoter.config().setTheme(Theme.DARK);
		
		extentreport = new ExtentReports();
		extentreport.attachReporter(htmlrepoter);
		
		extentreport.setSystemInfo("Automation tester", "Arnab");
		extentreport.setSystemInfo("Build NO: ","12344");
		extentreport.setSystemInfo("Organization","hag");
		
		return extentreport;
		
	} 
	/*
	public static void updateResult(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			String methodName = result.getMethod().getMethodName();
			Markup markup = MarkupHelper.createLabel("Test case failed: " + methodName.toUpperCase(), ExtentColor.RED);
			testreport.fail(markup);
			
		}else if (result.getStatus()==ITestResult.SUCCESS) {
			
			String methodName = result.getMethod().getMethodName();
			Markup markup = MarkupHelper.createLabel("Test case Passed: " + methodName.toUpperCase(), ExtentColor.GREEN);
			testreport.pass(markup);
			
		}else if(result.getStatus()==ITestResult.SKIP){
			
			String methodName = result.getMethod().getMethodName();
			Markup markup = MarkupHelper.createLabel("Test case skip: " + methodName.toUpperCase(), ExtentColor.YELLOW);
			testreport.skip(markup);
			
		}
	}
	
	public static void endRepoter() {
		
		if(extentreport != null) {
			extentreport.flush();
		}
		
	} */

}
