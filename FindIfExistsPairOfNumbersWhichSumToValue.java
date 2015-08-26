import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class FindIfExistsPairOfNumbersWhichSumToValue{

	private static final Map<Integer,Integer> freq = new HashMap<>();

	public static void add(int val){

		if(freq.containsKey(val)){
			freq.put(val, freq.get(val)+1);
		}else{
			freq.put(val,1);
		}
	}

	public static  boolean find (int valToFind){

		Set<Integer> values = freq.keySet();
		for(int val:values) {
			int target = val-valToFind;
			if(freq.containsKey(target)) {
				if(freq.get(target)<2 && val==target) continue;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		add(1);
		add(3);
		add(5);
		System.out.println( find(4));
		System.out.println( find(7));

	}
}