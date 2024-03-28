package PageClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.PageBaseClass;

public class PaymentPage extends PageBaseClass{
	PageBaseClass pagebaseclass = new PageBaseClass();

	public PaymentPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void Select_PaymentOption(String payment_option) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(1));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='payment__option__title font12']")));
		
		List<WebElement> All_payment_options = driver.findElements(By.xpath("//div[@class='payment__option__title font12']"));
		pagebaseclass.selectFromDropDown(All_payment_options,payment_option);
		
		  //CardDetail.click();
		 
		
	}
	
	public void CardDetail(String CardNumber, String CardName, String Month, String Year, String cvv,String Country,String State, String Address, String City, String PinCode) throws InterruptedException {
		driver.findElement(By.id("cardNumber")).sendKeys(CardNumber);
		driver.findElement(By.id("nameOnCard")).sendKeys(CardName);
		
		driver.findElement(By.xpath("//p[text()='Month']")).click();
		List<WebElement> expiryMonths = driver.findElements(By.xpath("//div[@class='month__select__wrap']//li"));
		pagebaseclass.selectFromDropDown(expiryMonths, Month);
		
		driver.findElement(By.xpath("//p[text()='Year']")).click();
		List<WebElement> expiryyear = driver.findElements(By.xpath("//div[@class='year__select__wrap']//li"));
		pagebaseclass.selectFromDropDown(expiryyear, Year);
		
		driver.findElement(By.id("cardCvv")).sendKeys(cvv);
		
		driver.findElement(By.xpath("//div[@class=' css-1hwfws3']")).click();
		Thread.sleep(2000);
		List<WebElement> country = driver.findElements(By.xpath("//div[@class=' css-11unzgr']/div"));
		pagebaseclass.selectFromDropDown(country, Country);
		
		driver.findElement(By.id("billingAddress")).sendKeys(Address);
		
		driver.findElement(By.id("billingState")).sendKeys(State);
		
		driver.findElement(By.id("billingCity")).sendKeys(City);
		
		driver.findElement(By.id("billingPinCode")).sendKeys(PinCode);
		
		driver.findElement(By.xpath("//button[@type='button']")).click();
	}

}
