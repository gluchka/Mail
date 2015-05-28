package mail.yaru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.AbstrPage;

public class SendLetterYaRu  extends AbstrPage{

	private final String  CLICK_TO_SEND = "compose-submit"; 

	public SendLetterYaRu(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = CLICK_TO_SEND)
	private WebElement sendLetterClick;
	
	public PersAccountYaRu clickSignInButton(WebDriver driver){
		sendLetterClick.click();
		return new PersAccountYaRu(driver);
	}	
	

}
