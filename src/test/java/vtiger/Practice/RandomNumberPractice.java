package vtiger.Practice;

import java.util.Random;

public class RandomNumberPractice {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		int random = r.nextInt(10000);
		System.out.println(random);
	}

}
