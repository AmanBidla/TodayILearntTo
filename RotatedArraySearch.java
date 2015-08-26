public class RotatedArraySearch{

	public static void main(String[] args) {
		
		int [] array ={12,11,1,2,3,4};
		//int [] array={3,3,3,3,3,1,3,3};
		int target =3;
		int result = findMin(array,0,array.length-1,3);
		if(result !=-1)
			System.out.println("Found "+target+" at position "+result);
		else 
			System.out.println("Could not find "+target);

		int [] A2={3,3,3,3,3,1,3,3};
		   target =3;
		   result = findMin(A2,0,A2.length-1,3);
		if(result !=-1)
			System.out.println("Found "+target+" at position "+result);
		else 
			System.out.println("Could not find "+target);

	}


	public static int findMin(int [] array, int left, int right, int X){
 		
		if(left>right) return -1;

		int mid= (left+right)/2;

		if(array[mid]==X) return mid;

		if(array[left]<array[mid]){

			if(array[left]<=X && X<=array[right]){
				return findMin(array,left,mid-1,X);
			}else{
				return findMin(array,mid+1,right,X);
			}

		}else if(array[left] > array[mid]){

			if(array[mid]<=X && X<=array[right]){
				return findMin(array,mid+1,right,X);
			}else{
				return findMin(array,left,mid-1,X);
			}
		}else if(array[left]==array[mid]){

			if(array[mid]!=array[right]){
				findMin(array,mid+1,right,X);
			}else{

				int result = findMin(array,left,mid-1,X);
				if(result==-1){
					return findMin(array,mid+1,right,X);
				}else{
					return result;
				}

			}
		}

		return -1;

	}
 
}