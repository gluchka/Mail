package mail.iua.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.AbstrPage;

public class WriteLetterIUA extends AbstrPage{

	private final String TO_RECIPIENT =".//*[@id='js-page']/div/div[5]/div/div[3]/div/div[3]/div/div/div/div/div/div/form/table/tbody/tr[3]/td[2]/div[2]/div/div/input"; 
	private final String LETTER_SUBJECT =".//*[@id='compose-subj']"; 
	private final String LETTER_CONTENT ="//*[@id='compose-send']"; 
	private final String CLICK_CANCEL_ADD_DRAFT =".//*[@href='#draft']"; 
	private final String CLICK_ADD_TO_DRAFT ="//html[@id='js']/body/div[6]//button"; 
	
	public WriteLetterIUA(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = TO_RECIPIENT)
	private WebElement enterRecipientField;
	
	@FindBy(xpath = LETTER_SUBJECT)
	private WebElement enterSubjectField;

	@FindBy(xpath = LETTER_CONTENT)
	private WebElement enter—ontentField;
	
	@FindBy(xpath =CLICK_CANCEL_ADD_DRAFT)
	private WebElement clickCancelButton;
	
	@FindBy(xpath = CLICK_ADD_TO_DRAFT)    
	private WebElement saveToDraftButton;
	
	public WriteLetterIUA enterRecipient(String recipient){
		enterRecipientField.sendKeys(recipient);
		return this;
	}
	
	public WriteLetterIUA enterSubject(String subject){
		enterSubjectField.sendKeys(subject);
		return this;
	}
	
	public WriteLetterIUA enter—ontent(String content){
		enter—ontentField.sendKeys(content);
		return this;
	}
	
	public WriteLetterIUA clickCancelButton(){
		clickCancelButton.click();
		return this;
	}
	
	public DraftIUA saveToDruftButton(WebDriver driver){
		saveToDraftButton.click();
		return new DraftIUA(driver);
	}
	
}
