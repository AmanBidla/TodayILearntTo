import java.lang.IllegalArgumentException;
import java.util.Arrays;

public class NextHighestNumber{
	


	public static void findNext(long number){

		StringBuilder s = new StringBuilder();
		s.append(number);
		int N = s.length();
		int index=-1,pivot=-1;

		for(int i=N-2;i>=0;i--){
			int a = s.charAt(i)-'0';
			int b = s.charAt(i+1)-'0';
			if(a<b){
				pivot = a;
				index =i;
				break;
			}
		}

		if(pivot==-1) System.out.println(" No such number ")

		else{	

			int nextHighest=Integer.MAX_VALUE, swapIndex=-1;
			for(int i=index+1;i<N;i++){
			int a = s.charAt(i)-'0';
			if(a>pivot && a<nextHighest){
					nextHighest = a;
					swapIndex=i;
				}
			}
 
			System.out.println("before swap "+s);
			s.replace(index,index+1,""+nextHighest);
			s.replace(swapIndex,swapIndex+1,""+pivot);
 			char [] sort = s.substring(index+1).toCharArray();
			Arrays.sort(sort);
			s.replace(index+1,N,String.copyValueOf(sort));
			System.out.println("next highest number is "+s);
		}
		
	}

	 
	public static void main(String[] args) {
		
		Long l =1234675l;
		findNext(l);
		
		l=38276l;
		findNext(l);


	}
}