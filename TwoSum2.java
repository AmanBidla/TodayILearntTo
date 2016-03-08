public class TwoSum2{

	Map<Integer,Integer> map = new HashMap<Integer,Integer>();

	public void add(int val){

		Integer freq = map.get(val);
		if(freq == null){
			freq = 1;
		}

		map.put(val, freq);
	}

	public int find(int val){
		for(int i: map.keySet()){

			int nextVal = val-i;

			if(map.containsKey(nextVal)){


				Integer freq = map.get(nextVal);
				if(freq == nextVal && freq <2) continue;
				return true;

			}
		}

		return false;
	}
}