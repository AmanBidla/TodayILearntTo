/*


There are k lists of sorted integers. Make a min heap of size k containing 1 element from each list. Keep track of min and max element and calculate the range. 
In min heap, minimum element is at top. Delete the minimum element and another element instead of that from the same list to which minimum element belong. Repeat the process till any one of the k list gets empty. 
Keep track of minimum range. 

For eg. 
List 1: [4, 10, 15, 24, 26] 
List 2: [0, 9, 12, 20] 
List 3: [5, 18, 22, 30] 

Min heap of size 3. containing 1 element of each list 
Heap [0, 4, 5] 
Range - 6 

Remove 0 and add 9 
Heap [4, 9, 5] 
Range - 6 

Remove 4 and add 10 
Heap [5, 9, 10] 
Range - 6 

http://www.careercup.com/question?id=16759664

*/


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Iterator;


public class RangeOfKSortedList{

	private int maxRange = Integer.MAX_VALUE;
	private List<ArrayList<Integer>> lists= new ArrayList<ArrayList<Integer>>();

	private class ListRange{

		int minr=0,maxr=0;
		public ListRange(int min, int max){
			this.minr = min;
			this.maxr = max;
		}

	}
	private class Data implements Comparable<Data>{
		int lIndex;
		int index;
		public Data(int lIndex,int index){
			this.lIndex=lIndex;
			this.index=index;
		}

		public int compareTo(Data d){
			//System.out.println("current lIndex "+lIndex+" and index "+index);
			//System.out.println("comparing lIndex "+d.lIndex+" and index "+d.index);
			if(lists.get(lIndex).get(index)<lists.get(d.lIndex).get(d.index))
				return -1;
			else if(lists.get(lIndex).get(index)>lists.get(d.lIndex).get(d.index))
				return 1;
			else return 0;
		}
	}

	public static void main(String[] args) {
		

 		/*ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(4);
		list1.add(10);
		list1.add(15);
		list1.add(24);
		list1.add(26);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(0);
		list2.add(9);
		list2.add(12);
		list2.add(20);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(5);
		list3.add(18);
		list3.add(22);
		list3.add(30);*/
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(1000);
		list1.add(2000);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(20);
		list2.add(1001);
		list2.add(5000);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(55);
		list3.add(1002);
		list3.add(222222);
 

		RangeOfKSortedList rk = new RangeOfKSortedList();

		rk.lists.add(list1);
		rk.lists.add(list2);
		rk.lists.add(list3);

		
		rk.findRange(rk.lists);
	} 

	public void findRange(List<ArrayList<Integer>> lists){

		int N = lists.size();
		PriorityQueue<Data> pQueue = new PriorityQueue<Data>();
		for(int i=0;i<N;i++){
			Data d = new Data(i,0);
			pQueue.add(d);
		}
		ListRange lrange = findRange(pQueue);
		ListRange result = lrange;
		int currRange = lrange.maxr-lrange.minr;
		if(currRange<maxRange){
			maxRange = currRange;
			result = lrange;
		}
		//System.out.println("maxRange Range "+maxRange);

		Data dmin = pQueue.poll();
		int minIndex = dmin.index;
		int listIndex = dmin.lIndex;
		//System.out.println("current minIndex "+minIndex+" for list "+listIndex);
		while(minIndex+1<lists.get(listIndex).size()){
			//System.out.println("current minIndex "+minIndex+" for list "+listIndex+" and maxrange "+maxRange+" current range "+currRange);
			//System.out.println("adding to list "+listIndex+" next element "+lists.get(listIndex).get(minIndex+1));
			Data newData = new Data(listIndex, minIndex+1);
			pQueue.add(newData);
			lrange = findRange(pQueue);
			currRange = lrange.maxr-lrange.minr;			
			if(currRange<maxRange){
				maxRange = currRange;
				//System.out.println(">> max Range "+maxRange);
				result = lrange;
			}
			
			dmin = pQueue.poll();
			minIndex = dmin.index;
			listIndex = dmin.lIndex;
		}
		System.out.println("["+result.minr+","+result.maxr+"]");

	}


	public ListRange findRange(PriorityQueue<Data> pQueue){

		Iterator<Data> it = pQueue.iterator();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		while(it.hasNext()){
			Data d = it.next();
			int currValue = lists.get(d.lIndex).get(d.index);
			//System.out.println("currValue "+currValue);
			if(currValue<min)
				min = currValue;
			if(currValue>max)
				max = currValue;
		}
		//System.out.println("min "+min+" max "+max);
		ListRange l = new ListRange(min,max);
		return l;
	}



}