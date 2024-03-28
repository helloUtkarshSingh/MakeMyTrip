package TestClass;

import org.testng.annotations.Test;

import BaseClass.PageBaseClass;
import PageClass.FlightConfirmationPage;
import PageClass.FlightDetailPage;
import PageClass.LandingPage;
import PageClass.LoginPage;
import PageClass.PaymentPage;
import PageClass.SeatNFoodSeletionPage;


public class BookFlightTest extends PageBaseClass{
	
	//LandingPage landingPage = new LandingPage();
	FlightDetailPage  flightDetailPage;
	LoginPage loginpage;
	FlightConfirmationPage flightconfirmationpage;
	SeatNFoodSeletionPage seatNfoodselectionpage;
	PaymentPage paymentpage;
	
	@Test()
	public void First() throws InterruptedException {
		//landingPage.InvokeBrowser("Chrome");
		//landingPage.OpenApplication();
		Thread.sleep(2000);
		System.out.println(landingPage.getPageTitle());
		
		//landingPage.login();
		
		landingPage.closePopup();
		Thread.sleep(1000);
		//landingPage.closeAdd();
		Thread.sleep(5000);
		//landingPage.selectTrip();
		
		landingPage.EnterFromCity("Goa");  //from city
		
		landingPage.EnterToCity("Bengaluru"); //to city
		
		Thread.sleep(2000);	
		landingPage.EnterDepartureDate("30");
		
		flightDetailPage = landingPage.Click_Search();
		Thread.sleep(2000);
		
		System.out.println(flightDetailPage.getPageTitle());
		//flightDetailPage.close_Popup();
		loginpage = flightDetailPage.cheapest_flight();
		loginpage.getWindowHandle();
		System.out.println(loginpage.getPageTitle());
		flightconfirmationpage = loginpage.login("7738340710");
		
		Thread.sleep(2000);
		seatNfoodselectionpage = flightconfirmationpage.user_details("Utkarsh","Singh","singhutkarsh19991016@gmail.com");
		
		seatNfoodselectionpage.selectionSeat();
		seatNfoodselectionpage.FoodChoices();
		paymentpage = seatNfoodselectionpage.proceed_to_pay();
		
		paymentpage.Select_PaymentOption("Credit/Debit/ATM Card");
		paymentpage.CardDetail("1234567890123456", "Utkarsh Singh", "December (12)", "2024", "333", "India", "Maharashtra", "J/302 Mumbai", "Mumbai", "401107");
		
	}

}
