import java.util.Stack;
public class MaxHistogramArea{

	public static void main(String[] args) {
		
		int [] array = {1,3,5,7,4};
		System.out.println(maxArea(array));
	}
	private static int maxArea(int [] array){

		int max=0,i=0;
		int N = array.length;
		Stack<Integer> stack = new Stack<Integer>();

		while(i<N){

		 	if( stack.isEmpty() || stack.peek()<=array[i]){
		 		stack.push(array[i]);		 		
		 		i++;
		 	}else{
		 		int count=0;
		 		while(stack.peek()>array[i] && !stack.isEmpty()){
		 			int height = stack.pop();
		 			count++;
		 			max = Math.max(max, (height*count));
		 		}

		 		for(int j=0;j<count+1;j++){
		 			stack.push(array[i]);
		 		}
		 		i++;

		 	}
		}

		int count=0;
 		while(!stack.isEmpty()){
			count++;
			max = Math.max((stack.pop() * count),max);
		}

		return max;

	}

}