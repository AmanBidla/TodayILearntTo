import java.util.Stack;

public class   LargestRect{


	public static void main(String[] args) {
		
		int [] arrary={2,1,5,6,2,3};
		//int [] arrary={6, 2, 5, 4, 5, 2, 6};
		System.out.println(largestRectangleArea(arrary));
	}

 

	static int largestRectangleArea(int[] height) {
	        if (height == null || height.length == 0) return 0;         
	        Stack<Integer> stack = new Stack<Integer>();
	        int maxArea = 0;
	        for (int i = 0; i < height.length; ++i) {
	            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
	                int currHeight = height[stack.pop()];
	                int left = stack.isEmpty() ? -1 : stack.peek();
	                int area = currHeight * (i - left - 1);
	                if (area > maxArea) maxArea = area;
	            }
	            stack.push(i);
	        }
	        return maxArea;
	  }
  }  