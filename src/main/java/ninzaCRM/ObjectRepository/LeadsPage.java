package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage 
{
	//click on +Create lead button
	@FindBy(xpath="//span[.='Create Lead']")
	private WebElement createLeadBtn;
	
	//Get all the existing leads names from the table.
	@FindBy(xpath="//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> leadNamesText;

	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}

	public List<WebElement> getLeadNamesText() {
		return leadNamesText;
	}
	
	//Constructor
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business Library
	public void clickOnCreateLeadBtn()
	{
		createLeadBtn.click();
	}
	
	//Validation
	public void captureLeadNamesAndCompare(String RequiredLeadName)
	{
		for (WebElement ele:leadNamesText) {
			String LeadName = ele.getText();
			if(LeadName.equals(RequiredLeadName))
			{
				System.out.println("Lead Created successfully");
				break;
			}
			
		}
	}

}
