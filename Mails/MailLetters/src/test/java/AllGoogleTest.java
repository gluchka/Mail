import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import mail.gooogle.googleHelper.StepsGoogle;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import abstractElements.Drivers;

public class AllGoogleTest {

	private static WebDriver driver = null;
	StepsGoogle googleMail;


	@Test(description=" login to email")
	public void GoogleTestLogin() {
		googleMail = new StepsGoogle("userYRtest", "useruser123","userYRtest@gmail.com", "Theme", "TEXT");
		googleMail.loginToEmail(Drivers.chooseFirefoxDriver(),"https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/&hl=ru#identifier");
	}

	 @Test(dependsOnMethods={ "GoogleTestLogin" },description=" draft, send letter")
	 public void mainGoogleFunctional(){
		 googleMail.choosewriteLetter();
		 googleMail.writeLetter("gluchka@ukr.net");
		 googleMail.openDraftLetter();	
		 googleMail.sendLetter();
		 googleMail.checkThatLetterSend();
	 }
	
	
	 @Test(dependsOnMethods={ "mainGoogleFunctional" },description=" logout")
	 public void logoutFromMail(){
	googleMail.logout();
	 }

}
