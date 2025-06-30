package ninzaCRM.PurchaseOrdersTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.AddProductPage;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.ContactsPage;
import ninzaCRM.ObjectRepository.CreateCampaignPage;
import ninzaCRM.ObjectRepository.CreateContactPage;
import ninzaCRM.ObjectRepository.CreatePurchaseOrderPage;
import ninzaCRM.ObjectRepository.ProductsPage;
import ninzaCRM.ObjectRepository.PurchaseOrdersPage;

@Listeners(ninzaCRM.GenericUtilities.ListenersImplementation.class)

public class CreatePurchaseOrderTest extends BaseClass
{
	@Test
	public void tc_01_CreatePurchaseOrderTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//Read the data from excel file
		String CAMPAIGNNAME = eUtil.readDataFromExcel("System", 1, 2)+jUtil.getRandomNumber();
		System.out.println(CAMPAIGNNAME);
		String TARGETSIZE = eUtil.readDataFromExcel("System", 1, 26);
		
		//COntact
		String CONTACTNAME = eUtil.readDataFromExcel("System", 1, 3);
		String MOBILE=eUtil.readDataFromExcel("System", 1, 4);
		String ORGANIZATION=eUtil.readDataFromExcel("System", 1, 5);
		String TITLE=eUtil.readDataFromExcel("System", 1, 6);
		
		//Product
		String PRODUCTNAME=eUtil.readDataFromExcel("System", 1, 7)+jUtil.getRandomNumber();
		String CATEGORY=eUtil.readDataFromExcel("System", 1, 8);
		String QUANTITY=eUtil.readDataFromExcel("System", 1, 9);
		String PRICE=eUtil.readDataFromExcel("System", 1, 10);		
		String VENDOR=eUtil.readDataFromExcel("System", 1, 11);
		
		//Purchase order
		String SUBJECT = eUtil.readDataFromExcel("System", 1, 12)+jUtil.getRandomNumber();
		String DUEDATE = eUtil.readDataFromExcel("System", 1, 13);
		String BILLINGADDRESS = eUtil.readDataFromExcel("System", 1, 14);
		String BILLINGPOBOX = eUtil.readDataFromExcel("System", 1, 15);
		String BILLINGCITY = eUtil.readDataFromExcel("System", 1, 16);
		String BILLINGSTATE = eUtil.readDataFromExcel("System", 1, 17);
		String BILLINGPOSTALCODE = eUtil.readDataFromExcel("System", 1, 18);
		String BILLINGCOUNTRY = eUtil.readDataFromExcel("System", 1, 19);
		String SHIPPINGADDRESS = eUtil.readDataFromExcel("System", 1, 20);
		String SHIPPINGPOBOX = eUtil.readDataFromExcel("System", 1, 21);
		String SHIPPINGCITY = eUtil.readDataFromExcel("System", 1, 22);
		String SHIPPINGSTATE = eUtil.readDataFromExcel("System", 1, 23);
		String SHIPPINGPOSTALCODE = eUtil.readDataFromExcel("System", 1, 24);
		String SHIPPINGCOUNTRY = eUtil.readDataFromExcel("System", 1, 25);
		
		Thread.sleep(4000);
		
		//click on +Create Campaign button
		CampaignPage cp=new CampaignPage(driver);
		cp.clickOnCreateCampaignBtn();
		
		Thread.sleep(4000);
		
		//Create Campaign with Mandatory fields
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		ccp.createCampaign(CAMPAIGNNAME, TARGETSIZE);
		
		Thread.sleep(6000);
		
		//click on Contacts link
		cp.clickOnContactsLnk();
		
		Thread.sleep(4000);
		
		//click on +Create Contact button
		ContactsPage conp=new ContactsPage(driver);
		conp.clickOnCreateContactBtn();
		
		Thread.sleep(4000);
		
		//Create Contact with mandatory fields
		CreateContactPage cconp=new CreateContactPage(driver);
		cconp.createContactWithCampaign(driver, ORGANIZATION, TITLE, CONTACTNAME, MOBILE, CAMPAIGNNAME);
		
		Thread.sleep(6000);
		
		//Validate for Contact
		conp.captureContactNamesAndCompare(CONTACTNAME);
		System.out.println(CONTACTNAME);
		
		Thread.sleep(6000);
		
		cp.clickOnProductsLnk();
		
		//click on +Add product btn
		ProductsPage p=new ProductsPage(driver);
		p.clickOnAddProductBtn();
		
		Thread.sleep(5000);
		
		//Add new product
		AddProductPage ap=new AddProductPage(driver);
		ap.AddProductWithMandatoryFields(PRODUCTNAME, QUANTITY, PRICE,CATEGORY,VENDOR);
		
		Thread.sleep(6000);
		
		//Validate		
		p.captureProductsNamesAndCompare(PRODUCTNAME);		
		System.out.println(PRODUCTNAME + " product added successfully");	
		
		Thread.sleep(6000);
		
		//click on purchase order link
		cp.clickOnPurchaseOrderLnk();
		
		Thread.sleep(4000);
		//Click on +Create order btn
		PurchaseOrdersPage po=new PurchaseOrdersPage(driver);
		po.clickOnCreateOrderBtn();
		
		Thread.sleep(4000);
		
		//Create purchase order
		CreatePurchaseOrderPage order=new CreatePurchaseOrderPage(driver);
		
		order.createPurchaseOrderWithProductAndContact(driver,CONTACTNAME,PRODUCTNAME,SUBJECT,DUEDATE,
				BILLINGADDRESS,BILLINGPOBOX,BILLINGCITY,BILLINGSTATE,BILLINGPOSTALCODE,BILLINGCOUNTRY,
				SHIPPINGADDRESS,SHIPPINGPOBOX,SHIPPINGCITY,SHIPPINGSTATE, 
				 SHIPPINGPOSTALCODE,SHIPPINGCOUNTRY);
		
		//Validate for purchase order
		po.capturePurchaseOrdersAndCompare(SUBJECT);
		System.out.println(SUBJECT);
		
		Thread.sleep(8000);
		
	}

}
