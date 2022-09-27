package vtiger.OrganizationsTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;

public class CreateOrganizationTest extends BaseClass{
	
	@Test
	public void createOrgTest() throws IOException
	{		
		WebDriver driver;
		
		//Generate random number
		Random r = new Random();
		int RANDOM = r.nextInt(500);
		
		//Step 1: Read all the necessary data
		//read data from property file ----> Common Data
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
        Properties pObj = new Properties();
        pObj.load(fisp);
        String BROWSER = pObj.getProperty("browser");
        String URL = pObj.getProperty("url");
        String USERNAME = pObj.getProperty("username");
        String PASSWORD = pObj.getProperty("password");
        
        //read data from Excel Sheet -----> Test Data
        FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
        Workbook wb = WorkbookFactory.create(fise);
        Sheet sh = wb.getSheet("Organization");
        Row rw = sh.getRow(1);
        Cell cel = rw.getCell(2);
        String ORGNAME = cel.getStringCellValue();
        
        //Step 2: launch the browser -- run time polyporphism
        if(BROWSER.equalsIgnoreCase("chrome"))
        {
        	driver = new ChromeDriver();
        	System.out.println("--- chrome browser launched ----");
        }
        else if(BROWSER.equalsIgnoreCase("Firefox"))
        {
        	driver = new FirefoxDriver();
        	System.out.println("---- Firefox browser launched----");
        }
        else
        {
        	System.out.println("-invalid browser name-");
        	driver = new ChromeDriver();
        	System.out.println("--- chrome browser launched ----");
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(URL);
        
        //Step 3: login to app
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
        
        //Step 4: Navigate to Organizations
        driver.findElement(By.linkText("Organizations")).click();
		
        //Step 5: Click on create organization
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
        //Step 6: Create Organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RANDOM);
		
        //Step 7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
        //Step 8: logout
        		
	}
	
	@Test
	public void demoTest()
	{
		System.out.println("This is demo");
	}

}
