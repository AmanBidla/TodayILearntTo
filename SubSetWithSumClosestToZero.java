import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SubSetWithSumClosestToZero{


	 class Prefixa implements Comparable<Prefixa>{
		
		int index,first,value,findex,lindex;

		public Prefixa(int value, int start, int end){
			this.value=value;
			this.findex=start;
			this.lindex=end;
		}

		public Prefixa(int value, int start){
			this.first = value;
			this.index = start;
		}


		@Override
		public int compareTo(Prefixa p){
			if(first<p.first) return -1;
			else if(first==p.first) return 0;
			else return 1;
		}
	}

	  
	

	private  void subSet(int [] array){
		
		int len = array.length;
		Prefixa [] prefixa = new Prefixa[len];
		prefixa[0] = new Prefixa(array[0],0);
		for(int i=1;i<len;i++)
			prefixa[i]= new Prefixa(((prefixa[i-1]).first+array[i]),i);
			

		//System.out.println("printing prefix array with value and original index");
		//showPrefixa(list);
		
		int start = prefixa[0].first;
		int end = prefixa[len-1].first;

		Arrays.sort(prefixa);

		//System.out.println("printing value after sorting");
		//showPrefixa(prefixa);

		List<Prefixa> pairWiseDiff = new ArrayList<Prefixa>();
		Prefixa[] pairwise = new Prefixa[len-1];

		for(int i=0;i<len-1;i++){
			pairwise[i]=new Prefixa((prefixa[i+1].first-prefixa[i].first),prefixa[i].index,prefixa[i+1].index);
		}

		//System.out.println("printing pairwise diff ");
		//showPairWiseDiff(pairwise,len);

		Prefixa minElement = findMin(pairwise);
		//System.out.println("min element is "+minElement.value+" index start "+minElement.findex+" index end "+minElement.lindex);
		int[] candi = new int[3];

		candi[0]= minElement.value;
		candi[1]=start;
		candi[2]=end;

		int closeZero = findMin(candi);
		List<Integer> vSumZero = new ArrayList<Integer>();

		/*if(closeZero==candi[1]){
			 vSumZero.add(array[0]);
		}else if(closeZero == candi[2]){
			for(int i=0;i<len;i++){
				vSumZero.add(array[i]);
			}
		}else{ */
				int min = Math.min(minElement.findex, minElement.lindex);
				int max = Math.max(minElement.findex, minElement.lindex);
				//System.out.println("max "+max+" min "+min);
				for(int i=0+min+1;i<(0+max+1);i++){
					vSumZero.add(array[i]);
				}
		/*}*/

		for(int i=0;i<vSumZero.size();i++){
			System.out.print(vSumZero.get(i)+" ");
		}
		System.out.println();

	}

	private void showPairWiseDiff(Prefixa[] pairWiseDiff,int len){
		for(int i=0;i<len-1;i++){
			System.out.println("("+pairWiseDiff[i].value+":"+pairWiseDiff[i].findex+":"+pairWiseDiff[i].lindex+")");
		}
	}

	private void showPrefixa(Prefixa[] list){
		for(int i=0;i<list.length;i++){
			int first = (list[i]).first;
			int index = (list[i]).index;
			System.out.println(first+":"+index);
		}
	}

	private int findMin(int [] array){
		int min = array[0];
		for(int i=1;i<array.length;i++){
			if(min>array[i]){
				min = array[i];
			}
		}

		return min;
	}

	private Prefixa findMin(Prefixa[] list){

		Prefixa min = list[0];
		for(int i=1;i<list.length;i++){
			//System.out.println("comparing "+min.value+" with "+list.get(i).value+" is "+(min.value<list.get(i).value));
			if(min.value>list[i].value)
				min=list[i];
		}

		return min;

	}

	public static void main(String[] args) {
		SubSetWithSumClosestToZero s = new SubSetWithSumClosestToZero();
		int array1[] = {8,-3,2,1,-4,10,5};
		System.out.println(Arrays.toString(array1));
		s.subSet(array1);
		int [] array ={-3,2,4,-6,-8,10,11};
		System.out.println(Arrays.toString(array));
		s.subSet(array);
	}



}