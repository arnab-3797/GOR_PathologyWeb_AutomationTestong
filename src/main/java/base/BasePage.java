package base;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;

	public BasePage(WebDriver driver) {

		BasePage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='title']")
	public static WebElement pagetitle;

	public String getPageTitle() {

		return getValueFromText(pagetitle);
	}

	public void clickToElemennt(WebElement element) {

		element.click();
	}

	public void writeText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void selectlementFromDropdown(List<WebElement> dropdownpotions, String optionname) {

		for (WebElement dropdownoption : dropdownpotions) {
			if (dropdownoption.getText().trim().equalsIgnoreCase(optionname)) {
				clickToElemennt(dropdownoption);
				break;
				// text = dropdownoption.getText();
			}
		}

	}

	public String getValueFromText(WebElement element) {

		return element.getText();

	}

	public int getSumOfNumberFromString(List<WebElement> elements) {

		Pattern pattern = Pattern.compile("(//d+)");
		int total = 0;
		for (WebElement element : elements) {

			String text = element.getText();

			Matcher matcher = pattern.matcher(text);

			if (matcher.find()) {

				int amount = Integer.parseInt(matcher.group(1));
				total += amount;
			}
		}
		return total;

	}

	public void scrollDownToSpecificElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void scrollDownToButtomOfThePage() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	
	public void explisiteWait(WebElement element) {
		
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driverWait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
}
