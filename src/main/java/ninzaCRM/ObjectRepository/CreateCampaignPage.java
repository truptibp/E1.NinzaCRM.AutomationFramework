package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage 
{
	@FindBy(name="campaignName")
	private WebElement campaignNametext;
	
	@FindBy(name="targetSize")
	private WebElement targetSizetext;
	
	@FindBy(xpath="//button[.='Create Campaign']")
	private WebElement createCampaignBtn;
	
	public WebElement getCampaignNametext() {
		return campaignNametext;
	}

	public WebElement getTargetSizetext() {
		return targetSizetext;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}

	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//BusinessLibrary
	/**
	 * This method is used to Create a new Campaign with mandatory fields.
	 * 
	 * @param CampaignName
	 * @param TargetSize
	 */
	public void createCampaign(String CampaignName,String TargetSize)
	{
		campaignNametext.sendKeys(CampaignName);
		targetSizetext.sendKeys(TargetSize);
		createCampaignBtn.click();
	}
	
	//optional with all fields
	public void createCampaignWithAllFields(String CampaignName,String TargetSize)
	{
		campaignNametext.sendKeys(CampaignName);
		targetSizetext.sendKeys(TargetSize);
		createCampaignBtn.click();
	}

}
