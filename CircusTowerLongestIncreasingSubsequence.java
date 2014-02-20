/*Input:
        (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
Output: The longest tower is length 6 and includes from top to bottom: 
        (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190) */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;


public class CircusTowerLongestIncreasingSubsequence {

	private static HtWt[] array;

	static class HtWt implements Comparable<HtWt>{

		int ht,wt;

		public HtWt(int h, int w){
			this.ht=h;
			this.wt=w;
		}

		public int compareTo(HtWt htwt){
			if(ht>htwt.ht) return 1;
			else if (ht<htwt.ht) return -1;
			else return 0;
		}
	}

	public static void main(String[] args) {
		generateTower();
		System.out.println("before");
		show(array);
		System.out.println("\nafter");
		tower(array);


	}

	public static HtWt[] generateTower(){
		     
		
		 array = new HtWt[6];

		array[0]= new HtWt(65, 100);
		array[1]= new HtWt(70, 150);
		array[2]= new HtWt(56, 90);
		array[3]= new HtWt(75, 190);
		array[4]= new HtWt(60, 95);
		array[5]= new HtWt(68, 110);

		return array;


	}


	public static void tower(HtWt[] array){
		List<HtWt> list = new ArrayList<HtWt>();
		for(int i=0;i<array.length;i++)
			list.add(array[i]);
		sortByHeight(list);
		for(int i=0;i<list.size();i++)
			array[i]=list.get(i);

		HtWt []seq = longestIncreasingSub(array);
		show(array);
	}

	private static void show(HtWt[] array){

		for(int i=0;i<array.length;i++){
			System.out.print("("+array[i].ht+","+array[i].wt+") ");
		}
	}

	public static HtWt[] longestIncreasingSub(HtWt [] array){
		int N = array.length;
		int [] dp = new int[N];
		int [] prev = new int[N];
		int ans=0;

		for(int i=0;i<N;i++){
			dp[i]=1;
			prev[i]=-1;
		}

		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){

				if( less(array[i],array[j]) ){

					if(dp[i]+1>dp[j]){
						dp[j]= dp[i]+1;
						prev[j]=i;
					}

					if(dp[j]>dp[ans])
						ans=j;
				}
			}
		}

		HtWt[] seq = new HtWt[dp[ans]];
		int L = dp[ans];

		for(int i=L-1;i>=0;i--){
			seq[i]=array[ans];
			ans=prev[ans];
		}

		return seq;
	}

	public static boolean less(HtWt a, HtWt b){
		return (a.wt <=b.wt);
	}

	public static void sortByHeight(List<HtWt> list){
		Collections.sort(list);
	}


}