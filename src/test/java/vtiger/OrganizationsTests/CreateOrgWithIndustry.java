package vtiger.OrganizationsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrgWithIndustry extends BaseClass {

	@Test(groups = "RegressionSuite",retryAnalyzer = vtiger.GenericUtility.RetryAnalyserImplementation.class)
	public void createOrgWithIndTest() throws IOException {
		
       
		String ORGNAME = eUtil.readDataFromExcel("Organization", 4, 2);
		String INDUSTRY = eUtil.readDataFromExcel("Organization", 4, 3);
		
		//navigate to Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		//click on craete new Organization
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		//create new organization with industry and save
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createNewOrg(ORGNAME, INDUSTRY);
		
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
