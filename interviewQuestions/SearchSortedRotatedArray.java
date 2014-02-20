public class SearchSortedRotatedArray {


	public static void main(String[] args) {
		
		int [] sortedRotatedArray =r{50,5,20,30,40};
		System.out.println("element 20"++ (search(20)==20)?"found":"not found");

	}


	public static int search(int []a,int lo, int hi, int x){


		if(hi<=lo) return -1;

		int mid = (lo+hi)/2;

		if(a[mid]==x) return x;


		/* if left side is sorted */
		if(a[lo]<a[mid]){

			/* if element is on left side search left half else search right half*/
			if(a[lo]<=x && x<=a[mid])
				return search(a,lo,mid-1,x);
			else 
				return search(a,mid+1,hi,x);

		/* if element is on right side, search right half else search left half*/	
		}else if (a[mid]>a[lo]){  

			if(a[mid]<=x && x<=a[hi])
 				return search(a,mid+1,hi,x);
 			else
 				return search(a,lo,mid-1,x);

 		/* left side contains duplicates */	
		}else if(a[lo]==a[mid]) {

			/* if right side does not contain duplicates search right
			 * else search both sides
			 */
			if(a[mid]!=a[hi])
				return search(a,mid+1,hi,x);
			else{

				int x = search(a,lo,mid-1,x);
				if(x==-1)
					x = search(x,mid+1,hi,x);
				return x;
			}
		}
		return -1;
	}

}