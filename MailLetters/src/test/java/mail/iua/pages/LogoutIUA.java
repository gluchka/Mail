package mail.iua.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractElements.AbstrPage;

public class LogoutIUA extends AbstrPage{

public LogoutIUA(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

private final String CLICK_TO_LOGOUT = ".//*[@id='nb-1']/span[1]";
private final String LOGOUT = "Выход";

	@FindBy(xpath = CLICK_TO_LOGOUT)
	private WebElement clicToLogoutYaRu;
	
	public LogoutIUA clickLogoutFromYaRu(){
		clicToLogoutYaRu.click();
	return this;
	}
	
	@FindBy(linkText = LOGOUT)
	private WebElement logoutYaRu;
	
	public void logoutYaRu(){
		logoutYaRu.click();
	
	}
	
}
