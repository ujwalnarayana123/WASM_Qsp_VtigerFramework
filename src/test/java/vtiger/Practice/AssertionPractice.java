package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void assertPractice()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		sa.assertTrue(false);
		System.out.println("Step 2");
		sa.assertAll(); // logged here it will not execute further
		Assert.assertEquals("B","A"); // hard assert it will stop further execution
		System.out.println("Step 3");
		System.out.println("Step 4");
		
	}
	
	
	@Test
	public void assertPractice1()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("Test script 2 Step 1");
		sa.assertEquals(true, false); //p
		System.out.println("Test script 2 Step 2");
		sa.assertTrue(false); //failed
		System.out.println("Test script 2 Step 3");
		System.out.println("Test script 2 Step 4");
		sa.assertAll(); //mandatory
	}

}
