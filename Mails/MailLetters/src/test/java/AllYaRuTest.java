import static org.testng.Assert.assertTrue;
import mail.yaru.yaruHelper.StepsYaRu;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import abstractElements.Drivers;

public class AllYaRuTest {

	private static WebDriver driver = null;
	StepsYaRu yaruMail;

//	@BeforeTest
//	public void login(){
//	}
//	@AfterTest
//	public void closeDriver(){
//		driver.quit();
//	}
	@Test
	public void YandexTest() {
		yaruMail = new StepsYaRu("userYRtest", "useruserYR","userYRtest@yandex.ru", "Theme", "TEXT");
		yaruMail.loginToEmail(Drivers.chooseFirefoxDriver(),"http://mail.yandex.ua");		
		assertTrue(yaruMail.loginCorrect());
		yaruMail.choosewriteLetter();
		yaruMail.writeLetter();
		yaruMail.openDraftLetter();
		yaruMail.sendLetter();
		yaruMail.checkThatLetterSend();	
	}

	
	@Test
	public void logout(){
		yaruMail.logout();
		driver.quit();
	}
	
	
}
