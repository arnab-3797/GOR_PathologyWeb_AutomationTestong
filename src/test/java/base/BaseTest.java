package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import utilities.ExcelReader;

public class BaseTest {

	public WebDriver driver;
	public Properties config = new Properties();
	public FileInputStream fileinput;
	public Logger log = Logger.getLogger(BaseTest.class.getName());
	public ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\LoginData.xlsx");
	public WebDriverWait wait;
	static WebElement dropDown;

	public void setup(String browserName) {

		try {
			fileinput = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fileinput);
			log.info("Config property file loaded");
		} catch (IOException e) {

			e.printStackTrace();
		}

		if (browserName.equals("chrome")) {

			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Lunching Chrome...");

		} else if (browserName.equals("firefox")) {

			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Lunching Firefox...");

		}

		else if (browserName.equals("edge")) {

			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info("Lunching Edge...");
		}

		driver.get(config.getProperty("applicationUrl"));
		log.info("Navigate to: " + config.getProperty("applicationUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));

	}

	public void captureScreenShots() {

		Date date = new Date();
		String screenShotsName = date.toString().replace(":", "_").replace(" ", "_");
		File srcFile = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);
		File targerFile = new File(
				System.getProperty("user.dir") + "//target//screenShots//" + screenShotsName + ".jpg");
		srcFile.renameTo(targerFile);
	}

	public static void captureElementScreenShot(WebElement element) {

		Date date = new Date();
		String screenShotsName = date.toString().replace(":", "_").replace(" ", "_");
		File srcFile = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);
		File targerFile = new File(System.getProperty("user.dir") + "//screenShots//" + screenShotsName + ".jpg");
		srcFile.renameTo(targerFile);

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
		log.info("Driver is closed!!!");
	}

}
