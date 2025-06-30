package ninzaCRM.LeadsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateLeadPage;
import ninzaCRM.ObjectRepository.LeadsPage;

@Listeners(ninzaCRM.GenericUtilities.ListenersImplementation.class)
public class CreateLeadTest extends BaseClass
{
	@Test
	public void tc_01_createLeadTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration", 1, 2)+jUtil.getRandomNumber();
		System.out.println(CAMPAIGNNAME);
		String TARGETSIZE = eUtil.readDataFromExcel("Integration", 1, 9);
		
		String LEADNAME = eUtil.readDataFromExcel("Integration", 1, 3);
		String COMPANY = eUtil.readDataFromExcel("Integration", 1, 4);
		String LEADSOURCE = eUtil.readDataFromExcel("Integration", 1, 5);
		String LEADSTATUS = eUtil.readDataFromExcel("Integration", 1, 6);
		String INDUSTRY = eUtil.readDataFromExcel("Integration", 1, 7);
		String PHONE = eUtil.readDataFromExcel("Integration", 1, 8);
		String RATING = eUtil.readDataFromExcel("Integration", 1, 10);
		
		Thread.sleep(7000);
		
		//click on +Create Campaign button
		CampaignPage cp=new CampaignPage(driver);
		cp.clickOnCreateCampaignBtn();
		
		//Create Campaign with Mandatory fields
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
		
		Thread.sleep(7000);
		
		//click on leads link
		cp.clickOnLeadsLnk();
		
		//click on +Create Lead
		LeadsPage lp=new LeadsPage(driver);
		lp.clickOnCreateLeadBtn();
		
		//Create Lead with Mandatory fields.
		CreateLeadPage clp=new CreateLeadPage(driver);
		clp.createLeadWithCampaign(driver, CAMPAIGNNAME, LEADNAME, COMPANY, LEADSOURCE, INDUSTRY, PHONE, LEADSTATUS,RATING);
		
		//Validate for Contact
		lp.captureLeadNamesAndCompare(LEADNAME);
		System.out.println(LEADNAME);
				
		Thread.sleep(8000);
				
	}

}
