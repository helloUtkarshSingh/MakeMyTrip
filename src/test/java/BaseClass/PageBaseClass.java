package BaseClass;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import PageClass.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PageBaseClass {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver InvokeBrowser(String BrowserName) {
		
		if(BrowserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	@BeforeMethod
	public LandingPage OpenApplication() {
		driver = InvokeBrowser("Chrome");
		landingPage = new LandingPage(driver);
		driver.get("https://www.makemytrip.com/");
		return landingPage;
	}
	
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void Javascript_Executor(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
	}
	
	public void wait(WebElement button) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(button));
	}
	
	public void switch_iframe(WebDriver driver,String iframe_name) {
		driver.switchTo().frame(iframe_name);
	}
	
	public void selectFromDropDown(List<WebElement> element, String toselect) {
		for (int i = 0; i < element.size(); i++) {
			String element_item = element.get(i).getText();
			
			if(element_item.contentEquals(toselect)) {
				System.out.println(element_item);
				element.get(i).click();
				break;
			}
			
			/*
			 * if(element_item.equalsIgnoreCase(toselect)) {
			 * System.out.println(element_item); element.get(i).click(); break; }
			 */
		}
	}
	
	public void selectCity(WebDriver driver,WebElement cityLoctor, List<WebElement> autoSuggestions) throws InterruptedException {

		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofMinutes(10));
		wait1.until(ExpectedConditions.visibilityOfAllElements(autoSuggestions));
		Thread.sleep(2000);
	
		System.out.println(autoSuggestions.get(0).getText());
		WebElement option1 = autoSuggestions.get(0);
		option1.click();
	
		System.out.println("**************************************************");
}
	public void waitelementToBeClickable(WebDriver driver,WebElement loctor) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(loctor));
	}
	
	public void waitTillVisibilityofElement(WebDriver driver, WebElement loctor) {
		WebDriverWait wait1= new WebDriverWait(driver, Duration.ofMinutes(1));
		wait1.until(ExpectedConditions.visibilityOf(loctor));
	}
	
	
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
}
