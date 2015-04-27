public class RotatedArray{

	public static void main(String[] args) {
		
		int [] array={4,5,6,7,7,7,0,1,2};
		int target=1;
		System.out.println(rotated(array,0,array.length-1,target));
	}

	private static int rotated(int [] array, int left, int right,int target){

		if(left> right) return -1;
		
		while(left<=right){

			int mid= left+(right-left)/2;
			if(array[mid]==target){
				return mid;
			}

			if(array[left]<= array[mid]){

				if(array[left]<=target  && target<array[mid]){
					 right = mid-1;
				}else{
					left=mid+1;
				}
			}else{
				if(array[mid]<target && target<=array[right]){
					left=mid+1;
				}else{
					right=mid-1;
				}
			}
		}
		return -1;
	}
}