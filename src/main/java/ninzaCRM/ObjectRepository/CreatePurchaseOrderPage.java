package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreatePurchaseOrderPage extends SeleniumUtility
{
	@FindBy(name="subject")
	private WebElement subjectText;
	
	@FindBy(name="dueDate")
	private WebElement dueDateText;
	
	//billing address
	@FindBy(xpath="(//textarea)[1]")
	private WebElement billingaddressText;
	
	@FindBy(xpath="(//input[@name='poBox'])[1]")
	private WebElement billingpoBoxText;
	
	@FindBy(xpath="(//input[@name='city'])[1]")
	private WebElement billingcityText;
	
	@FindBy(xpath="(//input[@name='state'])[1]")
	private WebElement billingstateText;
	
	@FindBy(xpath="(//input[@name='postalCode'])[1]")
	private WebElement billingpostalCodeText;
	
	@FindBy(xpath="(//input[@name='country'])[1]")
	private WebElement billingcountryText;
	
	//shipping address
	@FindBy(xpath="(//textarea)[2]")
	private WebElement shippingaddressText;	
	
	@FindBy(xpath="(//input[@name='poBox'])[2]")
	private WebElement shippingpoBoxText;
		
	@FindBy(xpath="(//input[@name='city'])[2]")
	private WebElement shippingcityText;	
	
	@FindBy(xpath="(//input[@name='state'])[2]")
	private WebElement shippingstateText;
		
	@FindBy(xpath="(//input[@name='postalCode'])[2]")
	private WebElement shippingpostalCodeText;
		
	@FindBy(xpath="(//input[@name='country'])[2]")
	private WebElement shippingcountryText;
	
	@FindBy(xpath="//button[.='Create Purchase Order']")
	private WebElement createPurchaseOrderBtn;
	
	//select +contact button
	@FindBy(xpath="(//*[local-name()='svg']/parent::button)[1]")
	private WebElement selectContactBtn;
	
	//select Contact by name drop down
	@FindBy(id="search-criteria")
	private WebElement selContactDropDown;
	
	//search contact name
	@FindBy(id="search-input")
	private WebElement searchContactText;
	
	//select +AddProduct button
	@FindBy(xpath="(//*[local-name()='svg']/parent::button)[2]")
	private WebElement selectProductBtn;
	
	//select Product by Contact drop down
	@FindBy(id="search-criteria")
	private WebElement selProductDropDown;
	
	//search product 
	@FindBy(id="search-input")
	private WebElement searchProductText;
	
	
	
	public WebElement getSelectContactBtn() {
		return selectContactBtn;
	}

	public WebElement getSelContactDropDown() {
		return selContactDropDown;
	}

	public WebElement getSearchContactText() {
		return searchContactText;
	}

	public WebElement getSelectProductBtn() {
		return selectProductBtn;
	}

	public WebElement getSelProductDropDown() {
		return selProductDropDown;
	}

	public WebElement getSearchProductText() {
		return searchProductText;
	}

	public WebElement getCreatePurchaseOrderBtn() {
		return createPurchaseOrderBtn;
	}

	public WebElement getSubjectText() {
		return subjectText;
	}

	public WebElement getDueDateText() {
		return dueDateText;
	}

	public WebElement getBillingaddressText() {
		return billingaddressText;
	}

	public WebElement getShippingaddressText() {
		return shippingaddressText;
	}

	public WebElement getBillingpoBoxText() {
		return billingpoBoxText;
	}

	public WebElement getShippingpoBoxText() {
		return shippingpoBoxText;
	}

	public WebElement getBillingcityText() {
		return billingcityText;
	}

	public WebElement getShippingcityText() {
		return shippingcityText;
	}

	public WebElement getBillingstateText() {
		return billingstateText;
	}

	public WebElement getShippingstateText() {
		return shippingstateText;
	}

	public WebElement getBillingpostalCodeText() {
		return billingpostalCodeText;
	}

	public WebElement getShippingpostalCodeText() {
		return shippingpostalCodeText;
	}

	public WebElement getBillingcountryText() {
		return billingcountryText;
	}

	public WebElement getShippingcountryText() {
		return shippingcountryText;
	}

	//Initialization
	public CreatePurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business Library
	public void  createPurchaseOrderWithProductAndContact(WebDriver driver,
			String ContactName,String ProductName,String subject,
			String dueDate,String billingaddress,String billingpoBox,
			String billingcity,String billingstate,
			String billingpostalCode,String billingcountry,
			String shippingaddress,
			String shippingpoBox,
			String shippingcity,String shippingstate,
			String shippingpostalCode,
			 String shippingcountry) throws InterruptedException
	{
		
		subjectText.sendKeys(subject);
		dueDateText.sendKeys(dueDate);
		
		Thread.sleep(3000);
		
		//click +Contact btn
		selectContactBtn.click();
		
		switchToWindow(driver,"Contact");
		Thread.sleep(3000);
		
		//select contact name in drop down
		handleDropdown("Contact Name", selContactDropDown);
		
		//enter contact name to be searched.
		searchContactText.sendKeys(ContactName);
		Thread.sleep(3000);
		
		//select contact name from the table using "select" button in the table row
		driver.findElement(By.xpath("//td[.='"+ContactName+"']/following-sibling::td/child::button")).click();
		Thread.sleep(4000);

		switchToWindow(driver, "Ninza");
		
		Thread.sleep(3000);
				
		//Fill billing & shipping details
		billingaddressText.sendKeys(billingaddress);
		billingpoBoxText.sendKeys(billingpoBox);
		billingcityText.sendKeys(billingcity);
		billingstateText.sendKeys(billingstate);
		billingpostalCodeText.sendKeys(billingpostalCode);
		billingcountryText.sendKeys(billingcountry);
		shippingaddressText.sendKeys(shippingaddress);		
		shippingpoBoxText.sendKeys(shippingpoBox);		
		shippingcityText.sendKeys(shippingcity);		
		shippingstateText.sendKeys(shippingstate);		
		shippingpostalCodeText.sendKeys(shippingpostalCode);		
		shippingcountryText.sendKeys(shippingcountry);
		
		Thread.sleep(4000);
		
		//Fill products details.		
		selectProductBtn.click();
		
		switchToWindow(driver,"Product");
		Thread.sleep(4000);
		
		//select product name from drop down
		handleDropdown("Product Name", selProductDropDown);
		
		//enter product to be searched
		searchProductText.sendKeys(ProductName);
		Thread.sleep(3000);
		
		//select contact name from the table using "select" button in the table row
		driver.findElement(By.xpath("//td[.='"+ProductName+"']/following-sibling::td/child::button")).click();
		Thread.sleep(4000);
		
		switchToWindow(driver, "Ninza");
		
		Thread.sleep(3000);
		
		createPurchaseOrderBtn.click();
		
		Thread.sleep(5000);
	}
	

}
