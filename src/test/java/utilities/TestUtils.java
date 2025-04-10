package utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public class TestUtils extends BaseTest {
	
	
	public static void takeScreenShots() {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File targerFile = new File(System.getProperty("user.dir")+"//target//screenShots//error.jpg");
		srcFile.renameTo(targerFile);
	}

}
