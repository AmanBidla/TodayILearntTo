import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class CompareTwoList{

	public static void main(String[] args) {
		
		List<Integer> l1= new ArrayList<Integer>();
		l1.add(5);l1.add(2);l1.add(1);l1.add(6);l1.add(8);
		List<String> l2 = new ArrayList<String>();
		l2.add("steve");l2.add("paul");l2.add("foul");l2.add("mark");l2.add("tomar");

		for(int i=0;i<l1.size();i++){
 			System.out.println(l1.get(i)+" = "+l2.get(i));
 		} 
		quickSort(l1,l2);
		System.out.println("---");
 		for(int i=0;i<l1.size();i++){
 			System.out.println(l1.get(i)+" = "+l2.get(i));
 		} 
 		
	}


   
	public static <T extends Comparable<? super T>> void quickSort(List<T> comp, List<?> l2){

		if(comp.size()<l2.size()) throw new IndexOutOfBoundsException("Incorrect list size");
		sort(comp,0,comp.size()-1,l2);
	}

	private static <T extends Comparable<? super T>> void sort(List<T> comp, int lo, int hi, List<?>l2){

		if(hi<=lo) return;
		int p = partition(comp,lo,hi,l2);
		sort(comp,lo,p-1,l2);
		sort(comp,p+1,hi,l2);
	}

	private static <T extends Comparable<? super T>> int  partition (List<T> comp, int lo, int hi, List<?>l2){

		int i=lo;
		int j=hi+1;
		T v =comp.get(lo);
		//System.out.println("i "+i+" j "+j);
		while(true){

			while(i<hi && (comp.get(i).compareTo(v)<0))
				i++;

			while(j>lo && (v.compareTo(comp.get(i))<0))
				j--;
			System.out.println("i "+i+" j "+j);
			if(i>=j) break;

			swap(comp,l2,i,j);

			System.out.println("i "+i+" j "+j);

		}

		/**/swap(comp,l2,lo,j);
		return j;

		
	} 

    private static <T extends Comparable<? super T>> void swap( List<T> comp, List<?> l2, int i, int j){
    	 
    		Collections.swap(comp,i,j);
    		Collections.swap(l2,i,j);	
    	 
    	
    }


}