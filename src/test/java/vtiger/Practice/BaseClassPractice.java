package vtiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice {
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("before suite");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("afterSuite");
	}
	
	@BeforeClass
	public void bcConfig()
	{
		System.out.println("beforeClass");
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("beforeMethod");
	}
	
	@AfterClass
	public void acConfig()
	{
		System.out.println("afterclass");
	}
	
	@AfterMethod
	public void amConfig()
	{
		System.out.println("aftermethod");
	}
	
	@Test
	public void test1()
	{
		System.out.println("Test - 1");
	}
	
	
	
	
	
	
	
	

}
