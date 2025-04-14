package utilities;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class TestUtils extends BaseTest {
	
	
	public static void takeScreenShots() {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 	
		Date date= new Date();
		String screenShotsName = date.toString().replace(":", "_").replace(" ", "_");
		File targerFile = new File(System.getProperty("user.dir")+"//target//screenShots//"+screenShotsName+".jpg");
		srcFile.renameTo(targerFile);
	}

}
