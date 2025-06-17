package ninzaCRM.Practise;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateCampaignTest {
	
  @Test
  public void tc_01_createCampaignTest() 
  {
	  //launch the browser
	  WebDriver driver =new EdgeDriver();
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
	  driver.findElement(By.name("campaignName")).sendKeys("Media20");
	  driver.findElement(By.name("targetSize")).sendKeys("5");
	  driver.findElement(By.xpath("//button[.='Create Campaign']")).click();
	  
	  
  }
}
