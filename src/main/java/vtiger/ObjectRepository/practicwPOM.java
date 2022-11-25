package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class practicwPOM {
	
//	WebDriver driver;
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	public void logintoapplication(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void usernametextbox()
	{
		usernameEdt.sendKeys();
		passwordEdt.sendKeys(null);
		submitButton.click();
	}
	
	
	
}
