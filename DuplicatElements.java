import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DuplicatElements {

	public static List<Integer> duplicate(int []array){

		List<Integer> list = new ArrayList<Integer>();
		 
		for(int i=0;i<array.length;i++){


			if(array[Math.abs(array[i])]>0)
				array[Math.abs(array[i])]= - array[Math.abs(array[i])];
			else
				list.add(Math.abs(array[i]));
		}

		return list;
	}

	public static void main(String[] args) {
		int [] array = {1, 2, 3, 1, 3, 6, 6};

		List<Integer> list = duplicate(array);
		System.out.println(Arrays.toString(list.toArray()));
		 

	}

}