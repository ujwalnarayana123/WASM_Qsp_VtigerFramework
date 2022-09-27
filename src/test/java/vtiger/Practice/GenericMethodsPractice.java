package vtiger.Practice;

public class GenericMethodsPractice {

	// caller
	public static void main(String[] args) {

		int sum = GenericMethodsPractice.add(200, 20);
		System.out.println(sum);
	}

	// called
//	public static void add()
//	{
//		int a=50;
//		int b=10;
//		int c = a+b;
//		System.out.println(c);
//	}

	// called
	public static int add(int a, int b) {
		int c = a + b;
		return c;
	}
}
