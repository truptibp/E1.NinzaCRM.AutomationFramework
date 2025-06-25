package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreateContactPage extends SeleniumUtility
{
	@FindBy(name="organizationName")
	private WebElement organizationNameText;
	
	@FindBy(name="title")
	private WebElement titleText;
	
	@FindBy(name="contactName")
	private WebElement contactNameText;

	@FindBy(name="mobile")
	private WebElement mobileText;
	
	//click on "+ Campaign button" 
	@FindBy(xpath="//*[local-name()='svg']/parent::button")
	private WebElement selectCampaignBtn;
	
	//select campaign drop down
	@FindBy(id="search-criteria")
	private WebElement selDropDown;
	
	//search by campaign name 
	@FindBy(id="search-input")
	private WebElement searchCampaignText;
	
	//Create contact button
	@FindBy(xpath="//button[.='Create Contact']")
	private WebElement createContactBtn;

	public WebElement getSelDropDown() {
		return selDropDown;
	}	

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public WebElement getSearchCampaignText() {
		return searchCampaignText;
	}
	
	public WebElement getSelectCampaignBtn() {
		return selectCampaignBtn;
	}

	public WebElement getOrganizationNameText() {
		return organizationNameText;
	}

	public WebElement getTitleText() {
		return titleText;
	}

	public WebElement getContactNameText() {
		return contactNameText;
	}

	public WebElement getMobileText() {
		return mobileText;
	}
	
	//Constructor
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business Library
	public void createContactWithCampaign(WebDriver driver,String OrganizationName ,String Title,String ContactName,String Mobile,String campaignName) throws InterruptedException
	{
		organizationNameText.sendKeys(OrganizationName);
		titleText.sendKeys(Title);
	    contactNameText.sendKeys(ContactName);
		mobileText.sendKeys(Mobile);
		
		selectCampaignBtn.click();
		
		//transfer window control from parent to child (campaign window)
		switchToWindow(driver,"Campaign");
		Thread.sleep(3000);
		
		//select Campaign name using Campaign by Name drop down
		handleDropdown("Campaign Name", selDropDown);
		
		//enter campaign name in search text text box
		searchCampaignText.sendKeys(campaignName);
		
		Thread.sleep(3000);
		
		//select campaign from the table using "select" button in the table row
		driver.findElement(By.xpath("//td[.='"+campaignName+"']/following-sibling::td/child::button")).click();
		Thread.sleep(3000);
		
		switchToWindow(driver,"Ninza");
		
		Thread.sleep(4000);
		
		createContactBtn.click();		
		
	}

}
