import java.lang.NullPointerException;
public class LargestContinugousSum{
	public static void main(String[] args) {
		int array[]={-1,3,-3,3,3,5,-2,-90};
		System.out.println(findLargestContinugousSum(array));
	}

	public static int findLargestContinugousSum(int []array) throws NullPointerException{

		if(array==null) throw new NullPointerException();
		if(array.length==1){
			return array[0];
		}
		int max=-1;
		int current=-1;
		for(int i=0;i<array.length;i++){
			if(current<0)
				current=0;
			current+=array[i];
			if(current>max){
				max=current;
			}
		}
		return max;

	}
}