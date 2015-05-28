
import mail.iua.pages.LoginPage;
import mail.iua.pages.MailPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import abstractElements.Drivers;

public class AllIUaTest {
		
		private WebDriver driver;
		protected LoginPage loginPage;
		protected MailPage iuaMail;

		@Test(description=" login to email")
		public void IUaTestLogin() {
			driver = Drivers.chooseFirefoxDriver();
			driver.get("http://i.ua/");
			loginPage = new LoginPage(driver);
			iuaMail = loginPage.typeUserName("useriua").typePassword("userpassword123").clickLoginButton();
			iuaMail.waitForEmailTitle();		
		}
		
		@Test(dependsOnMethods={ "IUaTestLogin" },description=" mainFunctional")
		public void mainIUafunction() {
			iuaMail.clickButtonWriteAMail();
			iuaMail.fillSendToTextField("gluchka@ukr.net").fillSubjectTextField("Test").fillMailBodyTextField("Text").clickButtonSaveInDrafts();
			iuaMail.clickOnLinkDraftsFolder().checkThatMailIsHere("Test");
			iuaMail.clickOnLetter("Test").compareDraftWithPreviousMail("Text");
			iuaMail.clickButtonSendMail();
			iuaMail.clickOnSentMailFolder().checkThatMailIsHere("Test");
			
		}

		 @Test(dependsOnMethods={ "mainIUafunction" },description=" logout")
		 public void logoutFromMail(){
			 iuaMail.clickButtonSettings().clickButtonExitMail();	
			 driver.quit();
		 }

}
