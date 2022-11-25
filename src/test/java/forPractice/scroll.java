package forPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scroll {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	Thread.sleep(3000);
	WebElement element = driver.findElement(By.xpath("//a[text()='Contact Us']"));
		 String loc = element.getText();
//		JavascriptExecutor jsc=(JavascriptExecutor) driver; 
//				jsc.executeScript("window.scrollBy"+ loc, element);
//				System.out.println("printed");
	}

}
