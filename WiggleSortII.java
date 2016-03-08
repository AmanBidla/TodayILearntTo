import java.util.Arrays;

public class WiggleSortII {

	public static void main(String[] args) {
		
		
		int [] array = {1,2,2,1,2,1,1,1,1,2,2,2};
		System.out.println("Before " +Arrays.toString(array));
		wiggleSort(array);
		System.out.println("After " +Arrays.toString(array));

		/*int [] anotherArray = {1, 5, 1, 1, 6, 4};
		System.out.println("Before " +Arrays.toString(anotherArray));
		wiggleSort(anotherArray);
		System.out.println("After " +Arrays.toString(anotherArray));*/
		

		/*int [] failArray = {1,3,2,2,3,1};
		System.out.println("Before " +Arrays.toString(failArray));
		wiggleSort(failArray);
		System.out.println("After " +Arrays.toString(failArray));
		*/

		/*int [] array = {4,5,5,6};
		System.out.println("Before " +Arrays.toString(array));
		wiggleSort(array);
		System.out.println("After " +Arrays.toString(array));*/


	}


	public void wiggleSort(int[] nums) {
    if (nums.length <= 1) {
        return;
    }
    final int n = nums.length, d = n | 1; // now (1 + 2 * i) % d will go like 1, 3,... wrap-around, 0, 2,...
    int left = 0, right = nums.length - 1, k = n / 2; // note: 0-based k
    // Do quickselect for kth LARGEST element. Use wiggle-indexing to get the answer right away.
    while (true) {
        assert left <= right;
        int p = nums[(1 + 2 * (left + random.nextInt(right - left + 1))) % d];
        int l = left, m = l;
        for (int r = right, lw = (1 + 2 * l) % d, mw = lw, rw = (1 + 2 * r) % d; m <= r; ) {
            if (nums[mw] > p) {
                int tmp = nums[mw];
                nums[mw] = nums[lw];
                nums[lw] = tmp;
                ++l; lw = (lw + 2) % d;
                ++m; mw = (mw + 2) % d;
            } else if (nums[mw] < p) {
                int tmp = nums[mw];
                nums[mw] = nums[rw];
                nums[rw] = tmp;
                --r; rw = (rw - 2 + d) % d;
            } else { // ==
                ++m; mw = (mw + 2) % d;
            }
        }
        if (k < l - left) {
            right = l - 1;
        } else if (k >= m - left) {
            k -= m - left;
            left = m;
        } else {
            // else we got lucky - p is the median
            return;
        }
    }



    

	public static void wiggleSort(int[] array) {
        
      
      int median = findKthSmallest(array,array.length/2);
      System.out.println("median is "+median);
      System.out.println("array after median "+Arrays.toString(array));


      int k = array.length-1;
      int N = array.length;
      int i =0, j=0;
      while(j<=k){

      	if(array[wiggledIndex(j,N)]>median){
      		swap(array,wiggledIndex(i,N),wiggledIndex(j,N)); 
      		i++;++j;
      	} else if(array[j]<median){
      		swap(array,wiggledIndex(j,N),wiggledIndex(k,N));
      		--k;
      	}else{
      		++j;
      	}
      }
 
    }

    private static int wiggledIndex(int i,int N){
    	return (2 * i + 1) % (N | 1);
    }

    private static int findKthSmallest(int [] array, int k) {

    	int lo=0,hi=array.length-1;
    	while(lo<hi){
    		int i = partition(array,lo,hi);
    		if(i>k){
    			hi=i-1;
    		}else if(i<k){
    			lo=i+1;
    		}else{
    			return array[i];
    		}
    	}
    	return -1;
    }

    private static int partition(int []array,int lo, int hi){

    	int i = lo;
    	int j = hi+1;
    	int v = array[lo];

    	while(true){

    		while(array[i++]<v){
    			if(i>=hi){
    				break;
    			}
    		}

    		while(v<array[--j]){
    			if(j<=lo){
    				break;
    			}
    		}

    		if(i>=j){
    			break;
    		}

    		swap(array,i,j);
    	}

    	swap(array,lo,j);

    	return j;

    }

    
    private static void swap(int []array, int i, int j){
    	System.out.println("swaping "+array[i]+" and "+array[j]);
        int temp = array[i];
        array[i] = array[j];
        array[j]= temp;
    }
    
    private static boolean checkOddCase(int[]array, int a, int b){
        int N = array.length;
        if(a>=0 && b>=0 && a<N && b<N){
            return array[a]<=array[b];
        }else{
            return false;
        }
    }
    
    private static boolean checkEvenCase(int[]array, int a, int b){
        int N = array.length;
        if(a>=0 && b>=0 && a<N && b<N){
            return array[a]>=array[b];
        }else{
            return false;
        }
    }
}