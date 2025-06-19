package ninzaCRM.Practise;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateCampaignTest {
	
  @Test
  public void tc_01_createCampaignTest() throws InterruptedException 
  {
	  //launch the browser
	  WebDriver driver = new EdgeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  //Navigate to the application.
	  driver.get("http://49.249.28.218:8098/");
	  
	  //Login into application
	  driver.findElement(By.id("username")).sendKeys("rmgyantra");
	  driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	  driver.findElement(By.xpath("//button[.='Sign In']")).click();
	  
	  //Click on Create Campaign button
	  driver.findElement(By.xpath("//span[.='Create Campaign']")).click();
	  
	  //Create Campaign with Mandatory fields
	  driver.findElement(By.name("campaignName")).sendKeys("sales1234");
	  driver.findElement(By.name("targetSize")).sendKeys("5");
	  driver.findElement(By.xpath("//button[.='Create Campaign']")).click();
	  
	  Thread.sleep(7000);
	  
	  //Click on Contact link
	  driver.findElement(By.linkText("Contacts")).click();
	  
	  //Click on +Create Contact button
	  driver.findElement(By.xpath("//span[.='Create Contact']")).click();
	  
	  //Create Contact with mandatory fields
	  driver.findElement(By.name("organizationName")).sendKeys("Qspiders1");
	  driver.findElement(By.name("title")).sendKeys("teaching");
	  driver.findElement(By.name("contactName")).sendKeys("Radha");
	  driver.findElement(By.name("mobile")).sendKeys("9980236581");
	  
	  //Navigate to Campaign page in Contacts
	  driver.findElement(By.xpath("//*[local-name()='svg']/parent::button")).click();
	  
	  //Handle window pop up
	  String MainwinId = driver.getWindowHandle();
	  System.out.println("MainWinID= "+ MainwinId);
	 
	  Set<String> ChildWinIds = driver.getWindowHandles();
	  System.out.println(ChildWinIds);
	  
	  for(String WinId:ChildWinIds )
	  {
		if(!WinId.equals(MainwinId))
		{
			driver.switchTo().window(WinId);
			System.out.println("Child window= "+ WinId);
			break;
		}
	  }
	  System.out.println("Switch from parent to child successful");
	  
	 //Search for Campaign in Child window.
	 WebElement selDropdown = driver.findElement(By.id("search-criteria"));
	 Select  s=new Select(selDropdown);
	 s.selectByVisibleText("Campaign Name");
	 
	 driver.findElement(By.id("search-input")).sendKeys("sales1234");
	 driver.findElement(By.xpath("//td[.='sales1234']/following-sibling::td/child::button")).click();
	 
	 //transfer the control back to mainwindow
	 driver.switchTo().window(MainwinId);
	 
	 //click on "Create Contact" button
	 driver.findElement(By.xpath("//button[.='Create Contact']")).click();
	
	 System.out.println("Contact created successfully");
	 
	 Thread.sleep(8000);
	 
	 //Logout of the application
	 WebElement ele = driver.findElement(By.xpath("//div[@class='user-icon']"));
	 Actions a=new Actions(driver);
	 a.moveToElement(ele).perform();
	 
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
	 System.out.println("Logout of the application successfull.");
	
	  
	  
  }
}
