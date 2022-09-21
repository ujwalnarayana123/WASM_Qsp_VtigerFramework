package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "phoneData")
	public void addPhonesToCartTest(String name, int price)
	{
		System.out.println(name+" -> "+price);
	}
	
	@DataProvider(name = "phoneData")
	public Object[][] getData()
	{                                //row //column count
		Object[][] data = new Object[3][2];
		
		data[0][0] = "Samsung A80";
		data[0][1] = 12000;
		
		data[1][0] ="Iphone";
		data[1][1] =5000;
		
		data[2][0] = "Vivo";
		data[2][1] = 1000;
		
		return data;
	}
	
	

}
