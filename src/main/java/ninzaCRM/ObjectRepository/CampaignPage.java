package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
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
	
	//Click on Contact link
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(linkText="Quotes")
	private WebElement quotesLnk;
	
	@FindBy(linkText="Purchase Order")
	private WebElement purchaseOrderLnk;	
	

	public WebElement getContactsLnk() {
		return contactsLnk;
	}


	public WebElement getLeadsLnk() {
		return leadsLnk;
	}


	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}


	public WebElement getProductsLnk() {
		return productsLnk;
	}


	public WebElement getQuotesLnk() {
		return quotesLnk;
	}


	public WebElement getPurchaseOrderLnk() {
		return purchaseOrderLnk;
	}


	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Business Library
	/**
	 * This method will click on "+ Create Campaign" Button
	 */
	public void clickOnCreateCampaignBtn()
	{
		createCampaignBtn.click();
	}
	
	public void clickOnContactsLnk()
	{
		contactsLnk.click();
	}

	public void clickOnLeadsLnk()
	{
		leadsLnk.click();
	}
	
	public void clickOnOppournitiesLnk()
	{
		opportunitiesLnk.click();
	}
	
	public void clickOnQuotesLnk()
	{
		quotesLnk.click();
	}
	
	public void clickOnPurchaseOrderLnk()
	{
		purchaseOrderLnk.click();
	}
}
