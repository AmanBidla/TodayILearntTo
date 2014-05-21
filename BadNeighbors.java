public class BadNeighbors{


	public static int maxDonations(int[] ar){
		int N = ar.length;
		int [] dp = new int[N];
 		int dp1[]=new int[ar.length];
    int dp2[]=new int[ar.length];
    if(ar.length<1)return 0;
    if(ar.length==1)return ar[0];
    if(ar.length==2)return Math.max(ar[0],ar[1]);
    if(ar.length==3)return Math.max(Math.max(ar[0],ar[1]),ar[2]);
    dp1[0]=ar[0];
    dp1[1]=ar[0];
    for(int i =2;i<ar.length-1;i++)
        dp1[i]=Math.max(dp1[i-2]+ar[i], dp1[i-1]);
    dp2[0]=ar[1];
    dp2[1]=ar[1];
    dp2[2]=Math.max(ar[1],ar[2]);
    for(int i = 2;i<ar.length;i++)
        dp2[i]=Math.max(dp2[i-2]+ar[i], dp2[i-1]);
    return Math.max(dp1[dp1.length-2], dp2[dp2.length-2]);
	}

	public static void main(String[] args) {
		
		int max=0;

		int [] array1 ={10, 3, 2, 5, 7, 8};
		max = maxDonations(array1);
		assert(max==19):" max is "+max;

		int [] array2 = { 11, 15 };
		max = maxDonations(array2);
		assert(max==15):" max is "+max;

		int [] array5={ 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
		6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
		52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
		max = maxDonations(array5);
		assert(max==2926):" max is "+max;
		 
		int [] array4={ 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
		max = maxDonations(array4);
		assert(max==16):" max is "+max;

		int [] array3 = { 7, 7, 7, 7, 7, 7, 7 };
		max = maxDonations(array3);
		assert(max==21):"max is "+max;

	}
	
}