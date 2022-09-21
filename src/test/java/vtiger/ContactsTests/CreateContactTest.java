package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

/**
 * @author Chaitra M
 */
public class CreateContactTest {
	
	@Test
	public void CreateContactTest() throws IOException {
		
		WebDriver driver = null;
		
		//Step 1: create object of all the utilities
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//Step 2: Read all the necessary data
		String BROWSER = pUtil.readDataFromPFile("browser");
		String URL = pUtil.readDataFromPFile("url");
		String USERNAME = pUtil.readDataFromPFile("username");
		String PASSWORD = pUtil.readDataFromPFile("password");
		
		String LASTNAME = eUtil.readDataFromExcel("Contact", 1, 2)+jUtil.getRandomNumber();
		String LEADSOURCE = eUtil.readDataFromExcel("Contact", 1, 3);
		System.out.println(LEADSOURCE);
		
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
		
		//Step 4: login to app
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 5: navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 6: click on create contact
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 7: create new contact with mandatory information and save
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		WebElement ele = driver.findElement(By.name("leadsource"));
		wUtil.handleDropDown(LEADSOURCE, ele);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8: logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.waitForElementToBeVisible(driver, element);
		wUtil.mouseHoverOn(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
