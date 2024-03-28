package PageClass;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.PageBaseClass;

public class LandingPage extends PageBaseClass{
	
	PageBaseClass pagebaseclass = new PageBaseClass();
	
	
	 public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver=driver;
	}


	public void closePopup() { 
		 //String iframe_name = driver.findElement(By.xpath("//iframe[@name='notification-frame-~10cb45141']")).getAttribute("name");
		 
		 //pagebaseclass.switch_iframe(driver,iframe_name);
		 
		// driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
		 
		 WebElement element = driver.findElement(By.xpath("//div[@class='imageSlideContainer']//span[@data-cy='closeModal']"));
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", element); 
		 
		 
	  }
	 
	  
	public void selectTrip() {
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
	}
	
	public void EnterFromCity(String cityName) throws InterruptedException {
		WebElement sourceCity = driver.findElement(By.id("fromCity"));
		sourceCity.sendKeys(cityName);
		Thread.sleep(2000);
		List<WebElement> autoSuggestions = driver.findElements(By.xpath("//li[@role='option']"));
		pagebaseclass.selectCity(driver,sourceCity,autoSuggestions);	
	} 
	

	public void EnterToCity(String cityName) throws InterruptedException {
		WebElement sourceCity = driver.findElement(By.id("toCity"));
		sourceCity.sendKeys(cityName);
		Thread.sleep(2000);
		List<WebElement> autoSuggestions = driver.findElements(By.xpath("//li[@role='option']"));
		pagebaseclass.selectCity(driver,sourceCity,autoSuggestions);
		
	}
	
	
	public void EnterDepartureDate(String date) throws InterruptedException {
		
		List<WebElement> calendar = driver.findElements(By.xpath("(//div[@class='dateInnerCell']/p[1])"));
		int count = calendar.size();
		//System.out.println("Lenght:- "+count);
		for(int i=1;i<count;i++) {
			String dates = calendar.get(i).getText();
			//System.out.println(dates);
			if(dates.equals(date)) {
				WebElement Our_date = calendar.get(i);
				System.out.println("Xpath:- "+Our_date);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
				wait.until(ExpectedConditions.elementToBeClickable(Our_date));
				pagebaseclass.Javascript_Executor(driver, Our_date);
				//Our_date.click();
				break;
			}
		}
		
		System.out.println("**************************************************");
		}
	
	public FlightDetailPage Click_Search() {
		driver.findElement(By.xpath("//p[@data-cy='submit']/a")).click();
		return PageFactory.initElements(driver, FlightDetailPage.class);
	}
		
}
