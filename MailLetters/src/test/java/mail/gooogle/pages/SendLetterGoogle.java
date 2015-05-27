package mail.gooogle.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.AbstrPage;

public class SendLetterGoogle  extends AbstrPage{

	public SendLetterGoogle(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private final String  CLICK_TO_SEND = "compose-submit"; 
	
	
	@FindBy(id = CLICK_TO_SEND)
	private WebElement sendLetterClick;
	
	public PersAccountGoogle clickSignInButton(WebDriver driver){
		sendLetterClick.click();
		return new PersAccountGoogle(driver);
	}	
	

}
