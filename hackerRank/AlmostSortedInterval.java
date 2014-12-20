import java.io.*;
import java.util.*;

public class AlmostSortedInterval{


	public static void main(String[] args) {
			long [] array;
			array = readFromFile(args[0]);
			System.out.println(Arrays.toString(array));
			//int N = almostSorted(array);

			System.out.println((almostSorted(array)+array.length));

	}



	/*public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           System.out.println(almostSorted(ar)+ar.length);
           
   }*/


	public static long [] readFromFile(String file){
		long [] array= null;
		try
		{

			Scanner sc = new Scanner(new File(file));
			int N = Integer.parseInt(sc.nextLine());
		    array = new long [N];
			String [] ar = sc.nextLine().split(" ");
			for(int i=0;i<N;i++){
				array[i]= Long.parseLong(ar[i]);
			}
			return array;

		}catch(FileNotFoundException e){
			System.out.println(e.toString());
		}

		return array;
	}
	//3 1 2 5 4

	public static long almostSorted(long [] array){
		long N = array.length;
		long count=0;
 			for(int i=0;i<N-1;i++){
				
				long min = array[i];
				long max = array [i];

				int j=i+1;
				while(j<N){

					long next = array[j];
					if(min<next){

						if(max<next){
							//System.out.println("min "+min+" max "+max);
							count++;
							System.out.println(" count "+count);
							max=next;
						}

						j++;

					}else{
						break;
					}

				}	 

				System.out.println("count is "+count);
  			}
 			
		return count;

	}
}
