package mail.gooogle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.AbstrPage;

public class DraftGoogle extends AbstrPage {

	private final String GO_TO_SEND = "//a[contains(text(),'Отправленные')]";

	public DraftGoogle(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = GO_TO_SEND)
	private WebElement gotoSendLettersYaRu;

	public SendLetterGoogle openDraftLetter(String topic) {
		driver.findElement(By.xpath("//span[@title='" + topic + "']")).click();
		return new SendLetterGoogle(driver);
	}

	public LogoutGoogle goToSendLetters(){
		gotoSendLettersYaRu.click();
		return new LogoutGoogle(driver);
	}
	
	
	
}
