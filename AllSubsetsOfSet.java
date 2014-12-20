import java.util.ArrayList;
public class AllSubsetsOfSet{


	private static ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> set,int index){

		ArrayList<ArrayList<Integer>> all = null;

		if(index == set.size()){
			all = new ArrayList<ArrayList<Integer>>();
			all.add(new ArrayList<Integer>());
		}else{
			all = getAllSubsets(set,index+1);
			ArrayList<ArrayList<Integer>> more = new ArrayList<ArrayList<Integer>>();
			int item = set.get(index);
			for(ArrayList<Integer> subsets:all){
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.add(item);
				newSubset.addAll(subsets);
				more.add(newSubset);
			}

			all.addAll(more);
		}

		return all;
	}


	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		ArrayList<ArrayList<Integer>> all = getAllSubsets(list,0);
		for(ArrayList<Integer> subset : all){
			show(subset);
		}
	}

	private static void show(ArrayList<Integer> set){
		for(int i:set){
			System.out.print(i+" ");
		}
		System.out.println("");
	}

}