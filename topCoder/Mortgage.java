public class Mortgage{

	public static void main(String[] args) {
		
		Mortgage m = new Mortgage();
		/*int loan=1000,interest=50,term=1;*/
		int loan=2000000000,interest=6000,term=1;
		/*int loan=1000000,interest=1000000,term=1000;*/
		System.out.println("monthly payment should be "+m.monthlyPay(loan, interest, term));

	}

	public int monthlyPay(int loan, int interest, int term){
		long lo=0,hi=2000000000,mid=0;
		while(hi>lo+1){
			    mid = (hi+lo)/2;
			   boolean works = highEnough(mid,loan,interest,term);
			   if(works)
			      hi = mid;
			   else 
			      lo = mid;
			}

			System.out.println("mid is "+mid);
				return (int)hi;
	}

	 
		boolean highEnough(long monthly, long owed, int interest, int term){
			   long start = owed;
			   for(int i = 0; i<term*12; i++){
			      owed-=monthly;
			      if(owed<=0)return true;
			      long acrued = (owed * interest + 11999) / 12000;
			      owed = owed + acrued;
			      if(owed > start)return false;
			   }
			   return false;
		}

	 
}