package mail.iua.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.AbstrPage;
import abstractElements.AbstrUser;

public class PersAccountIUA extends AbstrPage{


	public PersAccountIUA(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private final String NEW_LETTER_BUTTON =".//*[@class='block-toolbar'][1]//a[@href='#compose']"; 
	private final String GOTO_DRAFTS ="//a[@href='#draft']";  
	private final String GOTO_ENTER = "//a[contains(text(),'¬ход€щие')]";
	
	@FindBy(xpath = NEW_LETTER_BUTTON)
	private WebElement writeLetterButtonYaRu;
		
	@FindBy(xpath = GOTO_ENTER)
	private WebElement gotoENTERButtonYaRu;
	
	@FindBy(xpath = GOTO_DRAFTS)
	private WebElement gotoDraftButtonYaRu;
	
	public WriteLetterIUA writeLetterClick(WebDriver driver){
		writeLetterButtonYaRu.click();
		return new WriteLetterIUA(driver);
	}
	
	public PersAccountIUA goToEnetrClick(){
		gotoENTERButtonYaRu.click();
		return new PersAccountIUA(driver);
	}
		
	public DraftIUA goToDraftsClick(WebDriver driver){
		gotoDraftButtonYaRu.click();
		return new DraftIUA(driver);
	}
	
}
