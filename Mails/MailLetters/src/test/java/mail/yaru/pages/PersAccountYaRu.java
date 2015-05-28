package mail.yaru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.AbstrPage;
import abstractElements.AbstrUser;

public class PersAccountYaRu extends AbstrPage{

	private final String NEW_LETTER_BUTTON =".//*[@class='block-toolbar'][1]//a[@href='#compose']"; 
	private final String GOTO_DRAFTS ="//a[@href='#draft']";  
	private final String GOTO_ENTER = "//a[@title='¬ход€щие']";   //  //a[contains(text(),'¬ход€щие')]

	public PersAccountYaRu(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = NEW_LETTER_BUTTON)
	private WebElement writeLetterButtonYaRu;
		
	@FindBy(xpath = GOTO_ENTER)
	private WebElement gotoENTERButtonYaRu;
	
	@FindBy(xpath = GOTO_DRAFTS)
	private WebElement gotoDraftButtonYaRu;
	
	public WriteLetterYaRu writeLetterClick(WebDriver driver){
		writeLetterButtonYaRu.click();
		return new WriteLetterYaRu(driver);
	}
	
	public PersAccountYaRu goToEnetrClick(){
		gotoENTERButtonYaRu.click();
		return new PersAccountYaRu(driver);
	}
		
	public DraftYaRu goToDraftsClick(WebDriver driver){
		gotoDraftButtonYaRu.click();
		return new DraftYaRu(driver);
	}
	
}
