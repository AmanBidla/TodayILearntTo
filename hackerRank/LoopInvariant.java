import java.io.*;
import java.util.*;
import java.util.Arrays;

public class LoopInvariant {
    
    public static void insertionSort(int[] A){
  for(int i = 1; i < A.length; i++){
    int value = A[i];
    int j = i - 1;
    System.out.println("comparing "+A[i]+" with "+A[j]+" and A[j] > value "+(A[j] > value));
    while(j >= 0 && A[j] > value){
      A[j + 1] = A[j];
      j = j - 1;
    }
    A[j + 1] = value;
    System.out.println(Arrays.toString(A));
  }
        
        printArray(A);
}

    
    static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
      }
public static void main(String[] args) {
      try{

        Scanner in = new Scanner(new File("input1.txt"));

           while(in.hasNext()){
              int n = Integer.parseInt(in.nextLine());
             if(n>=1 && n<=1000){
             int[] ar = new int[n];
             boolean incorrectValue = false;
             String line = in.nextLine();
             String [] array = line.split(" ");
             for(int i=0;i<n;i++){
              System.out.println(array[i]);
                ar[i]=Integer.parseInt(array[i]);
                if(ar[i]>=-1000 && ar[i]<=-1000){
                    incorrectValue=true;
                    break;
                }
             }
             if(!incorrectValue){
                 insertionSort(ar);               
             }
           }
           


               
           }

      }catch(FileNotFoundException e){
        System.out.println(e.toString());
      }
           
       }    
   }