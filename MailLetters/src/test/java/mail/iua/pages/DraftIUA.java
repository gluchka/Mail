package mail.iua.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.AbstrPage;

public class DraftIUA extends AbstrPage {

	private final String GO_TO_SEND = "//a[contains(text(),'Отправленные')]";

	public DraftIUA(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = GO_TO_SEND)
	private WebElement gotoSendLettersYaRu;

	public SendLetterIUA openDraftLetter(String topic) {
		driver.findElement(By.xpath("//span[@title='" + topic + "']")).click();
		return new SendLetterIUA(driver);
	}

	public LogoutIUA goToSendLetters(){
		gotoSendLettersYaRu.click();
		return new LogoutIUA(driver);
	}
	
	
	
}
