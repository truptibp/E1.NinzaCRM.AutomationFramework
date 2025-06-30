package ninzaCRM.ProductsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ninzaCRM.GenericUtilities.BaseClass;
import ninzaCRM.ObjectRepository.AddProductPage;
import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.ProductsPage;

@Listeners(ninzaCRM.GenericUtilities.ListenersImplementation.class)
public class AddProductTest extends BaseClass
{
	@Test
	public void tc_01_addProductTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String PRODUCTNAME=eUtil.readDataFromExcel("Functional", 1, 2)+jUtil.getRandomNumber();
		String QUANTITY=eUtil.readDataFromExcel("Functional", 1, 3);
		String PRICE=eUtil.readDataFromExcel("Functional", 1, 4);
		String CATEGORY=eUtil.readDataFromExcel("Functional", 1, 5);
		String VENDOR=eUtil.readDataFromExcel("Functional", 1, 6);
		
		Thread.sleep(4000);
		
		//click on products link
		CampaignPage cp=new CampaignPage(driver);
		cp.clickOnProductsLnk();
		
		Thread.sleep(5000);
		
		//click on +Add product btn
		ProductsPage p=new ProductsPage(driver);
		p.clickOnAddProductBtn();
		
		Thread.sleep(7000);
		
		//Add new product
		AddProductPage ap=new AddProductPage(driver);
		ap.AddProductWithMandatoryFields(PRODUCTNAME, QUANTITY, PRICE,CATEGORY,VENDOR);
		
		Thread.sleep(7000);
		
		//Validate		
		p.captureProductsNamesAndCompare(PRODUCTNAME);		

		System.out.println(PRODUCTNAME + " product added successfully");	
		
		
	}

}
