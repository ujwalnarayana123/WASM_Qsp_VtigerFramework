package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class POMPractice {
	
	public static void main(String[] args) {
		WebDriverUtility w = new WebDriverUtility();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888");
		
		LoginPage lp = new LoginPage(driver);
//		lp.getUserNameEdt().sendKeys("admin");
//		lp.getPasswordEdt().sendKeys("manager");
//		lp.getSubmitBtn().click();
//		
		lp.loginToApp("admin", "manager");
		
		HomePage hp = new HomePage(driver);
//		hp.getProductsLnk().click();
//		
//		w.mouseHoverOn(driver, hp.getAdministratorImg());
//		hp.getSignOutLnk().click();
		
		hp.clickOnProductsLink();
		hp.signOutOfApp(driver);
		
	}

}
