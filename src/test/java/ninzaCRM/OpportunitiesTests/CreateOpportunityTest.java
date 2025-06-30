package ninzaCRM.OpportunitiesTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateLeadPage;
import ninzaCRM.ObjectRepository.CreateOpportunityPage;
import ninzaCRM.ObjectRepository.LeadsPage;
import ninzaCRM.ObjectRepository.OpportunitiesPage;

@Listeners(ninzaCRM.GenericUtilities.ListenersImplementation.class)
public class CreateOpportunityTest extends BaseClass
{
	@Test
	public void tc_01_createOpportunityTest() throws EncryptedDocumentException, IOException, InterruptedException

	{
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration", 7, 2)+jUtil.getRandomNumber();
		System.out.println(CAMPAIGNNAME);
		String TARGETSIZE = eUtil.readDataFromExcel("Integration", 7, 13);
		
		String LEADNAME = eUtil.readDataFromExcel("Integration", 7, 3);
		String COMPANY = eUtil.readDataFromExcel("Integration", 7, 4);
		String LEADSOURCE = eUtil.readDataFromExcel("Integration", 7, 5);
		String LEADSTATUS = eUtil.readDataFromExcel("Integration", 7, 6);
		String INDUSTRY = eUtil.readDataFromExcel("Integration", 7, 7);
		String PHONE = eUtil.readDataFromExcel("Integration", 7, 14);
		String RATING = eUtil.readDataFromExcel("Integration", 7, 15);
		
		String OPPORTUNITYNAME = eUtil.readDataFromExcel("Integration", 7, 8)+jUtil.getRandomNumber();
		String AMOUNT = eUtil.readDataFromExcel("Integration", 7, 9);
		String BUSINESSTYPE = eUtil.readDataFromExcel("Integration", 7, 10);
		String NEXTSTEP = eUtil.readDataFromExcel("Integration", 7, 11);
		String SALESSTAGE = eUtil.readDataFromExcel("Integration", 7, 12);
		
		Thread.sleep(7000);
		
		//click on +Create Campaign button
		CampaignPage cp=new CampaignPage(driver);
		cp.clickOnCreateCampaignBtn();
		
		//Create Campaign with Mandatory fields
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
		
		Thread.sleep(6000);
		
		//click on leads link
		cp.clickOnLeadsLnk();
		
		//click on +Create Lead
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLeadBtn();
		
		//Create Lead with Mandatory fields.
		CreateLeadPage clp=new CreateLeadPage(driver);
		clp.createLeadWithCampaign(driver, CAMPAIGNNAME, LEADNAME, COMPANY, LEADSOURCE, INDUSTRY, PHONE, LEADSTATUS,RATING);
			
		Thread.sleep(7000);
		
		//click on opportunities link
		cp.clickOnOppournitiesLnk();
		
		//click on +create opportunity
		OpportunitiesPage op=new OpportunitiesPage(driver);
		op.clickOnCreateOpportunityBtn();
		
		//click opportunity with lead 
		CreateOpportunityPage cop=new CreateOpportunityPage(driver);
		cop.createOpportunityWithLead(driver, LEADNAME, OPPORTUNITYNAME, AMOUNT, BUSINESSTYPE, NEXTSTEP, SALESSTAGE);
		
		//Validate 
		op.captureOpportunityNamesAndCompare(OPPORTUNITYNAME);
		System.out.println(OPPORTUNITYNAME);
		
		Thread.sleep(8000);	
		
		
	}
}