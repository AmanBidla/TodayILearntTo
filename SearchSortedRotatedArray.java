public class SearchSortedRotatedArray {


	public static void main(String[] args) {
		
		int [] sortedRotatedArray ={50,5,20,30,40};
		 
		int index = search(sortedRotatedArray,30);
		System.out.println("element 30"+ ((sortedRotatedArray[index]==30)?" found":" not found"));
		
		 
		index = search(sortedRotatedArray,50);
		System.out.println("element 50"+ ((sortedRotatedArray[index]==50)?" found":" not found"));

		 
		index = search(sortedRotatedArray,40);
		System.out.println("element 40"+ ((sortedRotatedArray[index]==40)?" found":" not found"));

		 
		index = search(sortedRotatedArray,110);
		System.out.println("element 110"+ ((index==-1)?" not found":" Found"));

	}
 

	public static int search(int [] array , int target){
		
		if(array==null || array.length==0){
			return -1;
		}
		int l=0, r= array.length-1;
		while(l<r){
			int m = l+(r-l)/2;
			if(array[m]>= array[l]){
				if(array[m]<=target && target<=array[l]){
					r= m;
				} else{
					l = m+1;
				}
			} else{
				if(array[m]<target && target<=array[r]){
					l = m+1;
				} else{
					r=m;
				}
			}
		}
		return array[l]==target?l:-1;
	}

}