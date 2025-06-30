package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrdersPage 
{
	//Declaration
	@FindBy(xpath="//span[.='Create Order']")
	private WebElement createOrderBtn;

	//Get all the existing purchase orders from the table.
	@FindBy(xpath="//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> purchaseOrdersText;
	
	//Initialisation
	public PurchaseOrdersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateOrderBtn() {
		return createOrderBtn;
	}

	public List<WebElement> getPurchaseOrdersText() {
		return purchaseOrdersText;
	}
	
	
	//Business Library
	public void clickOnCreateOrderBtn()
	{
		createOrderBtn.click();
	}
	
	//Validation
	public void capturePurchaseOrdersAndCompare(String RequiredPurchaseOrder) throws InterruptedException
	{
		for (WebElement ele:purchaseOrdersText) {
			String PurchaseOrder = ele.getText();
			if(PurchaseOrder.equals(RequiredPurchaseOrder))
			{
				System.out.println("Order Created successfully");
				//Thread.sleep(6000);
				break;
			}
			
		}
	}

}
