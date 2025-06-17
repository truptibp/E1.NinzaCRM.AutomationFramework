package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	  //Login into application
	@FindBy(id="username")
	private WebElement usernameText;
		
	@FindBy(id="inputPassword")
	private WebElement inputPasswordText;
	
	@FindBy(xpath="//button[.='Sign In']")
	private WebElement loginBtn;

	public WebElement getUsernameText() {
		return usernameText;
	}

	public WebElement getInputPasswordText() {
		return inputPasswordText;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//BusinessLibrary
	/**
	 * This methods is used to login into the application.
	 * 
	 * @param UN
	 * @param Passwd
	 */
	public void LogIntoApp(String UN,String Passwd)
	{
		usernameText.sendKeys(UN);
		inputPasswordText.sendKeys(Passwd);
		loginBtn.click();
		
	}
	
	 
}
