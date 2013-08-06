import java.util.HashSet;
import java.util.Set;
import java.lang.Math;


public class LongestRange{

	public static void main(String[] args) {
		
		//int [] array ={16,1, 12,  5,  4, 10,  2, 11, 13,  3, 15};
		int [] array ={2, 10, 3, 12, 5, 4, 11, 8, 7, 6, 15};

		
		int start=0,end=0,rangeStart=0,rangeEnd=0;

		Set<Integer> s = new HashSet<Integer>();

		for(int i=0;i<array.length;i++){

			 s.add(array[i]);
		}

		int longest =0;

		for(int x:array){

			if(!s.remove(x)) continue;

			

			int range=1;

			for(int i=1;x+i>x;i++){

				if(!s.remove(x+i)) break;

				start = x;

				range++;
			}

			for(int i=1;x-i<x;i++){

				if(!s.remove(x-i)) break;

				range++;
			}

			if(longest<range){

				rangeStart=start;
				longest=range;
				rangeEnd=start+longest-1;	;
			}

		}

		System.out.println("longest: "+longest);	
		System.out.println("start:"+rangeStart);
		System.out.println("end:"+rangeEnd);	 

	}

	 

}