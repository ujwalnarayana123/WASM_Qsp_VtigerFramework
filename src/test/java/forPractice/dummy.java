package forPractice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;

public class dummy {

		public static void main(String[] args) throws Exception {
			WebDriver driver;
			
			
			//Generate random number
			Random r = new Random();
			int RANDOM = r.nextInt(500);
			
			//Step 1: Read all the necessary data
			//read data from property file ----> Common Data
			FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
	        Properties pObj = new Properties();
	}

}
