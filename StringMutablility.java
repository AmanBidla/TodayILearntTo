public class StringMutablility{

	public static void main(String[] args) {
		
		String A ="test";
		String B ="test";
		B= B.toUpperCase();
		System.out.println("A = "+A+" B = "+B);

		A ="test";
		B =A;
		B= B.toUpperCase();
		System.out.println("A = "+A+" B = "+B);

	
	}
}