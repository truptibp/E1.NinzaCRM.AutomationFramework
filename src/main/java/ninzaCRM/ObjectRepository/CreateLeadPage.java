package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreateLeadPage extends SeleniumUtility
{
	//Declaration
	@FindBy(name="name")
	private WebElement leadNameText;
	
	@FindBy(name="company")
	private WebElement companyNameText;
	
	@FindBy(name="leadSource")
	private WebElement leadSourceText;
	
	@FindBy(name="industry")
	private WebElement industryText;
	
	@FindBy(name="phone")
	private WebElement phoneText;
	
	@FindBy(name="leadStatus")
	private WebElement leadStatusText;
	
	@FindBy(name="rating")
	private WebElement ratingText;
	
	//select +campaign button
	@FindBy(xpath="//*[local-name()='svg']/parent::button")
	private WebElement selectCampaignBtn;
	
	//select campaign drop down
	@FindBy(id="search-criteria")
	private WebElement selDropDown;
	
	//search by campaign name 
	@FindBy(id="search-input")
	private WebElement searchCampaignText;
	
	@FindBy(xpath="//button[.='Create Lead']")
	private WebElement createLeadBtn;
	
	//Initialization (Constructor)
	public CreateLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	//Utilization
	public WebElement getLeadNameText() {
		return leadNameText;
	}

	public WebElement getCompanyNameText() {
		return companyNameText;
	}

	public WebElement getLeadSourceText() {
		return leadSourceText;
	}

	public WebElement getIndustryText() {
		return industryText;
	}

	public WebElement getPhoneText() {
		return phoneText;
	}

	public WebElement getLeadStatusText() {
		return leadStatusText;
	}

	public WebElement getSelectCampaignBtn() {
		return selectCampaignBtn;
	}

	public WebElement getSelDropDown() {
		return selDropDown;
	}

	public WebElement getSearchCampaignText() {
		return searchCampaignText;
	}

	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}
	
	//Business Library
	public void createLeadWithCampaign(WebDriver driver,String CampaignName,String LeadName,String Company,String LeadSource,String Industry,String Phone,
			String LeadStatus,String Rating) throws InterruptedException
	{
		leadNameText.sendKeys(LeadName);
		companyNameText.sendKeys(Company);
		leadSourceText.sendKeys(LeadSource);
		industryText.sendKeys(Industry);
		phoneText.sendKeys(Phone);
		leadStatusText.sendKeys(LeadStatus);
		ratingText.sendKeys(Rating);
		
		//click on +  btn
		selectCampaignBtn.click();
		
		//transfer window control from parent to child (campaign window)
		switchToWindow(driver,"Campaign");
		Thread.sleep(3000);
		
		//select Campaign name using "Campaign by Name" drop down
		handleDropdown("Campaign Name", selDropDown);
		
		//enter campaign name in search text text box
		searchCampaignText.sendKeys(CampaignName);
		
		Thread.sleep(3000);
		
		//select campaign from the table using "select" button in the table row
		driver.findElement(By.xpath("//td[.='"+CampaignName+"']/following-sibling::td/child::button")).click();
		Thread.sleep(3000);
		
		switchToWindow(driver,"Ninza");
		
		Thread.sleep(4000);
		
		//Create Lead button
		createLeadBtn.click();
		
		
	}
	
}
