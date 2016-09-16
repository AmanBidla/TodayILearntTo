import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GreyCode {


	public static List<Integer> greyCode(int N) {

		if(N==0){
			List<Integer> result = new ArrayList<Integer>();
			result.add(0);
			return result;
		}

		List<Integer> result = greyCode(N-1);
		int mask = 1<<(N-1);

		for(int i=result.size()-1;i>=0;i--) {

			result.add( (result.get(i)+mask) );
		}

		return result;
	}

	public static void main(String[] args) {
		
		List<Integer> result = greyCode(2);
		System.out.println(Arrays.toString(result.toArray()));
	}


}