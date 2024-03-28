package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import BaseClass.PageBaseClass;

public class SeatNFoodSeletionPage extends PageBaseClass{
	PageBaseClass pagebaseclass = new PageBaseClass();

	public SeatNFoodSeletionPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
	}
	
	public void selectionSeat() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='GOI$BLR$2023-11-30 23:40$6E-901_16A']")).click();
		Thread.sleep(3000);
		System.out.println("Seat selected");
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
	}
	
	public void FoodChoices() throws InterruptedException {
		System.out.println("Waiting start........");
		Thread.sleep(5000);
		System.out.println("Waiting stop........");
		
		//List<WebElement> foodchoices = driver.findElements(By.xpath("//label[@class='makeFlex hrtlCenter appendRight20 pointer']"));
		/*
		 * WebElement n = foodchoices.stream().filter(foodchoice->
		 * foodchoice.findElement(By.
		 * xpath("//span[@class='appendLeft10 boldFont fontSize14']")).getText().
		 * equalsIgnoreCase("Non Veg")).findAny().orElse(null);
		 */
		
		//System.out.println(n.getText());
		
		WebElement FoodChoice = driver.findElement(By.xpath("//input[@id='NON_VEG']"));
		pagebaseclass.Javascript_Executor(driver, FoodChoice);
	    
		System.out.println("NON_VEG selected");
		
		WebElement Dish_item = driver.findElement(By.xpath("(//button[@class='mealAddBtn'])[1]"));
		pagebaseclass.Javascript_Executor(driver, Dish_item);
		System.out.println("NON_VEG iteam selected");
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
	}
	
	public PaymentPage proceed_to_pay() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id='ACKNOWLEDGE_SECTION']//button")).click();
		Thread.sleep(3000);
		return  PageFactory.initElements(driver, PaymentPage.class);
	}

}
