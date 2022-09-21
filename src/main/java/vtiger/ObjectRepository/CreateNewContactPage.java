package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	//declaration
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDwn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrganizationImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchNowBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	
	//initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getLeadSourceDropDwn() {
		return leadSourceDropDwn;
	}

	public WebElement getOrganizationImg() {
		return OrganizationImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Business Library
	/**
	 * this method will create contact and save
	 * @param lastname
	 */
	public void createNewContact(String lastname) 
	{
		lastnameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	
	/**
	 * this method will create contact with leadsource drop down
	 * @param lastName
	 * @param leadSource
	 */
	public void createNewContact(String lastName,String leadSource)
	{
		lastnameEdt.sendKeys(lastName);
		handleDropDown(leadSource, leadSourceDropDwn);
		saveBtn.click();
	}
	
	/**
	 * this method will create contact with Organization
	 * @param lastName
	 * @param OrgName
	 * @param driver
	 */
	public void createNewContact(String lastName, String OrgName,WebDriver driver)
	{
		lastnameEdt.sendKeys(lastName);
		OrganizationImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(OrgName);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[.='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
	}
	
	
	
	
	
	
	
	
	
}
