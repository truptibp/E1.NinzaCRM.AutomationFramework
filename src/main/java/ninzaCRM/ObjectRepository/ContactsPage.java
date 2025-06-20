package ninzaCRM.ObjectRepository;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage
{
	//click on "+ Create contact"
	@FindBy(xpath="//span[.='Create Contact']")
	private WebElement createContactBtn;
	
	//Contacts names
	@FindBy(xpath="//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> contactNamesText;
	
	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	public List<WebElement> getContactNamesText() {
		return contactNamesText;
	}

	//constructor
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business Library
	/**
	 * This method will click on "+Create Contact" button
	 */
	public void clickOnCreateContactBtn()
	{
		createContactBtn.click();
	}
	
	public void captureContactNamesAndCompare(String RequiredContactName)
	{
		for (WebElement ele:contactNamesText) {
			String ContactName = ele.getText();
			if(ContactName.equals(RequiredContactName))
			{
				System.out.println("Contact Created successfully");
				break;
			}
			
		}
	}
}
