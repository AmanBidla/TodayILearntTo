import java.util.Map;
import java.util.HashMap;
public class TwoSumIII {

	static Map<Integer,Integer> freqMap = new HashMap<>();

	public static void add(int value) {

		Integer freq = freqMap.get(value);

		if(freq == null) {
			freqMap.put( value, 1);
		} else {
			freqMap.put(value, (freq+1));
		}
	}

	public static boolean find( int value ) {

		for(int i : freqMap.keySet()) {
			int nextValue = value-i;
			if (freqMap.containsKey(nextValue)) {
				Integer freq = freqMap.get(nextValue);
				if(i == nextValue && freq < 2) {
					continue;
				}
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		
		add(1); add(3); add(5);
		System.out.println(find(4));

	}
}