package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage
{
	//Declaration
	//click on +AddProduct button
	@FindBy(xpath="//span[.='Add Product']")
	private WebElement addProductBtn;
	
	//Get all the existing product names from the table.
	@FindBy(xpath="//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> productsText;
	
	//Initialization
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
	
	//Utilization
	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public List<WebElement> getProductsText() {
		return productsText;
	}
	
	//BusinessLibrary
	public void clickOnAddProductBtn()
	{
		addProductBtn.click();
	}
	
	//Validation
	public void captureProductsNamesAndCompare(String RequiredProductName)
	{
		for (WebElement ele:productsText) {
			String ProductName = ele.getText();
			if(ProductName.equals(RequiredProductName))
			{
				System.out.println("Product added successfully");
				break;
			}
			
		}
	}

	
}
