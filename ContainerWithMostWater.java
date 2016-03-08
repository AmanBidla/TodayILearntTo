public class ContainerWithMostWater {


	public static int container(int [] heights){

		if(heights == null || heights.length==0){
			return 0;
		}

		int N = heights.length;
		int left=0, right=N-1;
		int area =0;
		while(left < right){

			int currentArea = (right-left) * Math.min(heights[left], heights[right]);
			if(area<currentArea){
				area = currentArea;
				System.out.println("left "+left+" right "+right+" height "+(Math.min(heights[left], heights[right]))+" area "+ area);
			}			 
			if(heights[left] < heights[right]){
				left++;
			}else{
				right--;
			}
		}

		return area;
	}

	public static void main(String[] args) {
		
		int [] array = {1,2,4,2,3,5,3};
		System.out.println(container(array));
	}
}