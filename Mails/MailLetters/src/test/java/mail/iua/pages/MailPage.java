package mail.iua.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {
	public final static String CREATE_A_MAIL_LINK = ".//*[@id='header_overall']/div[1]/ul[3]/li[1]/a";
	public final static String SEND_TO_TEXT_FIELD = "body>div.body_container>div.Body>div:nth-child(1)>div.Left>p>a";
	public final static String SAVE_DRAFT = "//ul[@class='list_underlined']//li[3]//a";
	public final static String TO = "to";
	public final static String SUBJECT = "subject";
	public final static String CONTENT = "text";
	public final static String SAVE_IN_DRAFT= "save_in_drafts";
	public final static String LINK_DRAFT_FOLDER = "//ul[@class='list_underlined']//li[3]//a";
	public final static String SEND_MAIL = "//input[@name='send']";
	public final static String SEND_MAIL_FOLDER = "//ul[@class='list_underlined']//li[2]/a";
	public final static String SETTINGS = "//body//ul[@class='ho_menu ho_menu-account']//li[@class='ho_menu_item'][3]";
	public final static String EXIT = "//*[@id='accountSettingsPopup']/ul/li[7]/a";
	
	private WebDriver driver;

	
	@FindBy(xpath = CREATE_A_MAIL_LINK)
	public static WebElement userMailName;

	@FindBy(css = SEND_TO_TEXT_FIELD)
	public static WebElement linkCreateAMail;

	@FindBy(id = TO)
	public WebElement sendToTextField;

	@FindBy(name = SUBJECT)
	public WebElement subjectTextField;

	@FindBy(id = CONTENT)
	public WebElement mailBodyTextField;

	@FindBy(name = SAVE_IN_DRAFT)
	public WebElement buttonSaveInDrafts;

	@FindBy(xpath = LINK_DRAFT_FOLDER)
	public WebElement linkDraftsFolder;

	@FindBy(xpath = SAVE_DRAFT)
	public WebElement linkOfSavedDraft;
	
	@FindBy(xpath = SEND_MAIL)
	public WebElement buttonSendMail;
	
	@FindBy(xpath = SEND_MAIL_FOLDER)
	public WebElement linkSendMailFolder;
	
	@FindBy(xpath = SETTINGS)
	public WebElement buttonSettings;
	
	@FindBy(xpath = EXIT)
	public WebElement buttonExitMail;

	
	public MailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}


	public void waitForEmailTitle() {
		WebDriverWait waitForOne = new WebDriverWait(driver, 10);
		waitForOne.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath(".//*[@id='header_overall']/div[1]/ul[3]/li[1]/a")));
	}


	public MailPage clickButtonWriteAMail() {
		linkCreateAMail.click();
		return new MailPage(driver);
	}

	public void waitForWritingMailPage() {
		WebDriverWait waitForOne = new WebDriverWait(driver, 10);
		waitForOne.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("/html/body/div[4]/div[5]//p[1]/input[1]")));
	}


	public MailPage fillSendToTextField(String mailBody) {
		sendToTextField.sendKeys(mailBody);
		return this;
	}

	public MailPage fillSubjectTextField(String subjectText) {
		subjectTextField.sendKeys(subjectText);
		return this;
	}

	public MailPage fillMailBodyTextField(String mailBodyText) {
		mailBodyTextField.sendKeys(mailBodyText);
		return this;
	}

	public MailPage clickButtonSaveInDrafts() {
		buttonSaveInDrafts.click();
		return new MailPage(driver);
	}


	public MailPage clickOnLinkDraftsFolder() {
		WebDriverWait waitForOne = new WebDriverWait(driver, 5);
		waitForOne.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//ul[@class='list_underlined']//li[3]//a")));
		linkDraftsFolder.click();
		return this;
	}

	public MailPage checkThatMailIsHere(String subjectText) {
		WebDriverWait waitForOne = new WebDriverWait(driver, 5);
		waitForOne.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//span[text()='" + subjectText + "']")));
		return this;
	}

	public MailPage clickOnLetter(String subjectText) {
		driver.findElement(By.xpath("//span[text()='" + subjectText + "']")).click();
		return new MailPage(driver);
	}
	
	public MailPage compareDraftWithPreviousMail(String mailBodyText) {
		WebDriverWait waitForOne = new WebDriverWait(driver, 5);
		waitForOne.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//textarea[@id='text']"))).toString().equals(mailBodyText);
		return this;
	}
	
	public MailPage clickButtonSendMail() {
		buttonSendMail.click();
		return new MailPage(driver);
	}
	
	public MailPage clickOnSentMailFolder() {
		linkSendMailFolder.click();
		return new MailPage(driver);
	}
	
	public MailPage clickButtonSettings() {
		buttonSettings.click();
		return this;
	}
	
	public LoginPage clickButtonExitMail() {
		buttonExitMail.click();
		return new LoginPage(driver);
	}
}