import java.util.Arrays;

public class MergeTwoSortedArrayInPlace{


	private static int [] merge( int [] a, int [] b){
		
		 
		int N = a.length;
		int M = b.length;

		if((N==0 && M==0) || (M==0 && N!=0)) return a;
		if(N==0 && M!=0) return b;

		int i=N-1,j=M-1;

		int x = N+M-1;

		while(i>=0 && j>=0){
			System.out.println("i "+i+" j "+j+" x "+x+" ");
			if(a[i]<=b[j]) 
				a[x--]=a[i--];
			else
				a[x--]=b[j--]; 
		}

		while(j>=0) a[x--]=b[j--];
		while(i>=0) a[x--]=a[i--];

		return a;
	}


	public static void main(String[] args) {
		
		int [] a= new int[8];
		a[0]=9;
		a[1]=18;
		a[2]=34;
		a[3]=45;

		 

		int [] b= {1,15,26,56};

		a = merge(a,b);
		System.out.println(Arrays.toString(a));

	}
}