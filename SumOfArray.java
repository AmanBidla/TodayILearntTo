public class SumOfArray {

	public static void main(String abd[]){
		int []A1 = {9,2,3};
		int []A2 = {9,2,2};
		
		int [] sum = sum(A1,A2);
		for(int i=0;i<sum.length;i++){
			System.out.print(sum[i]+",");
		}
		System.out.println("");
	} 
	
	public static int [] sum(int [] a1, int []a2){
	
		int s=0,c=0;
		int N1= a1.length;
		int N2=a2.length;
		int [] sum=new int[0];
		if(N1==N2){
			sum= new int[N1];
			for(int i=N1-1;i>=0;i--){
 				int a= a1[i];
				int b= a2[i];
				s=a+b+c;
				c=0;
				if( (s>=10)){
					c=1;
					s=s-10;
				}
 				sum[i]=s;
			}
			
			if(c==1){
 				int []newSum = new int[sum.length+1];
				for(int i=1;i<sum.length+1;i++){
					newSum[i]=sum[i-1];
				}
				newSum[0]=c;
				return newSum;
			}
			return sum;
		
		}
		return sum;
	
	}


}