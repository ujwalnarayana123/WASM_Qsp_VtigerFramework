package vtiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateMultipleOrgTest {
	
	ExcelFileUtility eUtil = new ExcelFileUtility();
	JavaUtility jUtil = new JavaUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	WebDriver driver;
	
	@Test(dataProvider = "OrgData")
	public void createMultipleOrgTest(String Org, String industry) throws IOException
	{
		//Step 2: Read all the necessary data
				String BROWSER = pUtil.readDataFromPFile("browser");
				String URL = pUtil.readDataFromPFile("url");
				String USERNAME = pUtil.readDataFromPFile("username");
				String PASSWORD = pUtil.readDataFromPFile("password");
				
				String ORGNAME = Org+jUtil.getRandomNumber();
				
				//Step 3: launch the browser - run time polymorphism
				if (BROWSER.equalsIgnoreCase("chrome")) 
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("FIREFOX"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
				else
				{
					System.out.println("invalid browser name");
				}
				
				wUtil.maximiseWindow(driver);
				wUtil.waitForDOMLoad(driver);
				driver.get(URL);
				
				//Login to app
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
				//navigate to Organizations link
				HomePage hp = new HomePage(driver);
				hp.clickOnOrganizationsLink();
				
				//click on craete new Organization
				OrganizationsPage op = new OrganizationsPage(driver);
				op.clickOnCreateOrgImg();
				
				//create new organization with industry and save
				CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
				cnp.createNewOrg(ORGNAME, industry);
				
				//validate
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader=oip.getOrgHeader();
				System.out.println(OrgHeader);
				if(OrgHeader.contains(ORGNAME))
				{
					System.out.println("Pass");
				}
				else
				{
					System.out.println("fail");
				}
				
				//signout
				hp.signOutOfApp(driver);
	}
	
	@DataProvider(name = "OrgData")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtil.readMultipleDataFromExcel("MultipleOrg");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
