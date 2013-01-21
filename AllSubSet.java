import java.util.ArrayList;
import java.util.Iterator;
public class AllSubSet {



	public static ArrayList<ArrayList<Integer>> getallSubSet(ArrayList<Integer>set,int index){

		ArrayList<ArrayList<Integer>> allSubSets;
		if(set.size()==index){
			allSubSets= new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> emptyset =new ArrayList<Integer>();
			allSubSets.add(emptyset);
			return allSubSets;
		}else{
			allSubSets=getallSubSet(set,index+1);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			int item=set.get(index);
			for(ArrayList<Integer>subset:allSubSets){
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allSubSets.addAll(moresubsets);
			return allSubSets;
		}

	}
public static void main(String ad[]){
	ArrayList<Integer> myset = new ArrayList<Integer>();
	myset.add(1);
	myset.add(2);
	myset.add(3);
	ArrayList<ArrayList<Integer>> allsubsets = getallSubSet(myset,0);
	for(ArrayList<Integer>mysubset:allsubsets){
		Iterator it =mysubset.iterator();
		while(it.hasNext()){
			System.out.print(it.next());
		}
		System.out.println();
	}
}

}