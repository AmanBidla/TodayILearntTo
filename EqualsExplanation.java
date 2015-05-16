public class EqualsExplanation{


	public static void main(String[] args) {
		
		String abc ="abc";
		char [] array= {'a','b','c'};
		String newabc = new String(array);

		System.out.println(" abc==newabc "+ (abc==newabc));
		System.out.println(" abc.equals(newabc) "+ abc.equals(newabc));

	}
}