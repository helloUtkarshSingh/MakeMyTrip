package PageClass;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.PageBaseClass;

public class FlightConfirmationPage extends PageBaseClass{
	PageBaseClass pagebaseclass = new PageBaseClass();
	
	public FlightConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public SeatNFoodSeletionPage user_details(String F_Name,String L_Name,String Email) throws InterruptedException {
		
		driver.findElement(By.xpath("(//p[@class='radioboxTitle'])[2]")).click(); //travel insurence
		Thread.sleep(3000);
		WebElement add_traveller_button = driver.findElement(By.xpath("//button[@class='addTravellerBtn']")); //traveller Detail
		//pagebaseclass.wait(add_traveller_button);
		
		pagebaseclass.waitelementToBeClickable(driver, add_traveller_button);
		add_traveller_button.click();
		
		System.out.println("Add Adult button is clicked");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='First & Middle Name']")).sendKeys(F_Name); // traveller first Name;
		System.out.println("Name is added button");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(L_Name); // traveller first Name;
		System.out.println("L Name is added button");
		driver.findElement(By.xpath("//input[@value='MALE']")).click(); // traveller Sex;
		System.out.println("Male gender is selected");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(Email); //traveller Email
		System.out.println("Email is added");
		
		List<WebElement> autosuggestions = driver.findElements(By.xpath("//div[@class='emailIds-dropdown']"));
		pagebaseclass.selectFromDropDown(autosuggestions, Email);
	
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		System.out.println("All detail is added");
		
		
		WebElement user_details_confirm_button = driver.findElement(By.xpath("//button[text()='CONFIRM']"));
		pagebaseclass.waitTillVisibilityofElement(driver, user_details_confirm_button);
		user_details_confirm_button.click();
		System.out.println("*************************");
		return PageFactory.initElements(driver, SeatNFoodSeletionPage.class);
		

	}

}
