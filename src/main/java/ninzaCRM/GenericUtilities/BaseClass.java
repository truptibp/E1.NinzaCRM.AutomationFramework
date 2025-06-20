package ninzaCRM.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ninzaCRM.ObjectRepository.CampaignPage;
import ninzaCRM.ObjectRepository.LoginPage;



/**
 * This class consists of all basic Configuration Annotations of TestNG
 * @author Chaitra M
 *
 */
public class BaseClass {
	
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;
	
	//For listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("======== DB Connection Successfull =========");
	}
	
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		
		driver = new EdgeDriver();
		
//		if(BROWSER.equals("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else if(BROWSER.equals("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
		
		sUtil.maximizeWindow(driver);
		sUtil.addimplicitlyWait(driver);
		
		driver.get(URL);
		
		System.out.println("======== Browser launch Successfull =========");
		
		//For Listeners
		sdriver=driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.LogIntoApp(USERNAME, PASSWORD);
		
		System.out.println("======== Login to App Successfull =========");
	}

	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		CampaignPage p=new CampaignPage(driver);
		p.logoutOfApp(driver);
		
		System.out.println("======== Logout of App Successfull =========");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("======== Browser closure Successfull =========");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("======== DB closure Successfull =========");
	}
}
