package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtility.ListenersImplementation.class)
public class CreateContactWithOrgTest extends BaseClass {

	@Test(groups = { "SmokeSuite", "RegressionSuite" })
	public void CreateContactWithOrgTest() throws IOException {

		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);

		// Navigate to Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		Reporter.log("Click on Organizations Link", true); // low level reporting

		// click on create organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("Click on create Organizations look up image", true);

		// Create organization with mandatory fields and save
		CreateNewOrganizationPage cnp = new CreateNewOrganizationPage(driver);
		cnp.createNewOrg(ORGNAME);
		Reporter.log("new organization created", true);

		// Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();

		System.out.println(orgHeader); // true
		Assert.assertEquals(orgHeader.contains(ORGNAME), true);

		// Navigate to contacts link
		hp.clickOnContactsLink();
		Reporter.log("Click on contacts Link", true);
		// Assert.fail();

		// Click on create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		Reporter.log("Click on create contacts Lookup image", true);

		// Create contact with Organization and save
		CreateNewContactPage cnc = new CreateNewContactPage(driver);
		cnc.createNewContact(LASTNAME, ORGNAME, driver);
		Reporter.log("new contact created with organization ", true);

		// validate for contacts
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		System.out.println(contactHeader);
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		// true

	}

	@Test(groups = "RegressionSuite")
	public void demoRegressionTest() {
		System.out.println("this is regression");

		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		Reporter.log("Click on Organizations Link", true);
		Assert.fail();

	}
}
