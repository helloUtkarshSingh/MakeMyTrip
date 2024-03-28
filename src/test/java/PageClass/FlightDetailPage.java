package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BaseClass.PageBaseClass;

public class FlightDetailPage extends PageBaseClass{
	
	PageBaseClass pagebaseclass = new PageBaseClass();
	
	
	public FlightDetailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void close_Popup() {
		driver.findElement(By.xpath("//button[@class='button buttonSecondry buttonBig fontSize12 relative']")).click();
		System.out.println("POP-Up closed");
	}
	
	public LoginPage cheapest_flight() throws InterruptedException {
		WebElement viewPrices = driver.findElement(By.xpath("(//span[@class='appendRight8'])[1]"));
		pagebaseclass.Javascript_Executor(driver, viewPrices);
		System.out.println("View Prices is clicked");
		Thread.sleep(2000);
		
		
		WebElement bookPrice = driver.findElement((By.xpath("(//div[@class='viewFareBtnCol  '])[1]/button")));
		pagebaseclass.Javascript_Executor(driver, bookPrice );
        System.out.println("Book Now is clicked");
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
} 

