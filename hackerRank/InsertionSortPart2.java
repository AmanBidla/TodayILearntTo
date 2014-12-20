import java.io.*;
import java.util.*;

public class InsertionSortPart2{

	  public static void insertionSortPart2(int[] A){       
      	
	  	for(int i = 1; i < A.length; i++){
    int value = A[i];
    int j = i - 1;
     while(j >= 0 && A[j] > value){
      A[j + 1] = A[j];
      j = j - 1;
    }
    A[j + 1] = value;
    printArray(A);
  }
        
        

      }  
    
    
      
    public static void main(String[] args) {
    	try{

    		Scanner sc = new Scanner(new File(args[0]));
    		int s = Integer.parseInt(sc.nextLine());
    		String [] array = sc.nextLine().split(" ");
    		int [] ar = new int[s];
    		for(int i=0;i<s;i++){
            	ar[i]=Integer.parseInt(array[i]);
       		}

			insertionSortPart2(ar);   

    	}catch(FileNotFoundException e){
    		System.out.println(e.toString());
    	}
         
                    
    }

    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }

}