package PageClass;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.PageBaseClass;

public class LoginPage extends PageBaseClass{
	
	PageBaseClass pagebaseclass = new PageBaseClass();
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getWindowHandle() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent_window = it.next();
		String child_window = it.next();
		driver.switchTo().window(child_window);
	}
	
	public void Route() {
		System.out.println(driver.findElement(By.xpath("//h2[@class='blackFont']")).getText());
	}
	public FlightConfirmationPage login(String userName) {
		driver.findElement(By.xpath("//div[@data-cy='account']")).click();
		
		driver.findElement(By.id("username")).sendKeys(userName);
		
		WebElement continueButt = driver.findElement(By.xpath("//button[@data-cy='continueBtn']"));
		pagebaseclass.Javascript_Executor(driver, continueButt);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(3));
		By userName_locator = By.xpath("//span[@class='chUserInfoName latoBold']");
		Pattern pattern = Pattern.compile("[a-zA-Z]");
		wait.until(ExpectedConditions.textMatches(userName_locator,pattern));
	
		System.out.println("Login Done");
		return PageFactory.initElements(driver, FlightConfirmationPage.class);
		
	}
	
	

}
