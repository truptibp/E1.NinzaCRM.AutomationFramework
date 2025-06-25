package ninzaCRM.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage
{
	//Declaration
	@FindBy(xpath="//span[text()='Create Opportunity']")
	private WebElement createOpportunityBtn;
	
	//Get all the existing opportunity names from the table.
	@FindBy(xpath="//table[@class='table table-striped table-hover']/tbody/tr[*]/td[2]")
	private List<WebElement> opportunityNamesText;
	
	//Initialization
	public OpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateOpportunityBtn() {
		return createOpportunityBtn;
	}

	public List<WebElement> getOpportunityNamesText() {
		return opportunityNamesText;
	}
	
	
	//BusinessLibrary
	public void clickOnCreateOpportunityBtn()
	{
		createOpportunityBtn.click();
	}
	
	public void captureOpportunityNamesAndCompare(String RequiredContactName)
	{
		for (WebElement ele:opportunityNamesText) {
			String OpportunityName = ele.getText();
			if(OpportunityName.equals(RequiredContactName))
			{
				System.out.println("Opportunity Created successfully");
				break;
			}
			
		}
	}
}
