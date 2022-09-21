package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	//declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgImg;
	
	//initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreaOrgImg() {
		return createOrgImg;
	}
	
	//Business library
	/**
	 * This Method will click on create Org look up image
	 */
	public void clickOnCreateOrgImg()
	{
		createOrgImg.click();
	}
	
}
