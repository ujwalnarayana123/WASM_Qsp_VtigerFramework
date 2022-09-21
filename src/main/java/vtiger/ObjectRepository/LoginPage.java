package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //rule 1: create java class page wise
	
	//rule 2:identify all tye web elemenst in the page using @findBY,@FindAll, @findBys
	//Declaration
	@FindBy(name = "user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement PasswordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Business Library
	/**
	 * this method will login to app
	 * @param userName
	 * @param Password
	 */
	public void loginToApp(String userName, String Password)
	{
	   UserNameEdt.sendKeys(userName);
	   PasswordEdt.sendKeys(Password);
	   submitBtn.click();	
	}
	
	

}
