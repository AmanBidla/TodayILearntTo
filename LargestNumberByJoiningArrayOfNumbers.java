import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;

public class LargestNumberByJoiningArrayOfNumbers{



	public static String largest(int [] A){

		if(A==null || A.length<1) return "";
		int N = A.length;
		String [] array = new String[N];
		
		for(int i=0;i<N;i++){
			array[i]=String.valueOf(A[i]);
		}

		Arrays.sort(array, new Comparator<String>(){

			public int compare(String left, String right){
				String leftRight = left.concat(right);
				String rightLeft = right.concat(left);

				return rightLeft.compareTo(leftRight);
			}

		});	

		String joiner = String.join("", array);

		return joiner;

	}

  public static void main(String[] args) {
  	
  	int [] array = {3, 30, 34, 5, 9};
  	System.out.println( largest(array));

  }
}