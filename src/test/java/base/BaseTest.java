package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class BaseTest {

	public static WebDriver driver;
	private static Properties config = new Properties();
	private static Properties or = new Properties();
	private static FileInputStream fileinput;
	private static Logger log = Logger.getLogger(BaseTest.class.getName());
	public static WebDriverWait wait;
	public static WebElement dropDown;

	public static void click(String key) {

		if (key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(or.getProperty(key))).click();
		} else if (key.endsWith("_ID")) {
			driver.findElement(By.id(or.getProperty(key))).click();
		} else if (key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(key))).click();
		}
		log.info("Cliclinf on element: " + key);
	}

	public static void select(String key, String value) {

		if (key.endsWith("_XPATH")) {
			dropDown = driver.findElement(By.xpath(or.getProperty(key)));
		} else if (key.endsWith("_ID")) {
			dropDown = driver.findElement(By.id(or.getProperty(key)));
		} else if (key.endsWith("_CSS")) {
			dropDown = driver.findElement(By.cssSelector(or.getProperty(key)));
		}

		Select select = new Select(dropDown);
		select.selectByVisibleText(value);
		log.info("Selecting the value from drop down " + key);
	}

	public static void type(String key, String value) {

		if (key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(or.getProperty(key))).sendKeys(value);
		} else if (key.endsWith("_ID")) {
			driver.findElement(By.id(or.getProperty(key))).sendKeys(value);
		} else if (key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(key))).sendKeys(value);
		}
		log.info("Cliclinf on element: " + key + " Selected value is " + value);
	}

	public static boolean isElementPresent(String key) {

		if (key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(or.getProperty(key))).isSelected();
		} else if (key.endsWith("_ID")) {
			driver.findElement(By.id(or.getProperty(key))).isSelected();
		} else if (key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(key))).isSelected();
		}
		log.info("Cliclinf on element: " + key);
		return false;
	}

	public void setup(String browserName) {


			try {
				fileinput = new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				fileinput = new FileInputStream(".\\src\\test\\resources\\properties\\locator.properties");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			try {
				config.load(fileinput);
				log.info("Config property file loaded");
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				or.load(fileinput);
				log.info("Locator property file loaded");
			} catch (IOException e) {

				e.printStackTrace();
			}

			if (browserName.equals("chrome")) {

				driver = new ChromeDriver();
				log.info("Lunching Chrome...");

			} else if (browserName.equals("firefox")) {

				driver = new FirefoxDriver();
				log.info("Lunching Firefox...");

			}

			else if (browserName.equals("edge")) {

				driver = new EdgeDriver();
				log.info("Lunching Edge...");
			}

			driver.get(config.getProperty("applicationUrl"));
			log.info("Navigate to: " + config.getProperty("applicationUrl"));
			driver.manage().window().maximize();
			driver.manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
			wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty(""))));

		

	}

	@AfterMethod
	public static void tearDown() {

		driver.quit();
		log.info("Driver is closed!!");
	}

}
