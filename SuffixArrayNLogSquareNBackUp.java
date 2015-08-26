import java.util.Comparator;
import java.util.Arrays;

public class SuffixArrayNLogSquareN{

	private static int MAXN =  65536;//Integer.MAX_VALUE;
	private static int MAX_LN = 17;

	static class Entry{

		int nr[]=new int[2];
		int p;

		public String toString(){
			return "nr[0] "+ nr[0]+" nr[1] "+nr[1]+" p "+p;
		}
	}

//
	 
	static Entry [] array = new Entry[MAXN];
	static int [][] matrix = new int [MAX_LN][MAXN];

	public static void build(String S){
		int N = S.length();
		System.out.println(S);
		for(int i=0;i<N;i++){
			int a = (int)(S.charAt(i));			 
			matrix[0][i]=a ;
			System.out.println(matrix[0][i]);
		}

		show(N);

		for(int i=0;i<MAXN;i++){
			array[i] = new Entry();
		}

		for(int stp=1,count=1;count>>1<N;stp++,count<<=1){

			for(int i=0;i<N;i++){
				Entry entry = array[i];
				entry.nr[0] = matrix[stp-1][i];				 
				entry.nr[1] = (i+count<N)?matrix[stp-1][i+count]:-1;				
				entry.p=i;				 
			}
			System.out.println("before sorting --->");
			showEntry(N);

			Arrays.sort(array,0,N,new EntryComparator());
			//Arrays.sort(array,new EntryComparator());
			System.out.println("<--- after sorting ");
			showEntry(N);
 

			/*
			array[0].p=0;
			for(int i=0;i<N;i++){
				Entry entry = array[i];
				Entry entry_MinusOne = array[i-1];
				if(entry.nr[0]==entry_MinusOne.nr[0] &&
								entry.nr[1]==entry_MinusOne.nr[1]){
					matrix[stp][entry.p]=matrix[stp][entry_MinusOne.p];
					
				}else{
					matrix[stp][entry.p]=i;
				}
			}*/

			for(int i=0;i<N;i++){
				if(i>0){
					System.out.print(" array[i].nr[0] "+array[i].nr[0]+" array[i-1].nr[0] "+array[i-1].nr[0]);
					System.out.print(" array[i].nr[1] "+array[i].nr[1]+" array[i-1].nr[1] "+array[i-1].nr[1]);
				}
				matrix[stp][array[i].p]=(i>0 && array[i].nr[0]==array[i-1].nr[0] && array[i].nr[1]==array[i-1].nr[1])
										  ? matrix[stp][array[i-1].p]
										  :i;				 
				System.out.println();
			}
		}

	}

	public static void showEntry(int N){
		for(int i=0;i<N;i++){
			System.out.println(i+". nr[0]= "+array[i].nr[0]+" nr[1]= "+array[i].nr[1]+" p= "+array[i].p);
		}
	}

	static class EntryComparator implements Comparator<Entry>{

		@Override
		public int compare(Entry a, Entry b){

			System.out.println(a.toString()+" and "+b.toString());
			int anr0 = a.nr[0];
			int anr1 = a.nr[1];
			int bnr0 = b.nr[0];
			int bnr1 = b.nr[1];

			if(anr0==bnr0){
				if(anr1<bnr1) return 1;
				else return 0;
			}else{
				if(anr0<bnr0) return 1;
			  	else return 0;
			}
		}
	}

	public static void main(String[] args) {
 		String S ="banana";
 		int N = S.length();
 		build(S);
 		show(N);
 		//System.out.println(Arrays.toString(matrix[MAX_LN-1]));

	}
  
	public static void show(int N ){
		boolean print = false;
		for(int j=0;j<MAX_LN;j++){
			for(int i=0;i<N;i++){
				//if(matrix[j][i]!=0){
					System.out.print(matrix[j][i]+" ");
					print=true;
				//}
			}
			//if(print){
				System.out.println();
				print=false;	
			//}
			
		}
		
	}



}