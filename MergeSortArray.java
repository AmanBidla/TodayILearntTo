public class MergeSortArray {


	public int[] merge(int [] a){
		if(a.length==1) return a;
		else{
			int mid=a.length/2;
			int [] left = new int[mid];
			int [] right = new int[a.length-mid];
			System.out.println("size of array : "+a.length);
			System.out.println("mid :"+mid);
			System.out.println("left length : "+left.length);
			System.out.println("right length : "+right.length);
			int i=0,j=0;
			for(i=0;i<mid;i++)
				left[i]=a[i];
			for(i=mid,j=0;i<a.length;i++){
				right[j]=a[i];
				j++;
			}
			left=merge(left);
			right=merge(right);
			int [] result= merge_sort(left,right);
			System.out.println("result is :");
			for(i=0;i<result.length;i++)
				System.out.print(result[i]+" ");
			
			System.out.println("\n");
			return result;
		}
	}
	
	public int[] merge_sort(int []left, int[]right){
		
		int k=0,i=0,j=0,m=0;
				System.out.println("left length : "+left.length+" right length : "+right.length+"\n");
		int result[]= new int[left.length+right.length];
		
		System.out.println("left in merge_sort :");
		for(i=0;i<left.length;i++)
			System.out.print(left[i]+" ");
		System.out.println("\n");
		
		System.out.println("right in merge_sort :");
		for(i=0;i<right.length;i++)
			System.out.print(right[i]+" ");
		System.out.println("\n");
		i=0;
		
		while(i<left.length && j<right.length){
			if(left[i]<right[j]){
				System.out.println("adding "+left[i]);
				result[k]=left[i];
				i++;
				k++;
			}else if(left[i]>right[j]){
				System.out.println("adding "+right[j]);
				result[k]=right[j];
				j++;
				k++;
			}else{
				result[k]=left[i];
				k++;
				result[k]=right[j];
				k++;
				i++;
				j++;
			}
 		}
 		if(i==left.length && j<right.length){
			while(j!=right.length){
				result[k]=right[j];
				j++;k++;
 			}
		}else if(j==right.length && i<left.length){
			while(i!=left.length){
				result[k]=left[i];
				i++;k++;
			}
		}
		System.out.println("result in merge_sort :");
		for(i=0;i<result.length;i++)
			System.out.print(result[i]+" ");
		System.out.println("\n");
	
		return result;
	
	}

		public static void main(String abc[]){
			MergeSortArray mg = new MergeSortArray ();
			int []a= {3,5,1,4,2};
			for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
			System.out.println("\n");
			mg.merge(a);
			
		}
}