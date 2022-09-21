package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	
	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement ProductsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization - getters & Business Library
	public WebElement getOrganizationLnk() {
		return OrganizationLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitesLnk() {
		return OpportunitesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//Business Logic
	/**
	 * this method will click on organization link
	 */
	public void clickOnOrganizationsLink()
	{
		OrganizationLnk.click();
	}
	
	/**
	 * This method will click on Contacts link
	 */
	public void clickOnContactsLink()
	{
		ContactsLnk.click();
	}
	
	/**
	 * This method will click on products
	 */
	public void clickOnProductsLink()
	{
		ProductsLnk.click();
	}
	
	/**
	 * this method will sign out of app
	 * @param driver
	 */
	public void signOutOfApp(WebDriver driver)
	{
		mouseHoverOn(driver, AdministratorImg);
		SignOutLnk.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
