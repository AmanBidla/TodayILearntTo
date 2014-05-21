import java.util.Arrays;
public class NextHighestNumber{


	private static Long nextHighest(final long num){

		int N = Long.toString(num).length();
		if(N<2) return  num;
		int [] array = new int[N];
		long rem= num;
		for(int i=N-1;i>=0;i--){
			array[i]=(int)rem%10;
			rem=rem/10;
		}
		for(int i=N-2;i>=0;i--){
			if(array[i]<array[i+1]){
				int nIndex=0,nHighest=10;
				for(int j=i+1;j<N;j++){
					if((array[j]<nHighest) && (array[j]>array[i])){
						nHighest=array[j];
						nIndex=j;
					}
				}
				int swap = array[i];
				array[i]= array[nIndex];
				array[nIndex]=swap;	
				Arrays.sort(array,i+1,N);
				StringBuilder sb = new StringBuilder();
				for(int d:array){
					sb.append(Integer.toString(d,10));
				}
				return Long.parseLong(sb.toString());
			}
		}
		return num;
	}

	public static void main(String[] args) {
		long l = 34722641;
		long ans = nextHighest(l);
		assert(ans==34724126):" ans is " +ans;
	}

	 
}