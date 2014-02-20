 /*
 * problem statement 
 * http://community.topcoder.com/stat?c=problem_statement&pm=3970&rd=7993
 *
 *
 */
 public class RateOfInterest{

	public static void main(String[] args) {
		RateOfInterest r = new RateOfInterest();
		 
 		 double price=15000,monthly=364;
 		 int loanTerm=48;
 		 /*double price=2000,monthly=510;
 		 int loanTerm=4;*/
			
		System.out.println("rate of interest is "+r.rate(price,monthly,loanTerm));
		 

	}


	public double rate(double price, double monthly,int loanTerm){
 	final double error =1e-12;
 	double x=0,balance=price,low=0,high=100.00;
		while(low<high){
			x=(low+high)/2;
			if((high-low )<error) break;
				 balance = calcBalance(price, monthly, loanTerm,x/100);
			if(balance>0){
				high=x;
			 
			}
			else{
			 
			 low=x;
			}
			 
		}
		return x*12;	
	} 
        double calcBalance(double price, double monthlyPayment, int loanTerm,
                        double monthlyRate) {
                double balance = price;
                for (int i = 0; i < loanTerm; i++) {
                        balance += balance * monthlyRate - monthlyPayment;
                }
                return balance;
        }
}