package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class BaseTest{
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fileinput;

	public void setup(){
		
		if(driver==null) {
			
			
			try {
				fileinput = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
							try {
								fileinput = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\locator.properties");
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			try {
				config.load(fileinput);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				or.load(fileinput);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		
		or.getProperty("email");
		or.getProperty("password");
		or.getProperty("loginbtn");
		or.getProperty("setpasswordbtn");
		
		
		
		
		
		config.getProperty("browser");
		config.getProperty("url");
		
		
		
		
	}
	
}
