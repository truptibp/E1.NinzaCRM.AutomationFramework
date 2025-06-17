package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage
{
	@FindBy(xpath="//span[.='Create Campaign']")
	private WebElement createCampaignBtn;

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Business Library
	/**
	 * This method will click on "+ Create Campaign" Button
	 */
	public void ClickOnCreateCampaignBtn()
	{
		createCampaignBtn.click();
	}
	

}
