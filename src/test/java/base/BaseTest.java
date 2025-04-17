package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class BaseTest {

	public RemoteWebDriver driver;
	private Properties config = new Properties();
	private Properties or = new Properties();
	private FileInputStream fileinput;
	private Logger log = Logger.getLogger(BaseTest.class.getName());
	public WebDriverWait wait;

	public void setup(String browser) {

		if (driver == null) {

			try {
				fileinput = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fileinput = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\locator.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fileinput);
				log.info("Config property file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				or.load(fileinput);
				log.info("Locator property file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(config.getProperty("browser").equals("chrome")) {
				
				
				driver = new ChromeDriver();
				log.info("Lunching Chrome...");
			}
				
			} else if(config.getProperty("browser").equals("firefox")) {
				
				driver = new FirefoxDriver();
				log.info("Lunching Firefox...");
				
			}
		
			else if(config.getProperty("browser").equals("Edge")) {
				
				
				driver = new EdgeDriver();
				log.info("Lunching Edge...");
			}
		
		driver.get(config.getProperty("url"));
		log.info("Navigate to: " + config.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty(""))));


	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		log.info("Driver is closed!!");
	}

}
