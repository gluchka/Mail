package mail.iua.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.AbstrPage;

public class LoginIUA extends AbstrPage {

	private final String  LOGIN_YARU = "//input[@name='login']"; 
	private final String  PASSWORD_YARU = "//input[@name='passwd']";  
	private final String  LOGIN_BUTTON_YARU ="//button[@type='submit']"; 
			
	public LoginIUA(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = LOGIN_YARU)
	private WebElement loginYaRuTextField;

	@FindBy(xpath = PASSWORD_YARU)
	private WebElement passYaRuTextField;
	
	@FindBy(xpath = LOGIN_BUTTON_YARU)
	private WebElement loginButtonYaRu;
	
	public LoginIUA enterLogin(String login){
		loginYaRuTextField.sendKeys(login);
		return this;
	}


	public LoginIUA enterPassword(String password){
		passYaRuTextField.sendKeys(password);
		return this;
	}
	
	public PersAccountIUA clickSignInButton(WebDriver driver){
		loginButtonYaRu.click();
		return new PersAccountIUA(driver);
	}
	

	
	
	
}
