import java.util.Arrays;

public class MergeTwoSortedArray{

	public void merge(int[] A1, int [] A2, int M, int N){

	 	if(A1==null || A2==null || A1.length==0 || A2.length==0) return ;		 
		int i=M-1;
		int j=N-1;
		int k=(M+N)-1;
		System.out.println("M "+M+" N "+N+" K "+k);
		while(i>=0 || j>=0){

			if(j<0|| (i>0 && A1[i]>A2[j])){
				A1[k--]=A1[i--];
			}else{
				A1[k--]=A2[j--];
			}
		}
		System.out.println(Arrays.toString(A1));
 	}

	public static void main(String[] args) {
		
		int []A1 ={100,200,300,400,500,600,700,800,0,0,0,0,0};
		int []A2 ={101,301,801};
		MergeTwoSortedArray mg = new MergeTwoSortedArray();
		mg.merge(A1,A2,8,3);


	}

}