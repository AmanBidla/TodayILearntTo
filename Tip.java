public class Tip {

	private static double tipRate = 15.00;

	public static void main(String [] abc){

		Double amount = Double.valueOf(abc[0]);
		System.out.println("Standard tip rate is "+tipRate+"\n-------------------------");
		System.out.println("Tip = "+calcualteTip(amount));
		int numberOfPersons = 1;
		if(abc.length > 1) {
			numberOfPersons = Integer.valueOf(abc[1]);
		}
		System.out.println("Total per person = "+totalPerPerson(amount, numberOfPersons));
	}

	private static double calcualteTip(double amount){

		double tipAmount = (amount * tipRate)/100;
		return tipAmount;

	}

	private static double totalPerPerson(double amount, int numberOfPersons) {

		double tip = calcualteTip(amount);
		double totalAmount = tip + amount;
		return totalAmount / numberOfPersons;

	}

}