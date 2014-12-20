import java.util.Arrays;
public class CompanySalary{

	private static int find(int [] sal, int cut){
		Arrays.sort(sal);
		int min = sal[0];
		int sum =0;
		for(int s:sal){
			sum+=s;
		}

		int begin = min;
		int end   = sum;

		while(begin <end){

			int mid = begin + (end-begin)/2;			 
			sum=0;

			for(int s:sal){
				if(mid<s)
					sum+=mid;
				else
					sum+=s;
			}
			 
			if(cut==sum)
				return mid;
			else if(sum>cut){
				end=mid;
			}else{
				begin= mid+1;
			}

		}

		return 0;
	}

	public static void main(String[] args) {
		int [] sal ={20,30,40,90,100};
		int cut = 210;
		System.out.println(find(sal,cut));
	}

}