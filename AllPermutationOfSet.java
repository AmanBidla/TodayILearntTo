public class AllPermutationOfSet {

	public static List<List<Integer>> allPermutation(int [] array) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<Integer> item = new HashSet<Integer>();
		if(array==null || array.length==0) {
			return result;
		}
		dfs(array,item,0,result);
		return result;
	}

	private static void dfs(int[]array, Set<Integer> item, int index, List<List<Integer>> result) {
		result.add(new ArrayList<Integer>(item));
		for(int i=index;i<array.length;i++) {
			if(item.contains(array[i])) continue;
			item.add(array[i]);
			
		}
	}

}