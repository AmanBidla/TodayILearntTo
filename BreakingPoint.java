public class BreakingPoint{

	private static int breakingPoint(int [] array){

		int first=0,second=0;

		for(int i:array){
			second+=i;
		}

		for(int i=0;i<array.length;i++){
			first+=array[i];			 
			second-=array[i];			 
			if(first==second) return i;
		}

		return-1;
	}

	public static void main(String[] args) {
		//int []array={1,0,-1,-1,1};
		int [] array = {1,2,3,4,5,2,5,4,4};

		System.out.println(breakingPoint(array));
	}

}