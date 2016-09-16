import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
  
public class NumberAwareSorting {


	public static void main(String[] args) {
		
		String S ="car truck bus";
		//String S ="car truck 8 4 bus 6 1";
		//String S ="-2 1 4 5 6 8 9";
		//String S="1";

		String [] array = S.split("\\s");
		  
		String[] sortedResult = sort(S.split("\\s"));

		System.out.println(Arrays.toString(array)); 

		justPrintResult(sortedResult, array);		
  		
		//System.out.println(Arrays.toString(storeResult(sortedResult, array)));

	}

	public static void justPrintResult(String [] sortedResult, String [] array){

		int numIndex=0,strIndex=0, temp;
		for(int i=0;i<array.length;i++){

			if(isNumber(array[i])){
				  
				while(numIndex<sortedResult.length  && isAlphabet(sortedResult[numIndex])){
			 		numIndex++;
			 	}
			 				 	   
			 	System.out.print(sortedResult[numIndex]+" "); 
			 	numIndex++;			 	  			 	 
			 	 
			} else {
				 
				while(strIndex <sortedResult.length && isNumber(sortedResult[strIndex])){
			 		strIndex++;
			 	}
			 	 
			 	System.out.print(sortedResult[strIndex]+" ");			 	 
			 	strIndex++;
			}



		}
		System.out.println();
	}

	public static String [] storeResult(String [] sortedResult, String [] array){

		String [] result = new String[sortedResult.length];

		int numIndex=0, strIndex=0;
		for(int i=0;i<array.length;i++){

			 if(isNumber(array[i])){

			 	while(numIndex<sortedResult.length  && isAlphabet(sortedResult[numIndex])){
			 		numIndex++;
			 	}
			 	result[i] = sortedResult[numIndex];
			 	numIndex++;

			 } else {

			 	while(strIndex <sortedResult.length && isNumber(sortedResult[strIndex])){
			 		strIndex++;
			 	}

			 	result[i]= sortedResult[strIndex];
			 	strIndex++;
			 }
		}

		return result;

	}

	public static boolean isNumber(String S){

		if(S.charAt(0)=='-' || S.charAt(0)=='+'){
			return true;
		} else {
			return S.charAt(0)>='0' && S.charAt(0)<='9';
		}
	}

	public static boolean isAlphabet(String S) {

		 return (S.charAt(0)>='a' && S.charAt(0)<='z') || (S.charAt(0)>='A' && S.charAt(0)<='Z');
	}

	public static String[] sort(String [] array){
 
		Arrays.sort(array);
		return array;
	}
}