package ninzaCRM.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.ContactsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateContactPage;

@Listeners(ninzaCRM.GenericUtilities.ListenersImplementation.class)
public class CreateContactTest extends BaseClass
{
	@Test(groups="SmokeSuite")
	public void tc_01_createContactTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Read the data from excel file
		String CAMPAIGNNAME = eUtil.readDataFromExcel("Integration", 4, 2)+jUtil.getRandomNumber();
		System.out.println(CAMPAIGNNAME);
		String TARGETSIZE = eUtil.readDataFromExcel("Integration", 4, 7);
		
		String CONTACTNAME = eUtil.readDataFromExcel("Integration", 4, 3);
		String ORGANIZATION=eUtil.readDataFromExcel("Integration", 4, 5);
		String TITLE=eUtil.readDataFromExcel("Integration", 4, 6);
		String MOBILE=eUtil.readDataFromExcel("Integration", 4, 4);
		
		Thread.sleep(7000);
		
		//click on +Create Campaign button
		CampaignPage cp=new CampaignPage(driver);
		cp.clickOnCreateCampaignBtn();
		
		//Create Campaign with Mandatory fields
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
		
		Thread.sleep(8000);
		
		//click on Contacts link
		cp.clickOnContactsLnk();
		
		//click on +Create Contact button
		ContactsPage conp=new ContactsPage(driver);
		conp.clickOnCreateContactBtn();
		
		//Create Contact with mandatory fields
		CreateContactPage cconp=new CreateContactPage(driver);
		cconp.createContactWithCampaign(driver, ORGANIZATION, TITLE, CONTACTNAME, MOBILE, CAMPAIGNNAME);
		
		//Validate for Contact
		conp.captureContactNamesAndCompare(CONTACTNAME);
		System.out.println(CONTACTNAME);
		
		Thread.sleep(6000);
		
		
		
	}

}
