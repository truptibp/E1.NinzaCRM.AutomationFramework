package ninzaCRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class AddProductPage extends SeleniumUtility
{
	//Declaration
	@FindBy(name="productName")
	private WebElement productNameText;	
	
	@FindBy(name="quantity")
	private WebElement quantityText;
	
	@FindBy(name="price")
	private WebElement priceText;
	
	@FindBy(name="productCategory")
	private WebElement selCategoryDropDown;
	
	@FindBy(name="vendorId")
	private WebElement selVendorDropDown;
	
	@FindBy(xpath="//button[.='Add']")
	private WebElement addBtn;
	
	public WebElement getAddBtn() {
		return addBtn;
	}

	//Initialization
	public AddProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getProductNameText() {
		return productNameText;
	}


	public WebElement getQuantityText() {
		return quantityText;
	}


	public WebElement getPriceText() {
		return priceText;
	}


	public WebElement getSelCategoryDropDown() {
		return selCategoryDropDown;
	}


	public WebElement getSelVendorDropDown() {
		return selVendorDropDown;
	}

	//Business Library
	public void AddProductWithMandatoryFields(String ProductName,String Quantity,String Price,String Category,String Vendor) throws InterruptedException
	{
		productNameText.sendKeys(ProductName);
		
		handleDropdown(Category,selCategoryDropDown);
		
		quantityText.sendKeys(Quantity);
		priceText.sendKeys(Price);
		
		handleDropdown(selVendorDropDown,Vendor);		
			
		Thread.sleep(6000);
		
		addBtn.click();
	}
	
}
