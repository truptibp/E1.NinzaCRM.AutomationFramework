package ninzaCRM.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ninzaCRM.GenericUtilities.SeleniumUtility;

public class CreateOpportunityPage extends SeleniumUtility
{
	//Declaration
	@FindBy(name="opportunityName")
	private WebElement opportunityNameText;
	
	@FindBy(name="amount")
	private WebElement amountText;
	
	@FindBy(name="businessType")
	private WebElement businessTypeText;
	
	@FindBy(name="nextStep")
	private WebElement nextStepText;
	
	@FindBy(name="salesStage")
	private WebElement salesStageText;
	
	//Select +Lead Button
	@FindBy(xpath="//*[local-name()='svg']/parent::button")
	private WebElement selectLeadBtn;
	
	//select lead drop down
	@FindBy(id="search-criteria")
	private WebElement selDropDown;
	
	//search by lead name 
	@FindBy(id="search-input")
	private WebElement searchLeadText;
	
	@FindBy(xpath="//button[.='Create Opportunity']")
	private WebElement createOpportunityBtn;
	
	public WebElement getOpportunityNameText() {
		return opportunityNameText;
	}

	public WebElement getAmountText() {
		return amountText;
	}

	public WebElement getBusinessTypeText() {
		return businessTypeText;
	}

	public WebElement getNextStepText() {
		return nextStepText;
	}

	public WebElement getSalesStageText() {
		return salesStageText;
	}

	public WebElement getSelectLeadBtn() {
		return selectLeadBtn;
	}

	public WebElement getSelDropDown() {
		return selDropDown;
	}

	public WebElement getSearchLeadText() {
		return searchLeadText;
	}

	public WebElement getCreateOpportunityBtn() {
		return createOpportunityBtn;
	}

	//Constructor
	public CreateOpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	//Business Library
	public void createOpportunityWithLead(WebDriver driver,String LeadName,String OpportunityName,String Amount,
			String BusinessType,String NextStep,String SalesStage) throws InterruptedException
	{
		opportunityNameText.sendKeys(OpportunityName);
		amountText.sendKeys(Amount);
		businessTypeText.sendKeys(BusinessType);
		nextStepText.sendKeys(NextStep);
		salesStageText.sendKeys(SalesStage);
		
		//click on + button
		selectLeadBtn.click();
		
		//transfer window control from parent to child (Lead window)
		switchToWindow(driver,"Lead");
		Thread.sleep(3000);
		
		//select Lead name using "Lead by Name" drop down
		handleDropdown("Lead Name", selDropDown);
		
		//enter Lead name in search text box
		searchLeadText.sendKeys(LeadName);
		
		Thread.sleep(3000);
		
		//select Lead from the table using "select" button in the table row
		driver.findElement(By.xpath("//td[.='"+LeadName+"']/following-sibling::td/child::button")).click();
		Thread.sleep(3000);
		
		switchToWindow(driver,"Ninza");
		
		Thread.sleep(4000);
		
		//Create Opportunity button
		createOpportunityBtn.click();
		
		
	}
	
	

}
