package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CampaignPage extends SeleniumUtility
{
	@FindBy(xpath="//span[.='Create Campaign']")
	private WebElement createCampaignBtn;

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}
	
	//click on User icon
	@FindBy(xpath="//div[@class='user-icon']")
	private WebElement userIcon;
	
	//click on campaigns link
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLnk;
	
	//Click on Contact link
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	//click on Leads link
	@FindBy(linkText="Leads")
	private WebElement leadsLnk;
	
	//click on opportunities link
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;
	
	//click on products link
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	//click on quotes
	@FindBy(linkText="Quotes")
	private WebElement quotesLnk;
	
	//click on purchase order
	@FindBy(linkText="Purchase Order")
	private WebElement purchaseOrderLnk;	
	
	//click on LogOut link
	@FindBy(xpath="//div[@class='dropdown-item logout']")
	private WebElement logOutLnk;

	public WebElement getLogOutLnk() {
		return logOutLnk;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}
	
	public WebElement getCampaignsLnk() {
		return campaignsLnk;
	}

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

	//Constructor
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
	
	public void clickOnProductsLnk()
	{
		productsLnk.click();
	}
	
	public void clickOnQuotesLnk()
	{
		quotesLnk.click();
	}
	
	public void clickOnPurchaseOrderLnk()
	{
		purchaseOrderLnk.click();
	}
	
	/**
	 * This method is used to logout of the application.
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException
	{		
		 mouseOverAction(driver, userIcon);
		 Thread.sleep(5000);
		 logOutLnk.click();
	}
}
